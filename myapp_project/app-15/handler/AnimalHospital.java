package bitcamp.myapp_project.handler;

import java.util.Scanner;
import bitcamp.myapp_project.vo.Member;
import bitcamp.util.Prompt;

public class AnimalHospital {

  private static final int MAX_SIZE = 100;
  private Prompt prompt;
  private Member[] members = new Member[MAX_SIZE];
  private int length;

  public AnimalHospital(Prompt prompt) {
    this.prompt = prompt;
  }

  public void inputMember() {
    if (!this.available()) {
      System.out.println("더 이상 입력할 수 없습니다.");
      return;
    }

    Member m = new Member();
    m.setNo(Integer.parseInt(this.prompt.inputString("보호자ID? ")));
    m.setNo(Integer.parseInt(this.prompt.inputString("환자ID? ")));
    m.setName(this.prompt.inputString("환자명? "));
    m.setBreeds(getMemberBreed());
    m.setAge(Integer.parseInt(this.prompt.inputString("나이? ")));
    m.setAddress(this.prompt.inputString("주소? "));
    m.setPhone(Integer.parseInt(this.prompt.inputString("연락처?(010) ")));
    m.setGender(inputGender((char) 0));

    this.members[this.length++] = m;
  }

  private String getMemberBreed() {
    boolean isValidNum = true; // 입력된 번호가 유효한지 여부
    String num = null;
    String breedType = null;
    while (isValidNum) {

      num = this.prompt.inputString("품종? 1. 강아지, 2.고양이. 3.직접입력").trim(); // trim() : 입력된 문자열의 양쪽 공백 제거
      if ("1".equals(num)) {
        breedType = "강아지";
        isValidNum = false;
      } else if ("2".equals(num)) {
        breedType = "고양이";
        isValidNum = false;
      } else if ("3".equals(num)) {
        breedType = this.prompt.inputString("품종 타입을 직접 입력해주세요 > ");
        isValidNum = false;
      } else { // isValidNum 변수는 여전히 true이므로 루프가 반복됩니다.
        System.out.println("입력에 없는 번호입니다. 다시 입력해주세요");
      }
    }
    return breedType;
  }

  public void printMembers() {
    System.out.println("-----------------------------------------------------------------------");
    System.out.println("보호자ID/환자ID/  환자명/ 품종/ 나이/ 주소/ 연락처/ 성별");
    System.out.println("-----------------------------------------------------------------------");

    for (int i = 0; i < this.length; i++) {
      Member m = this.members[i];
      System.out.printf("%d/,    %d/,%s/,  %s/,  %d/, %s/,(010)%d/, %s\n", m.getNo(), m.getNo(), m.getName(),
          m.getBreeds(), m.getAge(), m.getAddress(), m.getPhone(), toGenderString(m.getGender()));
    }
  }

  public void viewMember() {
    String memberNo = this.prompt.inputString("번호? ");
    for (int i = 0; i < this.length; i++) {
      Member m = this.members[i];
      if (m.getNo() == Integer.parseInt(memberNo)) {
        System.out.printf("보호자ID: %d\n", m.getNo());
        System.out.printf("환자ID: %d\n", m.getNo());
        System.out.printf("환자명: %s\n", m.getName());
        System.out.printf("품종: %s\n", m.getBreeds());
        System.out.printf("나이: %d\n", m.getAge());
        System.out.printf("주소: %s\n", m.getAddress());
        System.out.printf("연락처: %d\n", m.getPhone());
        System.out.printf("성별: %s\n", toGenderString(m.getGender()));
        return;
      }
    }
    System.out.println("해당 번호의 회원이 없습니다!");
  }

  public static String toGenderString(char gender) {
    return gender == 'M' ? "수컷" : "암컷";
  }

  public void updateMember() {
    String memberNo = this.prompt.inputString("보호자ID 번호? ");
    for (int i = 0; i < this.length; i++) {
      Member m = this.members[i];
      if (m.getNo() == Integer.parseInt(memberNo)) {
        m.setNo(this.prompt.inputInt("환자ID: %d\n", m.getNo()));
        m.setName(this.prompt.inputString("환자명: %s\n", m.getName()));
        m.setBreeds(this.prompt.inputString("품종: %s\n", m.getBreeds()));
        m.setAge(this.prompt.inputInt("나이: %d\n", m.getAge()));
        m.setAddress(this.prompt.inputString("주소: %s\n", m.getAddress()));
        m.setPhone(this.prompt.inputInt("연락처: %d\n", m.getPhone()));
        m.setGender(inputGender(m.getGender()));
        return;
      }
    }
    System.out.println("해당 번호의 ID가 없습니다.");
  }

  private char inputGender(char gender) {
    String label;
    if (gender == 0) {
      label = "성별?\n";
    } else {
      label = String.format("성별(%s)?\n", toGenderString(gender));
    }
    while (true) {
      String menuNo = this.prompt.inputString(label +
          " 1. 수컷\n" +
          " 2. 암컷\n" +
          "> ");

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

  public void deleteMember() {
    int memberNo = this.prompt.inputInt("번호? ");

    int deletedIndex = indexOf(memberNo);
    if (deletedIndex == -1) {
      System.out.println("해당 번호의 ID가 없습니다.");
      return;
    }

    for (int i = deletedIndex; i < this.length - 1; i++) {
      this.members[i] = this.members[i + 1];
    }

    this.members[--this.length] = null;

  }

  private int indexOf(int memberNo) {
    for (int i = 0; i < this.length; i++) {
      Member m = this.members[i];
      if (m.getNo() == memberNo) {
        return i;
      }
    }
    return -1;
  }

  private boolean available() {
    return this.length < MAX_SIZE; // length 는 배열에 들어간 값의 길이 // MAX_SIZE 는 배열의 최대 값
  }
}