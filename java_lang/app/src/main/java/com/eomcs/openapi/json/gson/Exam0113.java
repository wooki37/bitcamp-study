// 객체 --> JSON 문자열 : 객체의 필드 값을 json 형식의 문자열로 만들기
package com.eomcs.openapi.json.gson;

import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

public class Exam0113 {
  public static void main(String[] args) {
    Member m = new Member();
    m.setNo(100);
    m.setName("홍길동");
    m.setEmail("hong@test.com");
    m.setPassword("1111");
    m.setPhoto("hong.gif");
    m.setTel("010-2222-1111");
    m.setRegisteredDate(new Date(System.currentTimeMillis()));


    // 2) JSON 처리 객체 준비
    // Date 타입의 값을 내보내고 가져올 때 사용할 변환 도구를 준비
    DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    GsonBuilder builder = new GsonBuilder();

    builder.registerTypeAdapter(Date.class, new JsonSerializer<Date>() {
      @Override
      public JsonElement serialize(Date src, Type typeOfSrc, JsonSerializationContext context) {

        return new JsonPrimitive(dateFormat.format(src));
      }
    });


    Gson gson = builder.create();


    String jsonStr = gson.toJson(m);

    // 3) 객체의 값을 JSON 문자열로 얻
    System.out.println(jsonStr);
  }
}


