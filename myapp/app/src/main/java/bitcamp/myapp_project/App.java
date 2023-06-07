package bitcamp.myapp_project;

import bitcamp.myapp_project.handler.AnimalHospital;
import bitcamp.util.Prompt;

public class App {

  public static void main(String[] args) {

    printTitle();

    while (AnimalHospital.available()) {
      AnimalHospital.inputMember();
      if (!promptContinue()) {
        break;
      }
    }

    AnimalHospital.printMembers();

    Prompt.close();
  }

  static void printTitle() {
    System.out.println("동물병원 보호자 목록");
    System.out.println("----------------------------------");
  }

  static boolean promptContinue() {
    String response = Prompt.inputString("입력이 끝나셨습니까?(Y/n) ");
    if (!response.equals("") && !response.equalsIgnoreCase("Y")) {
      return false;
    }
    return true;
  }
}
