package bitcamp.myapp;

public class App {
  public static void main(String[] args) {
    System.out.println("동물병원 보호자 목록");
    System.out.println("----------------------------------");

    int no = 100;
    String name = "강하루";
    String breeds = "하이랜드폴드";
    int age = 3;
    int phone = 01000001111
    boolean working = true;
    char gender = 'M';
    char address = 'M';

    System.out.printf("보호자 ID: %d\n", no);
    System.out.printf("환자 ID: %d\n", no);
    System.out.printf("환자명: %s\n", name);
    System.out.printf("품종: %s\n", breeds);
    System.out.printf("나이: %d\n", age);
    SSystem.out.printf("주소: %s\n", address);
    System.out.printf("성별(남자(M), 여자(W)): %c\n", gender);
    System.out.printf("연락처: %d\n", phone);
  }
}

