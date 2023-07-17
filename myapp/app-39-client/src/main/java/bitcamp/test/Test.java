package bitcamp.test;

public class Test {

  public static void main(String[] args) {
    Object c = new Calculator2(); // 인스턴스를 따지지 않는다. Object 클래스는 모든 클래스를 정
                                  // 컴파일러는 문장 문장마다 옳고 그름만 따진다.
    // Calculator2 c2 = (Calculator2) c;

    System.out.println(((Calculator2) c).minus(100, 200)); // 다형적 변수 +
    System.out.println(((Calculator) c).plus(100, 200));
  }
}
