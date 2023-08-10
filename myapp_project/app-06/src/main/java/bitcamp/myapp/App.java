package bitcamp.myapp;

// 코드 본문에서 사용할 클래스가 어떤 패키지의 클래스인지 지정한다.
import java.util.Scanner;

public class App {
  public static void main(String[] args) {
    System.out.println("동물병원 보호자 목록");
    System.out.println("----------------------------------");

    // 키보드 스캐너 준비
    Scanner scanner = new Scanner(System.in);

    final int MAX_SIZE = 100;
    int userId = 1;
    int length = 0;

    int[] no = new int[SIZE];
    String[] name = new String[SIZE];
    String[] breeds = new String[SIZE];
    int[] age = new int[SIZE];
    char[] gender = new char[SIZE];
    char[] address = new char[SIZE];
    int[] phone = new int[SIZE];

    // 동물병원 보호자 등록
    for (int i = 0; i < MAX_SIZE; i++) {

      System.out.print("보호자ID? ");
      no[i] = scanner.nextInt();

      System.out.print("환자ID? ");
      no[i] = scanner.nextInt();

      System.out.print("환자명? ");
      name[i] = scanner.next();

      System.out.print("품종? ");
      breeds[i] = scanner.next();

      System.out.print("나이? ");
      age[i] = scanner.nextInt();

      System.out.print("주소? ");
      String str = scanner.next();
      address[i] = str.charAt(0);

      System.out.print("연락처? ");
      phone[i] = scanner.nextFloat();

      loop: while (true) {
        System.out.println("성별: ");
        System.out.println("  1. 남자");
        System.out.println("  2. 여자");
        System.out.print("> ");
        String menuNo = scanner.next();

        // if (menuNo.equals("1")) {
        // gender[i] = 'M';
        // break;
        // } else if (menuNo.equals("2")) {
        // gender[i] = 'W';
        // break;
        // } else {
        // System.out.println("무효한 번호입니다.");
        // }

        switch (menuNo) {
          case "1":
            gender[i] = 'M';
            break loop;
          case "2":
            gender[i] = 'W';
            break loop;
          default:
            System.out.println("무효한 번호입니다.");
        }
      }

      no[i] = userId++;

      length++;

      System.out.print("입력이 끝나셨습니까?(Y/n) ");
      scanner.nextLine(); // 이전에 next()를 실행한 후 남아 있던 줄바꿈 코드를 제거한다.
      String response = scanner.nextLine();
      if (!response.equals("") && !response.equalsIgnoreCase("Y")) {
        break;
      }
    }

    System.out.println("---------------------------------------");

    System.out.println("보호자ID, 환자ID, 환자명, 품종, 나이, 주소, 연락처, 성별");
    System.out.println("---------------------------------------");

    for (int i = 0; i < length; i++) {
      System.out.printf("%d, %d, %s, %s, %d, %c, %c, %d, %c\n", no[i], no[i], name[i], breeds[i],
      age[i], address[i], phone[i], gender[i]);
    }
    scanner.close();
  }
}