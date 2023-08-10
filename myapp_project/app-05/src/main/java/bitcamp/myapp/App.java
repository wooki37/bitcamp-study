package bitcamp.myapp;

// 코드 본문에서 사용할 클래스가 어떤 패키지의 클래스인지 지정한다.
import java.util.Scanner;

public class App {
  public static void main(String[] args) {
    System.out.println("동물병원 보호자 목록");
    System.out.println("----------------------------------");

    // 키보드 스캐너 준비
    Scanner scanner = new Scanner(System.in);

    final int SIZE = 100;

    int[] no = new int[SIZE];
    String[] name = new String[SIZE];
    String[] breeds = new String[SIZE];
    int[] age = new int[SIZE];
    char[] gender = new char[SIZE];
    char[] address = new char[SIZE];
    int[] phone = new int[SIZE];


    for (int i = 0; i < SIZE; i++) {
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

      System.out.print("성별(남자:M, 여자:W)? ");
      String str = scanner.next();
      gender[i] = str.charAt(0);

      System.out.print("연락처? ");
      phone[i] = scanner.nextFloat();
    }

    System.out.println("---------------------------------------");

    for (int i = 0; i < SIZE; i++) {
      System.out.printf("보호자 ID: %d\n", no[i]);
      System.out.printf("환자 ID: %d\n", no[i]);
      System.out.printf("환자명: %s\n", name[i]);
      System.out.printf("품종: %s\n", breeds[i]);
      System.out.printf("나이: %d\n", age[i]);
      SSystem.out.printf("주소: %s\n", address[i]);
      System.out.printf("성별(남자(M), 여자(W)): %c\n", gender[i]);
      System.out.printf("연락처: %d\n", phone[i]);
    }
    scanner.close();
  }
}