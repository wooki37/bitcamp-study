package bitcamp.myapp;

import bitcamp.myapp_project.handler.AnimalHospital;
import bitcamp.util.Prompt;

public class App {

  public static void main(String[] args) {
    
        printTitle();
    
        printMenu();
    
        while (true) {
          String menuNo = Prompt.inputString("메인> ");
          if (menuNo.equals("6")) {
            break;
          } else if (menuNo.equals("menu")) {
            printMenu();
          } else if (menuNo.equals("1")) {
            AnimalHospital.inputMember();
          } else if (menuNo.equals("2")) {
            AnimalHospital.printMembers();
          } else if (menuNo.equals("3")) {
            AnimalHospital.viewMember();
          } else if (menuNo.equals("4")) {
            AnimalHospital.updateMember();
          } else if (menuNo.equals("5")) {
            AnimalHospital.deleteMember();
          } else {
            System.out.println(menuNo);
          }
        }
    
        Prompt.close();
      }
    
      static void printMenu() {
        System.out.println("1. 회원등록");
        System.out.println("2. 회원목록");
        System.out.println("3. 회원조회");
        System.out.println("4. 회원변경");
        System.out.println("5. 회원삭제");
        System.out.println("6. 종료");
      }
    
      static void printTitle() {
        System.out.println("동물병원 보호자 목록");
        System.out.println("----------------------------------");
      }
    }
    
