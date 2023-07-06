package bitcamp.test.step17;

import java.net.Socket;
import bitcamp.test.step17.vo.Score;

// 17) 필드의 직접 접근을 막기: 인스턴스 변수에 무효한 값이 저장되지 않게 하기 위해
// => getter 정의 : 값을 꺼앨 때 사용
// => setter 정의 : 값을 변경할 때 사용. 단, 유효한 값을 저장하도록 통제한다.
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
    scores[length++] = new Score("유관순", 30, 800, 95);

    // scores[0].kor = 7000;// 접근 불가!
    scores[0].setKor(70); // setter를 통해서는 값 변경 가능. 단, 유효한 값만 가능.
    // scores[0].compute(); // 호출하는 것을 잊어 버릴 수 있기 때문에 setter에서 호출한다.

    for (int i = 0; i < length; i++) {
      printScore(scores[i]);
    }
  }

  static void printScore(Score s) {
    System.out.printf("%s: 국어= %d, 영어= %d, 수학= %d, 합계= %d, 평균= %.1f\n",
        s.getName(), s.getKor(), s.getEng(), s.getMath(), s.getSum(), s.getAver());
  }
}