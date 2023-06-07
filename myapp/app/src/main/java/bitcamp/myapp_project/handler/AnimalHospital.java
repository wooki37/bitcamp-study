package bitcamp.myapp_project.handler;

import java.util.Scanner;

import bitcamp.util.Prompt;

public class AnimalHospital {

  static final int SIZE = 100;
  static int[] no = new int[SIZE];
  static String[] name = new String[SIZE];
  static String[] breeds = new String[SIZE];
  static int[] age = new int[SIZE];
  static char[] gender = new char[SIZE];
  static String[] address = new String[SIZE];
  static int[] phone = new int[SIZE];

  static final int MAX_SIZE = 100;

  static int userid = 1;
  static int length = 0;

  static final char MALE = 'M';
  static final char FEMALE = 'W';

  public static void inputMember() {

    no[length] = Integer.parseInt(Prompt.inputString("보호자ID? "));
    no[length] = Integer.parseInt(Prompt.inputString("환자ID? "));
    name[length] = Prompt.inputString("환자명? ");
    breeds[length] = Prompt.inputString("품종? ");
    age[length] = Integer.parseInt(Prompt.inputString("나이? "));
    address[length] = Prompt.inputString("주소? ");
    phone[length] = Integer.parseInt(Prompt.inputString("연락처? "));

    loop: while (true) {

      String menuNo = Prompt.inputString("성별: \n" +
          " 1. 남자\n" +
          " 2. 여자\n" +
          "> ");

      switch (menuNo) {
        case "1":
          gender[length] = MALE;
          break loop;
        case "2":
          gender[length] = FEMALE;
          break loop;
        default:
          System.out.println("무효한 번호입니다.");
      }
    }
    no[length] = userid++;
    length++;
  }

  public static void printMembers() {
    System.out.println("---------------------------------------");
    System.out.println("보호자ID, 환자ID, 환자명, 품종, 나이, 주소, 연락처, 성별");
    System.out.println("---------------------------------------");

    for (int i = 0; i < length; i++) {
      System.out.printf("%d, %d, %s, %s, %d, %c, %c, %d, %c\n", no[i], no[i], name[i], breeds[i],
          age[i], address[i], phone[i], gender[i]);
    }
  }

  public static boolean available() {
    return (length < MAX_SIZE); // length 는 배열에 들어간 값의 길이 // MAX_SIZE 는 배열의 최대 값
  }

}
