package bitcamp.myapp_project;

import bitcamp.myapp_project.handler.AnimalHospital;
import bitcamp.myapp_project.handler.BoardHandler;
import bitcamp.myapp_project.handler.Handler;
import bitcamp.util.HospitalList;
import bitcamp.util.LinkedList;
import bitcamp.util.Prompt;

public class App {

  public static void main(String[] args) {

    // 기본 생성자를 이용해 Prompt 인스턴스를 준비한다.
    // => 기본 생성자는 Scanner를 키보드와 연결한다.
    Prompt prompt = new Prompt();

    Handler animalHospital = new AnimalHospital(prompt, "환자", new HospitalList());
    Handler boardHandler = new BoardHandler(prompt, "게시글", new LinkedList());
    Handler readingHandler = new BoardHandler(prompt, "독서록", new LinkedList());

    printTitle();

    printMenu();

    while (true) {
      String menuNo = prompt.inputString("메인> ");
      if (menuNo.equals("0")) {
        break;
      } else if (menuNo.equals("menu")) {
        printMenu();
      } else if (menuNo.equals("1")) {
        animalHospital.execute();
      } else if (menuNo.equals("2")) {
        boardHandler.execute();
      } else if (menuNo.equals("3")) {
        readingHandler.execute();
      } else {
        System.out.println("메뉴 번호가 옭지 않습니다.");
      }
    }
    prompt.close();
  }

  static void printMenu() {
    System.out.println("1. 환자");
    System.out.println("2. 게시글");
    System.out.println("3. 독서록");
    System.out.println("0. 종료");
  }

  static void printTitle() {
    System.out.println("나의 동물병원/게시글/독서록 목록");
    System.out.println("----------------------------------");
  }
}
