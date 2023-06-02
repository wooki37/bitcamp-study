package com.eomcs.lang.ex05;

//# 증감 연산자 : 후위(post-fix) 증가 연산자
//
public class Exam0610 {

  // static void f1(int x, int y) {
  // int b = 5; // bytecode 확인해보기!
  // int temp = b; // 1. b 값을 임시변수 temp에 담고
  // b += 1; // 2. b 값을 1 증감 시킵니다.
  // System.out.println(temp); // 3. 그리고 temp라는 변수를 호출합니다.

  // System.out.println(b++); // => 컴파일 될 때 1번, 2번, 3번을 수행하는거와 똑같음, 이거는 후위연산자!

  // b += 1; // 1. b를 증감시킨 후에
  // System.out.println(b); // 2. b를 호출한다.
  // System.out.println(++b); // => 이거는 전위연산자!

  // }

  public static void main(String[] args) {
    int i = 2;

    // 증감 연산자가 없다면,
    // 기존 변수의 값을 1증가시키기 위해 다음과 같이 코딩해야 한다.
    // i = i + 1;

    // 증감 연산자를 사용하면 다음과 같이 간략하게 작성할 수 있다.
    // i++; // i => 3
    // 현재 위치에 i 메모리에 들어 있는 값(2)을 꺼내 놓는다.
    // 그런 다음에 i 메모리의 값을 1 증가시킨다.
    // 결론:
    // ==> i++ 문장은 컴파일러가 i = i + 1 문장으로 바꾼다.
    // ==> 즉 i = i + 1 문장을 축약한 문법에 불과하다.

    i++; // i => 4

    System.out.println(i); // 4

    System.out.println(i++); // 4 => 괄호 안에 i++이 실행되고나서 println이 실행됌
    // 위의 코드는 컴파일 할 때 다음의 코드로 바뀐다.
    //
    // int temp = i; //<-- 임시 변수를 만들어 현재 i 값을 저장한다.
    // i = i + 1;
    // System.out.println(temp);

    System.out.println(i); // 5

  }
}
