package bitcamp.myapp_project.handler;

import bitcamp.myapp_project.vo.Member;
import bitcamp.util.BreadcrumbPrompt;
import java.util.List;

public class AnimalHospitalAddListener extends AbstractAnimalHospitalListener {

  public AnimalHospitalAddListener(List<Member> list) {
    super(list);
  }

  @Override
  public void service(BreadcrumbPrompt prompt) {
    Member m = new Member();
    m.setNo(Integer.parseInt(prompt.inputString("보호자ID? ")));
    m.setNo(Integer.parseInt(prompt.inputString("환자ID? ")));
    m.setName(prompt.inputString("환자명? "));
    m.setBreeds(getMemberBreed(prompt));
    m.setAge(Integer.parseInt(prompt.inputString("나이? ")));
    m.setAddress(prompt.inputString("주소? "));
    m.setPhone(Integer.parseInt(prompt.inputString("연락처?(010) ")));
    m.setGender(inputGender((char) 0, prompt));

    this.list.add(m);
  }

  private static String getMemberBreed(BreadcrumbPrompt prompt) {
    boolean isValidNum = true; // 입력된 번호가 유효한지 여부
    String num = null;
    String breedType = null;
    while (isValidNum) {

      num = prompt.inputString("품종? 1. 강아지, 2.고양이. 3.직접입력").trim(); // trim() : 입력된 문자열의 양쪽 공백
      // 제거
      if ("1".equals(num)) {
        breedType = "강아지";
        isValidNum = false;
      } else if ("2".equals(num)) {
        breedType = "고양이";
        isValidNum = false;
      } else if ("3".equals(num)) {
        breedType = prompt.inputString("품종 타입을 직접 입력해주세요 > ");
        isValidNum = false;
      } else { // isValidNum 변수는 여전히 true이므로 루프가 반복됩니다.
        System.out.println("입력에 없는 번호입니다. 다시 입력해주세요");
      }
    }
    return breedType;
  }
}
