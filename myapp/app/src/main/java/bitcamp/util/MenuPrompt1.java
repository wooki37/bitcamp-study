package bitcamp.util;

public class MenuPrompt1 extends Prompt {
  private Queue1 commandHistory = new Queue1();
  private Stack1 menus = new Stack1();
  private Stack1 breadcrumbs = new Stack1();

  public void appendBreadcrumb(String title, String menu) {
    this.breadcrumbs.push(title);
    this.menus.push(menu);
  }

  public void removeBreadcrumb() {
    this.breadcrumbs.pop();
    this.menus.pop();
  }

  public void printMenu() {
    System.out.println(menus.peek());
  }

  public void printCommandHistory() {
    for (int i = 0; i < commandHistory.size(); i++) {
      System.out.println(commandHistory.get(i));
    }
  }

  public String inputMenu() {
    StringBuilder titleBuilder = new StringBuilder();
    for (int i = 0; i < this.breadcrumbs.size(); i++) {
      if (titleBuilder.length() > 0) {
        titleBuilder.append("/");
      }
      titleBuilder.append(this.breadcrumbs.get(i));
    }
    titleBuilder.append("> ");
    String command = null;

    while (true) {
      command = this.inputString(titleBuilder.toString());
      if (command.equals("histroy")) {
        printCommandHistory();
      } else if (command.equals("menu")) {
        this.printMenu();
      } else if (findMenuItem(command) == null) {
        System.out.println("메뉴 번호가 옳지 않습니다!");
      } else {
        break;
      }
    }
    if (this.commandHistory.size() == 10) {
      this.commandHistory.poll();
    }
    String menuItem = findMenuItem(command);
    if (menuItem != null) {
      this.commandHistory.offer(titleBuilder.toString() + ": " + menuItem);
    } else {
      this.commandHistory.offer(command);
    }
    return command;
  }

  private String findMenuItem(String command) {
    String menuTitle = null;
    String menu = (String) menus.peek();
    String[] menuItems = menu.split("\n");
    for (String menuItem : menuItems) {
      if (menuItem.startsWith(command)) {
        return menuItem;
      }
    }
    return menuTitle;
  }
}
