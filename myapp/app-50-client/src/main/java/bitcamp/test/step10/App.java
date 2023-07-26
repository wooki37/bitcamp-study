package bitcamp.test.step10;

import java.net.Socket;

// 10) GRASP(General Resposebility Assignment Software ) 패턴: Information Expert
// - createScore() 를 Score 클래스로 이동
public class App {

  static class Score {
    String name;
    int kor;
    int eng;
    int math;
    int sum;
    float aver;

    void compute() {
      this.sum = this.kor + this.eng + this.math;
      this.aver = this.sum / 3f;
    }

    // 팩토리 메서드 => 인스턴스를 사용하지 않음, static 메서드를 사용
    static Score create(String name, int kor, int eng, int math) {
      Score s = new Score();
      s.name = name;
      s.kor = kor;
      s.eng = eng;
      s.math = math;
      s.compute();
      return s;
    }
  }

  public static void main(String[] args) {

    final int MAX_SIZE = 10;
    Score[] scores = new Score[MAX_SIZE];
    int length = 0;

    scores[length++] = Score.create("홍길동", 100, 100, 100);
    scores[length++] = Score.create("임꺽정", 80, 95, 30);
    scores[length++] = Score.create("유관순", 30, 100, 95);

    for (int i = 0; i < length; i++) {
      printScore(scores[i]);
    }
  }

  static void printScore(Score s) {
    System.out.printf("%s: 합계= %d, 평균= %.1f\n", s.name, s.sum, s.aver);
  }
}