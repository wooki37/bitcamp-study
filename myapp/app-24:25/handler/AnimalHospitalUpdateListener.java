package bitcamp.myapp_project.handler;

import bitcamp.myapp_project.vo.Member;
import bitcamp.util.BreadcrumbPrompt;
import bitcamp.myapp_project.util.List;

public class AnimalHospitalUpdateListener extends AbstractAnimalHospitalListener {

  public AnimalHospitalUpdateListener(List<Member> list) {
    super(list);
  }

  @Override
  public void service(BreadcrumbPrompt prompt) {
    int memberNo = prompt.inputInt("보호자ID 번호? ");

    Member m = this.findBy(memberNo);
    if (m == null) {
      System.out.println("해당 번호의 ID가 없습니다.");
      return;
    }

    m.setNo(prompt.inputInt("환자ID(%d)? ", m.getNo()));
    m.setName(prompt.inputString("환자명(%s)? ", m.getName()));
    m.setBreeds(prompt.inputString("품종(%s)? ", m.getBreeds()));
    m.setAge(prompt.inputInt("나이(%d)? ", m.getAge()));
    m.setAddress(prompt.inputString("주소(%s)? ", m.getAddress()));
    m.setPhone(prompt.inputInt("연락처(%d)? ", m.getPhone()));
    m.setGender(inputGender(m.getGender(), prompt));
  }
}
