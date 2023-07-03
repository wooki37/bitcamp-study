// 객체 --> JSON 문자열 : 객체의 필드 값을 json 형식의 문자열로 만들기
package com.eomcs.openapi.json.gson;

import java.sql.Date;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Exam0111 {
  public static void main(String[] args) {
    Member m = new Member();
    m.setNo(100);
    m.setName("홍길동");
    m.setEmail("hong@test.com");
    m.setPassword("1111");
    m.setPhoto("hong.gif");
    m.setTel("010-2222-1111");
    m.setRegisteredDate(new Date(System.currentTimeMillis()));


    // 2) JSOn 처리 객체 준비
    // Gson gson = new Gson();

    // GsonBuilder builder = new GsonBuilder();
    // builder.setDateFormat("yyyy-MM-dd");
    // Gson gson = builder.create();

    Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd") // 원하는 날짜 형식 설정
        .create();

    String jsonStr = gson.toJson(m);

    System.out.println(jsonStr);
  }
}


