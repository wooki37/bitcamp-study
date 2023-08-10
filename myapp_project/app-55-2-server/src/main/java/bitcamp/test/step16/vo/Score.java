package bitcamp.test.step16.vo;

public class Score {
  private String name; // 이렇게 코드를 하는 이유는 속도보다는 일관성있게 유지보수하는데 간편하기 때문이다.
  public int kor;
  public int eng;
  public int math;
  private int sum;
  private float aver;

  // 생성자 : 인스턴스를 생성한 직후 호출하는 메서드
  public Score(String name, int kor, int eng, int math) {
    this.name = name;
    this.kor = kor;
    this.eng = eng;
    this.math = math;
    this.compute();
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
}
