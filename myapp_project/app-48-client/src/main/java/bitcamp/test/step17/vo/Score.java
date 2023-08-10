package bitcamp.test.step17.vo;

public class Score {
  // 프로그램의 일관성을 위해 그냥 막았다.
  private String name; // 이렇게 코드를 하는 이유는 속도보다는 일관성있게 유지보수하는데 간편하기 때문이다.

  // 직접 접근을 허용했을 때 무효한 값을 저장할 수 있기 때문에
  // private 으로 접근을 막았다.
  private int kor;
  private int eng;
  private int math;
  private int sum;
  private float aver;

  // 생성자 : 인스턴스를 생성한 직후 호출하는 메서드
  public Score(String name, int kor, int eng, int math) {
    this.name = name;
    this.setKor(kor);
    this.setEng(eng);
    this.setMath(math);
  }

  public void compute() {
    this.sum = this.kor + this.eng + this.math;
    this.aver = this.sum / 3f;
  }

  // getter : private 로 접근이 맛힌 변수의 값을 리턴해 주는 메서드
  public int getSum() {
    return this.sum;
  }

  // getter : private 로 접근이 맛힌 변수의 값을 리턴해 주는 메서드
  public float getAver() {
    return this.aver;
  }

  public String getName() {
    return this.name;
  }

  public int getKor() {
    return this.kor;
  }

  public void setKor(int kor) {
    if (kor < 0 || kor > 100) {
      return;
    }
    this.kor = kor;
    this.compute();
  }

  public int getEng() {
    return this.eng;
  }

  public void setEng(int eng) {
    if (eng < 0 || eng > 100) {
      return;
    }
    this.eng = eng;
    this.compute();
  }

  public int getMath() {
    return this.math;
  }

  public void setMath(int math) {
    if (math < 0 || math > 100) {
      return;
    }
    this.math = math;
    this.compute();
  }
}
