package bitcamp.myapp.handler;

import bitcamp.util.Prompt;

public class MemberHandler {

  static final int MAX_SIZE = 100;
  static int[] no = new int[MAX_SIZE];
  static String[] name = new String[MAX_SIZE];
  static String[] email = new String[MAX_SIZE];
  static String[] password = new String[MAX_SIZE];
  static char[] gender = new char[MAX_SIZE];

  static int userid = 1;
  static int length = 0;

  static final char MALE = 'M';
  static final char FEMALE = 'W';

  public static void inputMember() {
    if (!available()) {
      System.out.println("더 이상 입력 할 수 없습니다.");
      return;
    }

    name[length] = Prompt.inputString("이름? ");
    email[length] = Prompt.inputString("이메일? ");
    password[length] = Prompt.inputString("암호? ");
    gender[length] = inputGender((char) 0);

    no[length] = userid++;
    length++;
  }

  public static void printMembers() {
    System.out.println("------------------------------");
    System.out.println("번호, 이름, 이메일, 성별");
    System.out.println("------------------------------");

    for (int i = 0; i < length; i++) {
      System.out.printf("%d,    %s,    %s,    %s\n",
          no[i], name[i], email[i],
          toGenderString(gender[i]));
    }
  }

  public static void viewMember() {
    String memberNo = Prompt.inputString("번호? ");
    // 입력 받은 번호를 가지고 배열에서 해당 회원을 찾아야 한다.
    for (int i = 0; i < length; i++) {
      if (no[i] == Integer.parseInt(memberNo)) { // Integer.parseInt(Java lang pkg에 있음) = 문자형을 숫자형으로 변환
        System.out.printf("이름: %s\n", name[i]);
        System.out.printf("이메일: %s\n", email[i]);
        System.out.printf("성별: %c\n", toGenderString(gender[i]));
        return;
      }
    }
    System.out.println("해당 번호의 회원이 없습니다!");
  }

  public static String toGenderString(char gender) {
    return gender == 'M' ? "남성" : "여성";
  }

  // public static void updateMember() {
  // int n = Integer.parseInt(Prompt.inputString("번호? "));
  // name[n - 1] = Prompt.inputString("이름?");
  // email[n - 1] = Prompt.inputString("이메일?");
  // password[n - 1] = Prompt.inputString("새암호?");
  // loop: while (true) {
  // String menuNo = Prompt.inputString("성별? :\n" +
  // " 1. 남자\n" +
  // " 2. 여자\n" +
  // "> ");

  // switch (menuNo) {
  // case "1":
  // gender[n - 1] = MALE;
  // break loop;
  // case "2":
  // gender[n - 1] = FEMALE;
  // break loop;
  // default:
  // System.out.println("무효한 번호입니다.");
  // // }
  // public static String toGenderString(char gender) {
  // return gender == 'M' ? "남성" : "여성";
  // }

  public static void updateMember() {
    String memberNo = Prompt.inputString("번호? ");
    for (int i = 0; i < length; i++) {
      if (no[i] == Integer.parseInt(memberNo)) {
        System.out.printf("이름(%s)? ", name[i]);
        name[i] = Prompt.inputString("");
        System.out.printf("이메일(%s)? ", email[i]);
        email[i] = Prompt.inputString("");
        System.out.printf("새암호? ");
        password[i] = Prompt.inputString("");
        gender[i] = inputGender(gender[i]);
        return;
      }
    }
    System.out.println("해당 번호의 회원이 없습니다!");
  }

  private static char inputGender(char gender) {
    String label;
    if (gender == 0) {
      label = "성별?\n";
    } else {
      label = String.format("성별(%s)?\n", toGenderString(gender));
    }
    loop: while (true) {
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
    // 삭제하려는 회원의 정보가 들어 있는 인덱스를 알아낸다.
    int memberNo = Prompt.inputInt("번호? ");

    int deletedIndex = indexOf(memberNo);
    if (deletedIndex == -1) {
      System.out.println("해당 번호의 회원이 없습니다!");
      return;
    }

    for (int i = deletedIndex; i < length - 1; i++) {
      no[i] = no[i + 1];
      name[i] = name[i + 1];
      email[i] = email[i + 1];
      password[i] = password[i + 1];
      gender[i] = gender[i + 1];
    }

    no[length - 1] = 0;
    name[length - 1] = null;
    email[length - 1] = null;
    password[length - 1] = null;
    gender[length - 1] = (char) 0;

    // length 를 하나 줄인다.
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
    return length < MAX_SIZE; // length 는 배열에 들어간 값의 길이 // MAX_SIZE 는 배열의 최대 값
  }
}