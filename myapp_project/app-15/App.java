package bitcamp.myapp_project;

import bitcamp.myapp_project.handler.AnimalHospital;
import bitcamp.myapp_project.handler.BoardHandler;
import bitcamp.util.Prompt;

public class App {

  public static void main(String[] args) {

    // 기본 생성자를 이용해 Prompt 인스턴스를 준비한다.
    // => 기본 생성자는 Scanner를 키보드와 연결한다.
    Prompt prompt = new Prompt();

    AnimalHospital animalHospital = new AnimalHospital(prompt);
    BoardHandler boardHandler = new BoardHandler(prompt);
    BoardHandler readingHandler = new BoardHandler(prompt);

    printTitle();

    printMenu();

    while (true) {
      String menuNo = prompt.inputString("메인> ");
      if (menuNo.equals("99")) {
        break;
      } else if (menuNo.equals("menu")) {
        printMenu();
      } else if (menuNo.equals("1")) {
        animalHospital.inputMember();
      } else if (menuNo.equals("2")) {
        animalHospital.printMembers();
      } else if (menuNo.equals("3")) {
        animalHospital.viewMember();
      } else if (menuNo.equals("4")) {
        animalHospital.updateMember();
      } else if (menuNo.equals("5")) {
        animalHospital.deleteMember();
      } else if (menuNo.equals("6")) {
        boardHandler.inputBoard();
      } else if (menuNo.equals("7")) {
        boardHandler.printBoards();
      } else if (menuNo.equals("8")) {
        boardHandler.viewBoard();
      } else if (menuNo.equals("9")) {
        boardHandler.updateBoard();
      } else if (menuNo.equals("10")) {
        boardHandler.deleteBoard();
      } else if (menuNo.equals("11")) {
        readingHandler.inputBoard();
      } else if (menuNo.equals("12")) {
        readingHandler.printBoards();
      } else if (menuNo.equals("13")) {
        readingHandler.viewBoard();
      } else if (menuNo.equals("14")) {
        readingHandler.updateBoard();
      } else if (menuNo.equals("15")) {
        readingHandler.deleteBoard();
      } else {
        System.out.println("메뉴 번호가 옭지 않습니다.");
      }
    }

    prompt.close();
  }

  static void printMenu() {
    System.out.println("1. 환자등록");
    System.out.println("2. 환자목록");
    System.out.println("3. 환자조회");
    System.out.println("4. 정보변경");
    System.out.println("5. 정보삭제");
    System.out.println("6. 게시글등록");
    System.out.println("7. 게시글목록");
    System.out.println("8. 게시글조회");
    System.out.println("9. 게시글변경");
    System.out.println("10. 게시글삭제");
    System.out.println("11. 독서록등록");
    System.out.println("12. 독서록목록");
    System.out.println("13. 독서록조회");
    System.out.println("14. 독서록변경");
    System.out.println("15. 독서록삭제");
    System.out.println("99. 종료");
  }

  static void printTitle() {
    System.out.println("나의 동물병원/게시글/독서록 목록");
    System.out.println("----------------------------------");
  }
}
