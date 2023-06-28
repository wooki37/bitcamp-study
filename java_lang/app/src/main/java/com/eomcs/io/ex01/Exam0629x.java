// 디렉토리에 들어있는 파일(디렉토리) 목록을 꺼낼 때 필터 적용하기 II
package com.eomcs.io.ex01;

import java.io.File;

public class Exam0629x {
  public static void main(String[] args) throws Exception {

    File dir = new File(".");
    File[] files = dir.listFiles(file -> file.isFile() && file.getName().endsWith(".java"));

    for (File file : files) {
      System.out.printf("%s %12d %s\n", file.isDirectory() ? "d" : "-", file.length(),
          file.getName());
    }

  }

}

// #1. 익명 클래스 만들기 -> 기존 클래스는 중복되므로 삭제한다.
// #2. filter 파라미터 값에 FileFilter를 대신 넣는다.
// #3. 겉의 중괄호를 삭제한다.
// #4. 람다문법을 위해 public boolean accept를 지운다.
// $5. file -> 로 왼쪽은 파라미터만 남기고 오른쪽에 바디를 남겨 람다문법을 활용한다.
// #6. 정리해준다.
