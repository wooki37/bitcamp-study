package bitcamp.test;

class A {

  {
    System.out.println("111"); // 인스턴스 블
  }
  int v1 = 100;
  {
    System.out.println("222");
  }
  int v2 = 200;
  {
    System.out.println("333");
  }

  public A() { // 생성자의 위치에 상관없이 순서대로 생성된다.
    System.out.println("444");
  }

  public A(int a) { // 생성자의 위치에 상관없이 순서대로 생성된다.
    System.out.println("555");
  }

  public A(int a, int b) { // 생성자의 위치에 상관없이 순서대로 생성된다.
    System.out.println("666");
  }


  public class Exam01 {

    public static void main(String[] args) {
      new A();
      new A();
      new A();
    }
  }
}
