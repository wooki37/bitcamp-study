package bitcamp.myapp;

// 코드 본문에서 사용할 클래스가 어떤 패키지의 클래스인지 지정한다.
import java.util.Scanner;

public class App {
  public static void main(String[] args) {
    System.out.println("동물병원 보호자 목록");
    System.out.println("----------------------------------");

    // 키보드 스캐너 준비
    Scanner scanner = new Scanner(System.in);

    System.out.print("보호자ID? ");
    int no = scanner.nextInt();

    System.out.print("환자ID? ");
    int no = scanner.nextInt();

    System.out.print("환자명? ");
    String name = scanner.next();

    System.out.print("품종? ");
    String breeds = scanner.next();

    System.out.print("나이? ");
    int age = scanner.nextInt();

    System.out.print("주소? ");
    String str = scanner.next();
    char address = str.charAt(0);

    System.out.print("성별(남자:M, 여자:W)? ");
    String str = scanner.next();
    char gender = str.charAt(0);

    System.out.print("연락처? ");
    int phone = scanner.nextInt();

    System.out.println("---------------------------------------");

    System.out.printf("보호자 ID: %d\n", no);
    System.out.printf("환자 ID: %d\n", no);
    System.out.printf("환자명: %s\n", name);
    System.out.printf("품종: %s\n", breeds);
    System.out.printf("나이: %d\n", age);
    SSystem.out.printf("주소: %s\n", address);
    System.out.printf("성별(남자(M), 여자(W)): %c\n", gender);
    System.out.printf("연락처: %d\n", phone);

    scanner.close();
  }
}

