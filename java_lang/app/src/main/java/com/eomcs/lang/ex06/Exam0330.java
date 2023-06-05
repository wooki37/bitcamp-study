package com.eomcs.lang.ex06;

//# 흐름 제어문 - 중첩된 반복문 탈출
//
public class Exam0330 {
  public static void main(String[] args) {
    int x = 2, y = 1;

    // 5 * 5 까지만 출력하라!
    //
    while (x <= 9) { // x 값이 9보다 작거나 같으면 참, 아니면 거짓

      while (y <= 9) {
        System.out.printf("%d * %d = %d\n", x, y, x * y);
        if (x == 5 && y == 5) // x === 5 와 y == 5 두 항이 모두 참인 경우 결과 값이 참이다.
          break; // 이 break는 자신이 소속된 가장 가까운 반복문을 나간다.
        y++;
      }

      System.out.println();
      x++;
      y = 1;
    }
    System.out.println("종료!!");
  }
}
