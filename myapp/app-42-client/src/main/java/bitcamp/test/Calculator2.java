package bitcamp.test;

public class Calculator2 extends Calculator {
  public int minus(int a, int b) {
    return a - b;
  }

  // 파라미터의 타입이 다르더라도, 개수가 다르더라도, 순서 다르더라도
  // 같은 기능을 수행할 때 통일성 있게 일관되게 사용할 수 있게 해주는 문법
  // => "오버로딩(overloading)"
  public int minus(int a, int b, int c) {
    return a - b - c;
  }

  // 상속 받은 메서드와 같은 기능을 수행하는 메서드에 대해
  // 같은 이름을 부여함으로써 프로그래밍의 일관성을 제공하는 문법
  // => 오버로딩
  public int plus(int a, int b, int c) {
    return a + b + c;
  }
}

// 오버라이딩 vs 오버로딩
// 오더라이딩은 상속 받은 메서드를 서브클래스에 맞게 재정
// 오버로딩 파라미터 순서가 다르고 개수가 다르더라도 일관성 있게
