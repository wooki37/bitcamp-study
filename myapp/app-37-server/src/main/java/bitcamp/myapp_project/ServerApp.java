package bitcamp.myapp_project;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import bitcamp.myapp.dao.BoardDao;
import bitcamp.myapp.dao.BoardListDao;
import bitcamp.myapp.vo.Board;
import bitcamp.myapp_project.dao.PatientDao;
import bitcamp.myapp_project.dao.PatientListDao;
import bitcamp.myapp_project.vo.Patient;
import bitcamp.net.RequestEntity;
import bitcamp.net.ResponseEntity;

public class ServerApp {

  int port;
  ServerSocket serverSocket;

  PatientDao patientDao = new PatientListDao("patients.json");
  BoardDao boardDao = new BoardListDao("board.json2");
  BoardDao readingDao = new BoardListDao("reading.json2");

  public ServerApp(int port) throws Exception {
    this.port = port;
  }

  public void close() throws Exception {
    serverSocket.close();
  }

  public static void main(String[] args) throws Exception {
    if (args.length < 1) {
      System.out.println("실행 예) java ... bitcamp.myapp.ServerApp 포트번호");
      return;
    }

    ServerApp app = new ServerApp(Integer.parseInt(args[0]));
    app.execute();
    app.close();
  }

  public void execute() throws Exception {
    System.out.println("[MyList 서버 애플리케이션]");

    this.serverSocket = new ServerSocket(port);
    System.out.println("서버 실행 중...");

    Socket socket = serverSocket.accept();
    DataInputStream in = new DataInputStream(socket.getInputStream());
    DataOutputStream out = new DataOutputStream(socket.getOutputStream());

    while (true) {
      RequestEntity request = RequestEntity.fromJson(in.readUTF());

      String command = request.getCommand();
      System.out.println(command);

      ResponseEntity response = new ResponseEntity();

      if (command.equals("quit")) {
        break;
      }

      switch (command) {
        case "board/list":
          response.status(ResponseEntity.SUCCESS).result(boardDao.list());
          break;
        case "board/insert":
          boardDao.insert(request.getObject(Board.class));
          response.status(ResponseEntity.SUCCESS);
          break;
        case "board/findBy":
          Board board = boardDao.findBy(request.getObject(Integer.class));
          if (board == null) {
            response.status(ResponseEntity.FAILURE).result("해당 번호의 게시글이 없습니다!");
          } else {
            response.status(ResponseEntity.SUCCESS).result(board);
          }
          break;
        case "board/update":
          int value = boardDao.update(request.getObject(Board.class));
          response.status(ResponseEntity.SUCCESS).result(value);
          break;
        case "board/delete":
          value = boardDao.delete(request.getObject(Integer.class));
          response.status(ResponseEntity.SUCCESS).result(value);
          break;
        case "patient/list":
          response.status(ResponseEntity.SUCCESS).result(patientDao.list());
          break;
        case "patient/insert":
          patientDao.insert(request.getObject(Patient.class));
          response.status(ResponseEntity.SUCCESS);
          break;
        case "patient/findBy":
          Patient patient = patientDao.findBy(request.getObject(Integer.class));
          if (patient == null) {
            response.status(ResponseEntity.FAILURE).result("해당 번호의 회원이 없습니다!");
          } else {
            response.status(ResponseEntity.SUCCESS).result(patient);
          }
          break;
        case "patient/update":
          value = patientDao.update(request.getObject(Patient.class));
          response.status(ResponseEntity.SUCCESS).result(value);
          break;
        case "patient/delete":
          value = patientDao.delete(request.getObject(Integer.class));
          response.status(ResponseEntity.SUCCESS).result(value);
          break;
        case "reading/list":
          response.status(ResponseEntity.SUCCESS).result(boardDao.list());
          break;
        case "reading/insert":
          boardDao.insert(request.getObject(Board.class));
          response.status(ResponseEntity.SUCCESS);
          break;
        case "reading/findBy":
          board = boardDao.findBy(request.getObject(Integer.class));
          if (board == null) {
            response.status(ResponseEntity.FAILURE).result("해당 번호의 독서록이 없습니다!");
          } else {
            response.status(ResponseEntity.SUCCESS).result(board);
          }
          break;
        case "reading/update":
          value = boardDao.update(request.getObject(Board.class));
          response.status(ResponseEntity.SUCCESS).result(value);
          break;
        case "reading/delete":
          value = boardDao.delete(request.getObject(Integer.class));
          response.status(ResponseEntity.SUCCESS).result(value);
          break;
        default:
          response.status(ResponseEntity.ERROR).result("해당 명령을 지원하지 않습니다!");
      }

      out.writeUTF(response.toJson());
    }

    in.close();
    out.close();
    socket.close();
  }
}
