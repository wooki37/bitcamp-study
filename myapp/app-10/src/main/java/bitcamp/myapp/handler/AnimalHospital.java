package bitcamp.myapp.handler;

import java.util.Scanner;

import bitcamp.util.Prompt;

public class AnimalHospital {

  static final int MAX_SIZE = 100;
  static int[] no = new int[MAX_SIZE];
  static String[] name = new String[MAX_SIZE];
  static String[] breeds = new String[MAX_SIZE];
  static int[] age = new int[MAX_SIZE];
  static char[] gender = new char[MAX_SIZE];
  static String[] address = new String[MAX_SIZE];
  static int[] phone = new int[MAX_SIZE];

  static int userId = 1;
  static int length = 0;

  static final char MALE = 'M';
  static final char FEMALE = 'W';

  public static void inputMember() {
    if (!available()) {
      System.out.println("더 이상 입력할 수 없습니다.");
      return;
    }

    no[length] = Integer.parseInt(Prompt.inputString("보호자ID? "));
    no[length] = Integer.parseInt(Prompt.inputString("환자ID? "));
    name[length] = Prompt.inputString("환자명? ");
    breeds[length] = Prompt.inputString("품종? ");
    age[length] = Integer.parseInt(Prompt.inputString("나이? "));
    address[length] = Prompt.inputString("주소? ");
    phone[length] = Integer.parseInt(Prompt.inputString("연락처? "));
    gender[length] = inputGender((char) 0);

    no[length] = userId++;
    length++;
  }

  public static void printMembers() {
    System.out.println("---------------------------------------");
    System.out.println("보호자ID, 환자ID, 환자명, 품종, 나이, 주소, 연락처, 성별");
    System.out.println("---------------------------------------");

    for (int i = 0; i < length; i++) {
      System.out.printf("%d, %d, %s, %s, %d, %s, %d, %c\n", no[i], no[i], name[i], breeds[i],
          age[i], address[i], phone[i], toGenderString(gender[i]));
    }
  }

  public static void viewMember() {
    String memberNo = Prompt.inputString("번호? ");
    for (int i = 0; i < length; i++) {
      if (no[i] == Integer.parseInt(memberNo)) {
        System.out.printf("보호자ID: %d\n", no[i]);
        System.out.printf("환자ID: %d\n", no[i]);
        System.out.printf("환자명: %s\n", name[i]);
        System.out.printf("품종: %s\n", breeds[i]);
        System.out.printf("나이: %d\n", age[i]);
        System.out.printf("주소: %s\n", address[i]);
        System.out.printf("연락처: %d\n", phone[i]);
        System.out.printf("성별: %c\n", toGenderString(gender[i]));
        return;
      }
    }
    System.out.println("해당 번호의 회원이 없습니다!");
  }

  public static String toGenderString(char gender) {
    return gender == 'M' ? "남성" : "여성";
  }

  public static void updateMember() {
    String memberNo = Prompt.inputString("보호자ID 번호? ");
    int i;
    for (i = 0; i < length; i++) {
      if (no[i] == Integer.parseInt(memberNo)) {
        System.out.printf("환자ID(%d)? ", no[i]);
        name[i] = Prompt.inputString(" ");
        System.out.printf("환자명(%s)? ", name[i]);
        name[i] = Prompt.inputString(" ");
        System.out.printf("품종(%s)? ", breeds[i]);
        breeds[i] = Prompt.inputString(" ");
        System.out.printf("나이(%d)? ", age[i]);
        age[i] = Integer.parseInt(Prompt.inputString(" "));
        System.out.printf("주소(%s)? ", address[i]);
        address[i] = Prompt.inputString(" ");
        System.out.printf("연락처(%d)? ", phone[i]);
        phone[i] = Integer.parseInt(Prompt.inputString(" "));
        gender[i] = inputGender(gender[i]);
        return;
      }
    }
    System.out.println("해당 번호의 회원이 없습니다.");
  }

  private static char inputGender(char gender) {
    String label;
    if (gender == 0) {
      label = "성별?\n";
    } else {
      label = String.format("성별(%s)?\n", toGenderString(gender));
    }
    while (true) {
      String menuNo = Prompt.inputString(label +
          " 1. 남자\n" +
          " 2. 여자\n" +
          "> ");

      switch (menuNo) {
        case "1":
          return MALE;
        case "2":
          return FEMALE;
        default:
          System.out.println("무효한 번호입니다.");
      }
    }
  }

  public static void deleteMember() {
    int memberNo = Prompt.inputInt("번호? ");

    int deletedIndex = indexOf(memberNo);
    if (deletedIndex == -1) {
      System.out.println("해당 번호의 회원이 없습니다.");
      return;
    }

    for (int i = deletedIndex; i < length - 1; i++) {
      no[i] = no[i + 1];
      name[i] = name[i + 1];
      breeds[i] = breeds[i + 1];
      age[i] = age[i + 1];
      address[i] = address[i + 1];
      phone[i] = phone[i + 1];
      gender[i] = gender[i + 1];
    }

    no[length - 1] = 0;
    name[length - 1] = null;
    breeds[length - 1] = null;
    age[length - 1] = 0;
    address[length - 1] = null;
    phone[length - 1] = 0;
    gender[length - 1] = (char) 0;

    length--;
  }

  private static int indexOf(int memberNo) {
    for (int i = 0; i < length; i++) {
      if (no[i] == memberNo) {
        return i;
      }
    }
    return -1;
  }

  private static boolean available() {
    return (length < MAX_SIZE); // length 는 배열에 들어간 값의 길이 // MAX_SIZE 는 배열의 최대 값
  }
}
