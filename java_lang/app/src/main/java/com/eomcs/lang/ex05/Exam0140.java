package com.eomcs.lang.ex05;

//# 산술 연산자 : 데이터 타입과 연산자
//
public class Exam0140 {
  public static void main(String[] args) {
    // 모든 종류의 데이터에 대해 산술 연산자를 사용할 수 있는 것은 아니다.
    // 데이터 타입에 따라 제공되는 연산자가 다르다.

    System.out.println(5.75 % 0.24); // OK!
    // System.out.println(true % false); // boolean 타입에 대해서는 산술 연산자를 사용할 수 없다.
    // System.out.println(true + true); // 위와 마찬가지 컴파일 오류!

    System.out.println("Hello," + "world!"); // OK! '+' 연산자는 문자열 연결 용도로 사용된다.
    // System.out.println("Hello," - "o,"); // 컴파일 오류! -> 문자열을 빼는 것은 무효
    // System.out.println("Hello," * 5); // 컴파일 오류! -> 위와 마찬가지

    System.out.println(true && true); // 논리 AND 연산자를 사용하여 결과를 출력
    // System.out.println(10 && 10); // 컴파일 오류!이다. -> AND 연산자는 boolean 값과 함께 사용 가능
  }
}
