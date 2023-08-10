package bitcamp.myapp_project;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import bitcamp.myapp.handler.BoardAddListener;
import bitcamp.myapp.handler.BoardDeleteListener;
import bitcamp.myapp.handler.BoardDetailListener;
import bitcamp.myapp.handler.BoardListListener;
import bitcamp.myapp.handler.BoardUpdateListener;
import bitcamp.myapp.handler.FooterListener;
import bitcamp.myapp.handler.HeaderListener;
import bitcamp.myapp.handler.HelloListener;
import bitcamp.myapp.vo.Board;
import bitcamp.myapp_project.handler.AnimalHospitalAddListener;
import bitcamp.myapp_project.handler.AnimalHospitalDeleteListener;
import bitcamp.myapp_project.handler.AnimalHospitalDetailListener;
import bitcamp.myapp_project.handler.AnimalHospitalListListener;
import bitcamp.myapp_project.handler.AnimalHospitalUpdateListener;
import bitcamp.myapp_project.vo.Patient;
import bitcamp.util.BreadcrumbPrompt;
import bitcamp.util.Menu;
import bitcamp.util.MenuGroup;

public class App {

  ArrayList<Patient> hospitalList = new ArrayList<>();
  LinkedList<Board> boardList = new LinkedList<>();
  LinkedList<Board> readingList = new LinkedList<>();

  BreadcrumbPrompt prompt = new BreadcrumbPrompt();

  MenuGroup mainMenu = new MenuGroup("메인");

  public App() {
    prepareMenu();
  }

  public static void main(String[] args) {
    new App().execute();
  }

  static void printTitle() {
    System.out.println("나의 동물병원/게시글/독서록 목록 관리 시스템");
    System.out.println("--------------------------------------------");
  }

  public void execute() {
    printTitle();

    loadData();
    mainMenu.execute(prompt);
    saveData();

    prompt.close();
  }

  private void loadData() {
    loadPatient("patients.data2", hospitalList);
    loadBoard("borad.data22", boardList);
    loadBoard("reading.data22", readingList);
  }

  private void saveData() {
    savePatient("patients.data2", hospitalList);
    saveBoard("borad.data22", boardList);
    saveBoard("reading.data22", readingList);
  }

  private void prepareMenu() {
    MenuGroup patientMenu = new MenuGroup("환자");
    patientMenu.add(new Menu("등록", new AnimalHospitalAddListener(hospitalList)));
    patientMenu.add(new Menu("목록", new AnimalHospitalListListener(hospitalList)));
    patientMenu.add(new Menu("조회", new AnimalHospitalDetailListener(hospitalList)));
    patientMenu.add(new Menu("변경", new AnimalHospitalUpdateListener(hospitalList)));
    patientMenu.add(new Menu("삭제", new AnimalHospitalDeleteListener(hospitalList)));
    mainMenu.add(patientMenu);

    MenuGroup boardMenu = new MenuGroup("게시글");
    boardMenu.add(new Menu("등록", new BoardAddListener(boardList)));
    boardMenu.add(new Menu("목록", new BoardListListener(boardList)));
    boardMenu.add(new Menu("조회", new BoardDetailListener(boardList)));
    boardMenu.add(new Menu("변경", new BoardUpdateListener(boardList)));
    boardMenu.add(new Menu("삭제", new BoardDeleteListener(boardList)));
    mainMenu.add(boardMenu);

    MenuGroup readingMenu = new MenuGroup("독서록");
    readingMenu.add(new Menu("등록", new BoardAddListener(readingList)));
    readingMenu.add(new Menu("목록", new BoardListListener(readingList)));
    readingMenu.add(new Menu("조회", new BoardDetailListener(readingList)));
    readingMenu.add(new Menu("변경", new BoardUpdateListener(readingList)));
    readingMenu.add(new Menu("삭제", new BoardDeleteListener(readingList)));
    mainMenu.add(readingMenu);

    Menu helloMenu = new Menu("안녕!");
    helloMenu.addActionListener(new HeaderListener());
    helloMenu.addActionListener(new HelloListener());
    helloMenu.addActionListener(new FooterListener());
    mainMenu.add(helloMenu);

  }

  private void loadPatient(String filename, List<Patient> list) {
    try {
      FileInputStream in0 = new FileInputStream(filename);
      BufferedInputStream in1 = new BufferedInputStream(in0); // <== Decorator 역할을 수행!
      ObjectInputStream in = new ObjectInputStream(in1); // <== Decorator 역할을 수행!

      int size = in.readShort();

      for (int i = 0; i < size; i++) {
        list.add((Patient) in.readObject());
      }

      if (list.size() > 0) {
        // 데이터를 로딩한 이후에 추가할 회원의 번호를 설정한다.
        Patient.userId = hospitalList.get(hospitalList.size() - 1).getNo() + 1;
      }

      in.close();

    } catch (Exception e) {
      System.out.println("환자 정보를 읽는 중 오류 발생!");
    }
  }

  private void loadBoard(String filename, List<Board> list) {
    try {
      FileInputStream in0 = new FileInputStream(filename);
      BufferedInputStream in1 = new BufferedInputStream(in0); // <== Decorator 역할을 수행!
      ObjectInputStream in = new ObjectInputStream(in1); // <== Decorator 역할을 수행!

      int size = in.readShort();

      for (int i = 0; i < size; i++) {
        list.add((Board) in.readObject());
      }

      if (list.size() > 0) {
        Board.boardNo = Math.max(Board.boardNo, list.get(list.size() - 1).getNo() + 1);
      }

      in.close();

    } catch (Exception e) {
      System.out.println(filename + " 파일을 읽는 중 오류 발생!");
    }
  }

  private void savePatient(String filename, List<Patient> list) {
    try {
      FileOutputStream out0 = new FileOutputStream(filename);
      BufferedOutputStream out1 = new BufferedOutputStream(out0); // <== Decorator(장식품) 역할 수행!
      ObjectOutputStream out = new ObjectOutputStream(out1); // <== Decorator(장식품) 역할 수행!

      out.writeShort(hospitalList.size());

      for (Patient patient : hospitalList) {
        out.writeObject(patient);
      }
      out.close();
    } catch (Exception e) {
      System.out.println("환자 정보를 저장하는 중 오류 발생!");
    }
  }

  private void saveBoard(String filename, List<Board> list) {
    try {
      FileOutputStream out0 = new FileOutputStream(filename);
      BufferedOutputStream out1 = new BufferedOutputStream(out0); // <== Decorator(장식품) 역할 수행!
      ObjectOutputStream out = new ObjectOutputStream(out1); // <== Decorator(장식품) 역할 수행!

      out.writeShort(list.size());

      for (Board board : list) {
        out.writeObject(board);
      }
      out.close();
    } catch (Exception e) {
      System.out.println(filename + "파일을 저장하는 중 오류 발생!");
    }
  }
}
