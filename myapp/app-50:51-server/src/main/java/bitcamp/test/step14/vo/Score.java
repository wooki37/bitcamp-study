package bitcamp.test.step14.vo;

public class Score {
  public String name;
  int kor;
  int eng;
  int math;
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
}
