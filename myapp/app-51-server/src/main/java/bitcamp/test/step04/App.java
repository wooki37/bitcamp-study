package bitcamp.test.step04;

import java.net.Socket;

// 4) 클래스를 이용하여 데이터 타입 정의(중첩클래스; 로컬 클래스)
public class App {

  public static void main(String[] args) {
    class Score {
      String name;
      int kor;
      int eng;
      int math;
      int sum;
      float aver;
    }

    final int MAX_SIZE = 10;
    Score[] scores = new Score[MAX_SIZE];
    int length = 0;

    Score s = new Score();
    s.name = "홍길동";
    s.kor = 100;
    s.eng = 100;
    s.math = 100;
    s.sum = s.kor + s.eng + s.math;
    s.aver = s.sum / 3f;
    scores[length++] = s;

    s = new Score();
    s.name = "임꺽정";
    s.kor = 30;
    s.eng = 100;
    s.math = 30;
    s.sum = s.kor + s.eng + s.math;
    s.aver = s.sum / 3f;
    scores[length++] = s;

    s = new Score();
    s.name = "유관순";
    s.kor = 90;
    s.eng = 100;
    s.math = 15;
    s.sum = s.kor + s.eng + s.math;
    s.aver = s.sum / 3f;
    scores[length++] = s;

    for (int i = 0; i < length; i++) {
      s = scores[i];
      System.out.printf("%s: 합계=%d, 평균=%.1f\n", s.name, s.sum, s.aver);
    }
  }
}