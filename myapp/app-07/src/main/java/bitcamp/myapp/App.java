package bitcamp.myapp;

import java.util.Scanner;

public class App {
  public static void main(String[] args) {
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

    printTitle();

    for (int i = 0; i < MAX_SIZE; i++) {
      inputMember(scanner, i, no, name, breeds, age, gender, address, phone, userId++);
      length++;
      if (!promptContinue(scanner)) {
        break;
      }
    }

    printMembers(length, no, name, breeds, age, gender, address, phone);

    scanner.close();
  }

  static void main(String[] args) {
    System.out.println("동물병원 보호자 목록");
    System.out.println("----------------------------------");
  }

  static void inputMember(Scanner scanner, int i,
      String[] name, String[] breeds, int[] age, char[] gender, int[] no,
      int[] phone, char[] address, int userId) {

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
      scanner.nextLine(); // 입력 값(token)을 읽고 난 후에 남아 있는 줄바꿈 코드를 제거한다.

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

    no[i] = userId;
  }

  static boolean promptContinue(Scanner scanner) {
    System.out.print("입력이 끝나셨습니까?(Y/n) ");
    String response = scanner.nextLine();
    if (!response.equals("") && !response.equalsIgnoreCase("Y")) {
      return false;
    }
    return true;
  }

  static void printMembers(int length, int[] no, String[] name, String[] breeds, int[] age,
  char[] gender, char[] address, int[] phone) {
    System.out.println("---------------------------------------");
    System.out.println("보호자ID, 환자ID, 환자명, 품종, 나이, 주소, 연락처, 성별");
    System.out.println("---------------------------------------");

    for (int i = 0; i < length; i++) {
      System.out.printf("%d, %d, %s, %s, %d, %c, %c, %d, %c\n", no[i], no[i], name[i], breeds[i],
      age[i], address[i], phone[i], gender[i]);
    }
  }
}