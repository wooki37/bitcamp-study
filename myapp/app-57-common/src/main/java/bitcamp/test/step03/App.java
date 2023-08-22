package bitcamp.test.step03;

import java.net.Socket;

// 3) 배열 사용
public class App {

  public static void main(String[] args) {

    String[] name = new String[10];
    int[] kor = new int[10];
    int[] eng = new int[10];
    int[] math = new int[10];
    int[] sum = new int[10];
    float[] aver = new float[10];
    int length = 0;

    name[length] = "홍길동";
    kor[length] = 100;
    eng[length] = 100;
    math[length] = 100;
    sum[length] = kor[length] + eng[length] + math[length];
    aver[length] = sum[length] / 3f;
    length++;

    name[length] = "임꺽정";
    kor[length] = 75;
    eng[length] = 95;
    math[length] = 100;
    sum[length] = kor[length] + eng[length] + math[length];
    aver[length] = sum[length] / 3f;
    length++;

    name[length] = "유관순";
    kor[length] = 30;
    eng[length] = 100;
    math[length] = 30;
    sum[length] = kor[length] + eng[length] + math[length];
    aver[length] = sum[length] / 3f;
    length++;

    for (int i = 0; i < length; i++) {
      System.out.printf("%s: 합계=%d, 평균=%.1f\n", name[i], sum[i], aver[i]);
    }
  }
}