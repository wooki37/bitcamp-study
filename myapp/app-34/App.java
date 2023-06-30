package bitcamp.myapp_project;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.lang.reflect.Method;
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
import bitcamp.myapp.vo.CsvObject;
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
    loadCsv("patients.csv", hospitalList, Patient.class);
    loadCsv("borad.csv2", boardList, Board.class);
    loadCsv("reading.csv2", readingList, Board.class);
  }

  private void saveData() {
    saveCsv("patients.csv", hospitalList);
    saveCsv("borad.csv2", boardList);
    saveCsv("reading.csv2", readingList);
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

  @SuppressWarnings("unchecked")
  private <T extends CsvObject> void loadCsv(String filename, List<T> list, Class<T> clazz) {
    try {

      Method factoryMethod = clazz.getDeclaredMethod("fromCsv", String.class);

      FileReader in0 = new FileReader(filename);
      BufferedReader in = new BufferedReader(in0); // <== Decorator 역할을 수행!

      String line = null;

      while ((line = in.readLine()) != null) {
        // Reflection API를 사용하여 스태틱 메서드 호출
        list.add((T) factoryMethod.invoke(null, line));
        // list.add(Member.fromCsv(line)); // 직접 스태틱 메서드 호출
      }

      in.close();

    } catch (Exception e) {
      System.out.println(filename + "파일을 읽는 중 오류 발생!");
    }
  }

  private void saveCsv(String filename, List<? extends CsvObject> list) {
    try {
      FileWriter out0 = new FileWriter(filename);
      BufferedWriter out1 = new BufferedWriter(out0); // <== Decorator(장식품) 역할 수행!
      PrintWriter out = new PrintWriter(out1); // <== Decorator(장식품) 역할 수행!

      for (CsvObject obj : list) {
        out.println(obj.toCsvString());
        // Board나 Member 클래스에 필드가 추가/변경/삭제되더라도
        // 여기 코드를 변경할 필요가 없다.
        // 이것이 Information Expert 설계를 적용하는 이유다!
        // 설계를 어떻게 하느냐에 따라 유지보수가 쉬워질 수도 있고,
        // 어려워질 수도 있다.
      }
      out.close();

    } catch (Exception e) {
      System.out.println(filename + "파일을 저장하는 중 오류 발생!");
    }
  }
}
