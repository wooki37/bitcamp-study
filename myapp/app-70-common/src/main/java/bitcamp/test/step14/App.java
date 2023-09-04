package bitcamp.test.step14;

import java.net.Socket;
import bitcamp.test.step14.vo.Score;

// 14) 외부접근 차단과 값 꺼내기 : private, getter
public class App {

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

    // 변수에 직접 접근 => 국영수 합계를 임의로 조작 가능!
    // scores[0].sum = 20000;

    for (int i = 0; i < length; i++) {
      printScore(scores[i]);
    }
  }

  static void printScore(Score s) {
    System.out.printf("%s: 합계= %d, 평균= %.1f\n", s.name, s.getSum(), s.getAver());
  }
}