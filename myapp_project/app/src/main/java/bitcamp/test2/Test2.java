package bitcamp.test2;

public class Test2 {

  public static void main(String[] args) {

    System.out.println(factorial(5));
  }

  static int factorial(int value) {
    System.out.println(value);
    return factorial(value - 1) * value;
  }
}

