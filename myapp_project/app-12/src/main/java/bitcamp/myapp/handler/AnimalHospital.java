package bitcamp.myapp.handler;

import bitcamp.myapp.vo.Member;
import java.util.Scanner;
import bitcamp.myapp_project.vo.Member;
import bitcamp.util.Prompt;

public class AnimalHospital {
  
    static final int MAX_SIZE = 100;
    static Member[] members = new Member[MAX_SIZE];
    static int length = 0;

    public static void inputMember() {
      if (!available()) {
        System.out.println("더 이상 입력할 수 없습니다.");
        return;
      }
  
      Member m = new Member();
      m.setNo(Prompt.inputString("보호자ID? "));
      m.setNo(Prompt.inputString("환자ID? "));
      m.setName(Prompt.inputString("환자명? "));
      m.setBreeds(Prompt.inputString("품종? "));
      m.setAge(Prompt.inputString("나이? "));
      m.setAddress(Prompt.inputString("주소? "));
      m.setPhone(Prompt.inputString("연락처? "));
      m.setGender(inputGender((char) 0));
  
      members[length++] = m;
    }
  
    public static void printMembers() {
      System.out.println("---------------------------------------");
      System.out.println("보호자ID, 환자ID, 환자명, 품종, 나이, 주소, 연락처, 성별");
      System.out.println("---------------------------------------");
  
      for (int i = 0; i < length; i++) {
        Member m = members[i];
        System.out.printf("%d, %d, %s, %s, %d, %s, %d, %s\n", m.getNo(), m.getNo(), m.getName(),
        m.getBreeds(), m.getAge(), m.getAddress(), m.getPhone(), toGenderString(m.getGender()));
      }
    }
  
    public static void viewMember() {
      String memberNo = Prompt.inputString("번호? ");
      for (int i = 0; i < length; i++) {
        Member m = members[i];
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
      return gender == 'M' ? "남성" : "여성";
    }
  
    public static void updateMember() {
      String memberNo = Prompt.inputString("보호자ID 번호? ");
      for (int i = 0; i < length; i++) {
        Member m = members[i];
        if (m.getNo() == Integer.parseInt(memberNo)) {
          System.out.printf("환자ID(%d)? ", m.getNo());
          m.setName(Prompt.inputString(" "));
          System.out.printf("환자명(%s)? ", m.getName());
          m.setName(Prompt.inputString(" "));
          System.out.printf("품종(%s)? ", m.getBreeds());
          m.setBreeds(Prompt.inputString(" "));
          System.out.printf("나이(%d)? ", m.getAge());
          m.setAge(Prompt.inputString(" "));
          System.out.printf("주소(%s)? ", m.getAddress());
          m.setAddress(Prompt.inputString(" "));
          System.out.printf("연락처(%d)? ", m.getPhone());
          m.setphone(Prompt.inputString(" "));
          m.setGender(inputGender(m.getGender()));
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
        System.out.println("해당 번호의 회원이 없습니다.");
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
        if (m.getNo == memberNo) {
          return i;
        }
      }
      return -1;
    }
  
    private static boolean available() {
      return length < MAX_SIZE; // length 는 배열에 들어간 값의 길이 // MAX_SIZE 는 배열의 최대 값
    }
  }
