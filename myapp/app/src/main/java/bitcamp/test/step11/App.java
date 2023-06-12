package bitcamp.test.step11;

import java.net.Socket;

// 11) 생성자 도입: 인스턴스 변수를 보다 쉽게 초기화 시키기
public class App {

  static class Score {
    String name;
    int kor;
    int eng;
    int math;
    int sum;
    float aver;

    // 생성자 : 인스턴스를 생성한 직후 호출하는 메서드, 자바에서는 1개 이상의 생성자가 반드시 존재한다.
    Score(String name, int kor, int eng, int math) {
      this.name = name;
      this.kor = kor;
      this.eng = eng;
      this.math = math;
      this.compute();
    }

    void compute() {
      this.sum = this.kor + this.eng + this.math;
      this.aver = this.sum / 3f;
    }
  }

  public static void main(String[] args) {

    final int MAX_SIZE = 10;
    Score[] scores = new Score[MAX_SIZE];
    int length = 0;

    // new Score(문자열, int, int, int);
    // => Score 설계도에 따라 인스턴스를 생성하라.
    // => 생성한 후 String, int, int, int 파라미터 값을 받는 생성자를 호출하라
    // => 이렇게 초기화시킨 인스턴스의 주소르르 리턴하라.
    scores[length++] = new Score("홍길동", 100, 100, 100);
    scores[length++] = new Score("임꺽정", 80, 95, 30);
    scores[length++] = new Score("유관순", 30, 100, 95);

    for (int i = 0; i < length; i++) {
      printScore(scores[i]);
    }
  }

  static void printScore(Score s) {
    System.out.printf("%s: 합계= %d, 평균= %.1f\n", s.name, s.sum, s.aver);
  }
}