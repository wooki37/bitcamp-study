package bitcamp.test.step06;

import java.net.Socket;

// 6) 합계 및 평균을 계산하는 기능을 메소드로 관리
public class App {

  static class Score {
    String name;
    int kor;
    int eng;
    int math;
    int sum;
    float aver;
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
    compute(s);
    scores[length++] = s;

    s = new Score();
    s.name = "임꺽정";
    s.kor = 30;
    s.eng = 100;
    s.math = 30;
    compute(s);
    scores[length++] = s;

    s = new Score();
    s.name = "유관순";
    s.kor = 90;
    s.eng = 100;
    s.math = 15;
    compute(s);
    scores[length++] = s;

    for (int i = 0; i < length; i++) {
      printScore(scores[i]);
    }
  }

  static void compute(Score s) {
    s.sum = s.kor + s.eng + s.math;
    s.aver = s.sum / 3f;
  }

  static void printScore(Score s) {
    System.out.printf("%s: 합계= %d, 평균= %.1f\n", s.name, s.sum, s.aver);
  }
}