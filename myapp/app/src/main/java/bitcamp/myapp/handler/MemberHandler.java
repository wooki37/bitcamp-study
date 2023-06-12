package bitcamp.myapp.handler;

import bitcamp.myapp.vo.Member;
import bitcamp.util.Prompt;

public class MemberHandler {

  static final int MAX_SIZE = 100;
  static Member[] members = new Member[MAX_SIZE];
  static int length = 0;

  public static void inputMember() {
    if (!available()) {
      System.out.println("더 이상 입력 할 수 없습니다.");
      return;
    }

    Member m = new Member();
    m.setName(Prompt.inputString("이름? "));
    m.setEmail(Prompt.inputString("이메일? "));
    m.setPassword(Prompt.inputString("암호? "));
    m.setGender(inputGender((char) 0));

    // 위에서 만든 Member 인스턴스의 주소를 읽어버리지 않게
    // 레퍼런스 배열에 담는다.
    members[length++] = m;

  }

  public static void printMembers() {
    System.out.println("------------------------------");
    System.out.println("번호, 이름, 이메일, 성별");
    System.out.println("------------------------------");

    for (int i = 0; i < length; i++) {
      Member m = members[i];
      System.out.printf("%d,    %s,    %s,    %s\n", m.getNo(), m.getName(), m.getEmail(),
          toGenderString(m.getGender()));
    }
  }

  public static void viewMember() {
    String memberNo = Prompt.inputString("번호? ");
    // 입력 받은 번호를 가지고 배열에서 해당 회원을 찾아야 한다.
    for (int i = 0; i < length; i++) {
      Member m = members[i];
      if (m.getNo() == Integer.parseInt(memberNo)) { // Integer.parseInt(Java lang pkg에 있음) = 문자형을
                                                     // 숫자형으로
        // 변환
        System.out.printf("이름: %s\n", m.getName());
        System.out.printf("이메일: %s\n", m.getEmail());
        System.out.printf("성별: %c\n", toGenderString(m.getGender()));
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
      Member m = members[i];
      if (m.getNo() == Integer.parseInt(memberNo)) {
        System.out.printf("이름(%s)? ", m.getName());
        m.setName(Prompt.inputString(""));
        System.out.printf("이메일(%s)? ", m.getEmail());
        m.setEmail(Prompt.inputString(""));
        System.out.printf("새암호? ");
        m.setPassword(Prompt.inputString(""));
        m.setGender(inputGender(m.getGender()));
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

    while (true) {
      String menuNo = Prompt.inputString(label + " 1. 남자\n" + " 2. 여자\n" + "> ");

      switch (menuNo) {
        case "1":
          return Member.MALE;
        case "2":
          return Member.FEMALE;
        default:
          System.out.println("무효한 번호입니다.");
      }
    }
  }

  public static void deleteMember() {

    int memberNo = Prompt.inputInt("번호? ");

    int deletedIndex = indexOf(memberNo);
    if (deletedIndex == -1) {
      System.out.println("해당 번호의 회원이 없습니다!");
      return;
    }

    for (int i = deletedIndex; i < length - 1; i++) {
      members[i] = members[i + 1];
    }

    members[--length] = null;
  }

  private static int indexOf(int memberNo) {
    for (int i = 0; i < length; i++) {
      Member m = members[i];
      if (m.getNo() == memberNo) {
        return i;
      }
    }
    return -1;
  }

  private static boolean available() {
    return length < MAX_SIZE; // length 는 배열에 들어간 값의 길이 // MAX_SIZE 는 배열의 최대 값
  }
}
