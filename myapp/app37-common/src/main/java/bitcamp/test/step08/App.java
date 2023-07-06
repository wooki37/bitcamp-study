package bitcamp.test.step08;

import java.net.Socket;

// 8) 인스턴스 메서드 도입
public class App {

  static class Score {
    String name;
    int kor;
    int eng;
    int math;
    int sum;
    float aver;

    void compute() { // this 내장 변수
      this.sum = this.kor + this.eng + this.math;
      this.aver = this.sum / 3f;
    }
  }

  public static void main(String[] args) {

    final int MAX_SIZE = 10;
    Score[] scores = new Score[MAX_SIZE];
    int length = 0;

    Score s = new Score();
    s.name = "홍길동";
    s.kor = 100;
    s.eng = 100;
    s.math = 100;
    s.compute();
    scores[length++] = s;

    s = new Score();
    s.name = "임꺽정";
    s.kor = 30;
    s.eng = 100;
    s.math = 30;
    s.compute();
    scores[length++] = s;

    s = new Score();
    s.name = "유관순";
    s.kor = 90;
    s.eng = 100;
    s.math = 15;
    s.compute();
    scores[length++] = s;

    for (int i = 0; i < length; i++) {
      printScore(scores[i]);
    }
  }

  static void printScore(Score s) {
    System.out.printf("%s: 합계= %d, 평균= %.1f\n", s.name, s.sum, s.aver);
  }
}