package bitcamp.myapp_project;

import bitcamp.myapp.handler.BoardAddListener;
import bitcamp.myapp.handler.BoardDeleteListener;
import bitcamp.myapp.handler.BoardDetailListener;
import bitcamp.myapp.handler.BoardListListener;
import bitcamp.myapp.handler.BoardUpdateListener;
import bitcamp.myapp.handler.FooterListener;
import bitcamp.myapp.handler.HeaderListener;
import bitcamp.myapp.handler.HelloListener;
import bitcamp.myapp_project.handler.AnimalHospitalAddListener;
import bitcamp.myapp_project.handler.AnimalHospitalDeleteListener;
import bitcamp.myapp_project.handler.AnimalHospitalDetailListener;
import bitcamp.myapp_project.handler.AnimalHospitalListListener;
import bitcamp.myapp_project.handler.AnimalHospitalUpdateListener;
import bitcamp.util.BreadcrumbPrompt;
import bitcamp.util.HospitalList;
import bitcamp.util.LinkedList;
import bitcamp.util.Menu;
import bitcamp.util.MenuGroup;

public class App {

  public static void main(String[] args) {

    HospitalList hospitalList = new HospitalList();
    LinkedList boardList = new LinkedList();
    LinkedList readingList = new LinkedList();

    BreadcrumbPrompt prompt = new BreadcrumbPrompt();

    MenuGroup mainMenu = new MenuGroup("메인");

    MenuGroup memberMenu = new MenuGroup("환자");
    memberMenu.add(new Menu("등록", new AnimalHospitalAddListener(hospitalList)));
    memberMenu.add(new Menu("목록", new AnimalHospitalListListener(hospitalList)));
    memberMenu.add(new Menu("조회", new AnimalHospitalDetailListener(hospitalList)));
    memberMenu.add(new Menu("변경", new AnimalHospitalUpdateListener(hospitalList)));
    memberMenu.add(new Menu("삭제", new AnimalHospitalDeleteListener(hospitalList)));
    mainMenu.add(memberMenu);

    MenuGroup boardMenu = new MenuGroup("게시글");
    boardMenu.add(new Menu("등록", new BoardAddListener(boardList)));
    boardMenu.add(new Menu("목록", new BoardListListener(boardList)));
    boardMenu.add(new Menu("조회", new BoardDetailListener(boardList)));
    boardMenu.add(new Menu("변경", new BoardUpdateListener(boardList)));
    boardMenu.add(new Menu("삭제", new BoardDeleteListener(boardList)));
    mainMenu.add(boardMenu);

    MenuGroup readingMenu = new MenuGroup("독서록");
    readingMenu.add(new Menu("등록", new BoardAddListener(readingList)));
    readingMenu.add(new Menu("목록", new BoardListListener(readingList)));
    readingMenu.add(new Menu("조회", new BoardDetailListener(readingList)));
    readingMenu.add(new Menu("변경", new BoardUpdateListener(readingList)));
    readingMenu.add(new Menu("삭제", new BoardDeleteListener(readingList)));
    mainMenu.add(readingMenu);

    Menu helloMenu = new Menu("안녕!");
    helloMenu.addActionListener(new HeaderListener());
    helloMenu.addActionListener(new HelloListener());
    helloMenu.addActionListener(new FooterListener());
    mainMenu.add(helloMenu);

    printTitle();

    mainMenu.execute(prompt);

    prompt.close();
  }

  static void printTitle() {
    System.out.println("나의 동물병원/게시글/독서록 목록");
    System.out.println("----------------------------------");
  }
}
