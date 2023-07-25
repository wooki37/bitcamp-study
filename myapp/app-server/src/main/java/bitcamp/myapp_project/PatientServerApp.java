package bitcamp.myapp_project;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import bitcamp.dao.MySQLBoardDao;
import bitcamp.dao.MySQLPatientDao;
import bitcamp.myapp.dao.BoardDao;
import bitcamp.myapp.handler.BoardAddListener;
import bitcamp.myapp.handler.BoardDeleteListener;
import bitcamp.myapp.handler.BoardDetailListener;
import bitcamp.myapp.handler.BoardListListener;
import bitcamp.myapp.handler.BoardUpdateListener;
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

public class PatientServerApp {

  ExecutorService threadPool = Executors.newFixedThreadPool(10);

  Connection con;
  PatientDao patientDao;
  BoardDao boardDao;
  BoardDao readingDao;

  MenuGroup mainMenu = new MenuGroup("메인");

  int port;

  public PatientServerApp(int port) throws Exception {

    this.port = port;

    con = DriverManager.getConnection("jdbc:mysql://study:1111@localhost:3306/studydb");

    this.patientDao = new MySQLPatientDao(con);
    this.boardDao = new MySQLBoardDao(con, 1);
    this.readingDao = new MySQLBoardDao(con, 2);

    prepareMenu();
  }

  public void close() throws Exception {
    con.close();
  }

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
    }
  }

  private void prepareMenu() {
    MenuGroup patientMenu = new MenuGroup("동물병원");
    patientMenu.add(new Menu("등록", new AnimalHospitalAddListener(patientDao)));
    patientMenu.add(new Menu("목록", new AnimalHospitalListListener(patientDao)));
    patientMenu.add(new Menu("조회", new AnimalHospitalDetailListener(patientDao)));
    patientMenu.add(new Menu("변경", new AnimalHospitalUpdateListener(patientDao)));
    patientMenu.add(new Menu("삭제", new AnimalHospitalDeleteListener(patientDao)));
    mainMenu.add(patientMenu);

    MenuGroup boardMenu = new MenuGroup("게시글");
    boardMenu.add(new Menu("등록", new BoardAddListener(boardDao)));
    boardMenu.add(new Menu("목록", new BoardListListener(boardDao)));
    boardMenu.add(new Menu("조회", new BoardDetailListener(boardDao)));
    boardMenu.add(new Menu("변경", new BoardUpdateListener(boardDao)));
    boardMenu.add(new Menu("삭제", new BoardDeleteListener(boardDao)));
    mainMenu.add(boardMenu);

    MenuGroup readingMenu = new MenuGroup("독서록");
    readingMenu.add(new Menu("등록", new BoardAddListener(readingDao)));
    readingMenu.add(new Menu("목록", new BoardListListener(readingDao)));
    readingMenu.add(new Menu("조회", new BoardDetailListener(readingDao)));
    readingMenu.add(new Menu("변경", new BoardUpdateListener(readingDao)));
    readingMenu.add(new Menu("삭제", new BoardDeleteListener(readingDao)));
    mainMenu.add(readingMenu);

    // Menu helloMenu = new Menu("안녕!");
    // helloMenu.addActionListener(new HeaderListener());
    // helloMenu.addActionListener(new HelloListener());
    // helloMenu.addActionListener(new FooterListener());
    // mainMenu.add(helloMenu);
  }
}
