package bitcamp.myapp_project;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import bitcamp.myapp.dao.BoardDao;
import bitcamp.myapp.dao.MySQLBoardDao;
import bitcamp.myapp.handler.BoardAddListener;
import bitcamp.myapp.handler.BoardDeleteListener;
import bitcamp.myapp.handler.BoardDetailListener;
import bitcamp.myapp.handler.BoardListListener;
import bitcamp.myapp.handler.BoardUpdateListener;
import bitcamp.myapp_project.dao.MySQLPatientDao;
import bitcamp.myapp_project.dao.PatientDao;
import bitcamp.myapp_project.handler.AnimalHospitalAddListener;
import bitcamp.myapp_project.handler.AnimalHospitalDeleteListener;
import bitcamp.myapp_project.handler.AnimalHospitalDetailListener;
import bitcamp.myapp_project.handler.AnimalHospitalListListener;
import bitcamp.myapp_project.handler.AnimalHospitalUpdateListener;
import bitcamp.myapp_project.handler.AnimalLoginListener;
import bitcamp.net.NetProtocol;
import bitcamp.util.BreadcrumbPrompt;
import bitcamp.util.Menu;
import bitcamp.util.MenuGroup;
import bitcamp.util.SqlSessionFactoryProxy;

public class PatientServerApp {

  ExecutorService threadPool = Executors.newFixedThreadPool(2);

  SqlSessionFactory sqlSessionFactory;
  PatientDao patientDao;
  BoardDao boardDao;


  MenuGroup mainMenu = new MenuGroup("메인");

  int port;

  public PatientServerApp(int port) throws Exception {

    this.port = port;

    // 1) mybatis 설정 파일을 읽어들일 도구를 준비한다.
    InputStream mybatisConfigIn =
        Resources.getResourceAsStream("bitcamp/myapp/config/mybatis-config.xml");

    // 2) SqlSessionFactory를 만들어줄 빌더 객체 준비
    SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();

    // 3) 빌더 객체를 통해 SqlSessionFactory를 생성
    sqlSessionFactory = new SqlSessionFactoryProxy(builder.build(mybatisConfigIn));

    this.patientDao = new MySQLPatientDao(sqlSessionFactory);
    this.boardDao = new MySQLBoardDao(sqlSessionFactory);

    prepareMenu();
  }

  public void close() throws Exception {}

  public static void main(String[] args) throws Exception {
    PatientServerApp app = new PatientServerApp(8888);
    app.execute();
    app.close();
  }

  public void execute() {
    try (ServerSocket serverSocket = new ServerSocket(this.port)) {
      System.out.println("서버 실행 중...");

      while (true) {
        Socket socket = serverSocket.accept();
        threadPool.execute(() -> processRequest(socket));
      }
    } catch (Exception e) {
      System.out.println("서버 실행 중 오류!");
      e.printStackTrace();
    }
  }

  private void processRequest(Socket socket) {
    try (Socket s = socket;
        DataInputStream in = new DataInputStream(socket.getInputStream());
        DataOutputStream out = new DataOutputStream(socket.getOutputStream())) {

      BreadcrumbPrompt prompt = new BreadcrumbPrompt(in, out);

      InetSocketAddress patientAddress = (InetSocketAddress) socket.getRemoteSocketAddress();
      System.out.printf("%s 클라이언트 접속함!\n", patientAddress.getHostString());

      out.writeUTF("[나의 목록 관리 시스템]\n" + "----------------------------------------------");

      new AnimalLoginListener(patientDao).service(prompt);

      mainMenu.execute(prompt);
      out.writeUTF(NetProtocol.NET_END);

    } catch (Exception e) {
      System.out.println("클라이언트 통신 오류!!");
      e.printStackTrace();
    } finally {
      ((SqlSessionFactoryProxy) sqlSessionFactory).clean();
    }
  }

  private void prepareMenu() {
    MenuGroup patientMenu = new MenuGroup("동물병원");
    patientMenu.add(new Menu("등록", new AnimalHospitalAddListener(patientDao, sqlSessionFactory)));
    patientMenu.add(new Menu("목록", new AnimalHospitalListListener(patientDao)));
    patientMenu.add(new Menu("조회", new AnimalHospitalDetailListener(patientDao)));
    patientMenu
        .add(new Menu("변경", new AnimalHospitalUpdateListener(patientDao, sqlSessionFactory)));
    patientMenu
        .add(new Menu("삭제", new AnimalHospitalDeleteListener(patientDao, sqlSessionFactory)));
    mainMenu.add(patientMenu);

    MenuGroup boardMenu = new MenuGroup("게시글");
    boardMenu.add(new Menu("등록", new BoardAddListener(1, boardDao, sqlSessionFactory)));
    boardMenu.add(new Menu("목록", new BoardListListener(1, boardDao)));
    boardMenu.add(new Menu("조회", new BoardDetailListener(1, boardDao, sqlSessionFactory)));
    boardMenu.add(new Menu("변경", new BoardUpdateListener(1, boardDao, sqlSessionFactory)));
    boardMenu.add(new Menu("삭제", new BoardDeleteListener(1, boardDao, sqlSessionFactory)));
    mainMenu.add(boardMenu);

    MenuGroup readingMenu = new MenuGroup("독서록");
    readingMenu.add(new Menu("등록", new BoardAddListener(2, boardDao, sqlSessionFactory)));
    readingMenu.add(new Menu("목록", new BoardListListener(2, boardDao)));
    readingMenu.add(new Menu("조회", new BoardDetailListener(2, boardDao, sqlSessionFactory)));
    readingMenu.add(new Menu("변경", new BoardUpdateListener(2, boardDao, sqlSessionFactory)));
    readingMenu.add(new Menu("삭제", new BoardDeleteListener(2, boardDao, sqlSessionFactory)));
    mainMenu.add(readingMenu);

    // Menu helloMenu = new Menu("안녕!");
    // helloMenu.addActionListener(new HeaderListener());
    // helloMenu.addActionListener(new HelloListener());
    // helloMenu.addActionListener(new FooterListener());
    // mainMenu.add(helloMenu);
  }
}
