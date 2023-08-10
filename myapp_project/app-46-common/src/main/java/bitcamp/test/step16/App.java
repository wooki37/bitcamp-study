package bitcamp.test.step16;

import java.net.Socket;
import bitcamp.test.step16.vo.Score;

// 16) 필드의 직접 접근을 막고 setter를 정의하는 이유
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

    // 합계와 평균 계산이 끝난 후에 국어 점수를 변경한다면
    // => 국영수 점수와 합계, 평균 점수가 일치하지 않는 문제가 발생한다.
    // 데이터에 결함이 발생한다.
    // 국영수 점수를 변경한 후에 compute()를 호출하면 되지 않을까?
    // => 만약 개발자가 compute() 호출하는 것을 잊어 버린다면 아무 소용이 없다.
    // 만약 유효하지 않은 국영수 점수를 입력한다면?
    // => 흠.. 이건 도저히 막을 길이 없다.
    scores[0].kor = 7000;// 이렇게 무효한 점수를 입력하는 것을 막을 수 없다.
    scores[0].compute(); // 호출하지 않으면 아무소용이 없다.

    for (int i = 0; i < length; i++) {
      printScore(scores[i]);
    }
  }

  static void printScore(Score s) {
    System.out.printf("%s: 국어= %d, 영어= %d, 수학= %d, 합계= %d, 평균= %.1f\n",
        s.getName(), s.kor, s.eng, s.math, s.getSum(), s.getAver());
  }
}