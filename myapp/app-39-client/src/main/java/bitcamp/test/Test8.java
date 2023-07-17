package bitcamp.test;

import p1.A;

public class Test8 extends A {

  public static void main(String[] args) {
    A obj = new A();
    // TODO Auto-generated method stub
    // obj.v1 = 100; => 접근불가!
    // obj.v2 = 100; => 접근불가!
    // obj.v3 = 100; => 접근불가!
    obj.v4 = 400;
    // obj.m(); => 상속불가가
    Test8 obj2 = new Test8();
    obj2.m3();
    // obj2.v1 = 100; // 원래 A 라는 클래스 멤버만 v1에 접근 가능
    // obj.v2 = 200; => 접근 불가
    obj2.v3 = 300; // 상속 받아서 만든 필드여서 자식 클래스가 접근 가능!
    obj2.v4 = 400;
    obj2.m();// 자식 클래스가 상속 받아서 사용하는 멤버
  }

  static void m2() {

  }

  void m3() {

  }
}
