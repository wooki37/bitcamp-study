package bitcamp.myapp_project.handler;

import bitcamp.myapp_project.vo.Member;
import bitcamp.util.ActionListener;
import bitcamp.util.BreadcrumbPrompt;
import bitcamp.util.List;

public abstract class AbstractAnimalHospitalListener implements ActionListener {

  // 범용으로 만들어진 ArrayList
  protected List list;

  public AbstractAnimalHospitalListener(List list) {
    this.list = list;
  }

  // public String getMemberBreed(BreadcrumbPrompt prompt) {
  // boolean isValidNum = true; // 입력된 번호가 유효한지 여부
  // String num = null;
  // String breedType = null;
  // while (isValidNum) {
  //
  // num = prompt.inputString("품종? 1. 강아지, 2.고양이. 3.직접입력").trim(); // trim() : 입력된 문자열의 양쪽 공백
  // // 제거
  // if ("1".equals(num)) {
  // breedType = "강아지";
  // isValidNum = false;
  // } else if ("2".equals(num)) {
  // breedType = "고양이";
  // isValidNum = false;
  // } else if ("3".equals(num)) {
  // breedType = prompt.inputString("품종 타입을 직접 입력해주세요 > ");
  // isValidNum = false;
  // } else { // isValidNum 변수는 여전히 true이므로 루프가 반복됩니다.
  // System.out.println("입력에 없는 번호입니다. 다시 입력해주세요");
  // }
  // }
  // return breedType;
  // }

  public static String toGenderString(char gender) {
    return gender == 'M' ? "수컷" : "암컷";
  }

  public Member findBy(int no) {
    for (int i = 0; i < this.list.size(); i++) {
      Member m = (Member) this.list.get(i);
      if (m.getNo() == no) {
        return m;
      }
    }
    return null;
  }

  protected char inputGender(char gender, BreadcrumbPrompt prompt) {
    String label;
    if (gender == 0) {
      label = "성별?\n";
    } else {
      label = String.format("성별(%s)?\n", toGenderString(gender));
    }
    while (true) {
      String menuNo = prompt.inputString(label + " 1. 수컷\n" + " 2. 암컷\n" + "> ");

      switch (menuNo) {
        case "1":
          return Member.MALE;
        case "2":
          return Member.FEMALE;
        default:
          System.out.println("무효한 번호입니다.");
      }
    }
  }
}
