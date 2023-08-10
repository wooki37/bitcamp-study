package bitcamp.myapp_project;

import bitcamp.myapp.handler.MemberHandler;
import bitcamp.myapp_project.handler.AnimalHospital;
import bitcamp.myapp_project.handler.BoardHandler;
import bitcamp.myapp_project.handler.Handler;
import bitcamp.util.HospitalList;
import bitcamp.util.LinkedList;
import bitcamp.util.MenuPrompt;
import bitcamp.util.Prompt;

public class App {

  public static void main(String[] args) {

    // 기본 생성자를 이용해 Prompt 인스턴스를 준비한다.
    // => 기본 생성자는 Scanner를 키보드와 연결한다.
    MenuPrompt prompt = new MenuPrompt();
    prompt.appendBreadcrumb("메인", getMenu());

    Handler animalHospital = new AnimalHospital(prompt, "환자", new HospitalList());
    Handler boardHandler = new BoardHandler(prompt, "게시글", new LinkedList());
    Handler readingHandler = new BoardHandler(prompt, "독서록", new LinkedList());

    printTitle();

    prompt.printMenu();

    loop: while (true) {
      String menuNo = prompt.inputMenu();
      switch (menuNo) {
        case "0":
          break loop;
        case "1":
          animalHospital.execute();
          break;
        case "2":
          boardHandler.execute();
          break;
        case "3":
          readingHandler.execute();
          break;
      }
    }
    prompt.close();
  }

  static String getMenu() {
    StringBuilder menu = new StringBuilder();
    menu.append("1. 환자\n");
    menu.append("2. 게시글\n");
    menu.append("3. 독서록\n");
    menu.append("0. 종료\n");
    return menu.toString();
  }

  static void printTitle() {
    System.out.println("나의 동물병원/게시글/독서록 목록");
    System.out.println("----------------------------------");
  }
}
