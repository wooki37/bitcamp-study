package bitcamp.myapp;

// 코드 본문에서 사용할 클래스가 어떤 패키지의 클래스인지 지정한다.
import org.checkerframework.checker.units.qual.A;
import bitcamp.myapp.handler.MemberHandler;
import bitcamp.util.Prompt;

public class App {

  public static void main(String[] args) {
    printTitle();
    // 키보드 스캐너 준비

    while (MemberHandler.available()) {
      MemberHandler.inputMember();
      if (!promptContinue()) {
        break;
      }
    }

    MemberHandler.printMembers();

    Prompt.close();
  }

  static void printTitle() {
    System.out.println("나의 목록 관리 시스템"); // <- 문자열 스트림 리터럴
    System.out.println("----------------------------");
  }

  static boolean promptContinue() {
    String response = Prompt.inputString("계속 하시겠습니까?(Y/n) ");
    if (!response.equals("") && !response.equalsIgnoreCase("Y")) {
      return false;
    }
    return true;
  }

}
