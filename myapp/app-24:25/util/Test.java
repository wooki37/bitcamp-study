package bitcamp.myapp_project.util;

public class Test {

  public static void main(String[] args) {
    ArrayList<String> names = new ArrayList<>();
    names.add(new String("홍길동"));
    names.add("임꺽정");
    names.add("유관순");
    names.add("안중근");

    // Object[] arr = names.toArray();
    // String[] arr = names.toArray(new String[names.size()]);
    String[] arr = new String[3];
    String[] temp = names.toArray(arr);

    System.out.println(arr == temp);

    for (String item : temp) {
      System.out.println(item);
    }
  }
}
