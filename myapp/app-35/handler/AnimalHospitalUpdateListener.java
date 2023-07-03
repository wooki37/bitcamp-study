package bitcamp.myapp_project.handler;

import java.util.List;
import bitcamp.myapp_project.vo.Patient;
import bitcamp.util.BreadcrumbPrompt;

public class AnimalHospitalUpdateListener extends AbstractAnimalHospitalListener {

  public AnimalHospitalUpdateListener(List<Patient> list) {
    super(list);
  }

  @Override
  public void service(BreadcrumbPrompt prompt) {
    int memberNo = prompt.inputInt("환자ID 번호? ");

    Patient p = this.findBy(memberNo);
    if (p == null) {
      System.out.println("해당 번호의 ID가 없습니다.");
      return;
    }

    p.setNo(prompt.inputInt("보호자ID(%d)? ", p.getNo()));
    p.setName(prompt.inputString("환자명(%s)? ", p.getName()));
    p.setBreeds(prompt.inputString("품종(%s)? ", p.getBreeds()));
    p.setAge(prompt.inputInt("나이(%d)? ", p.getAge()));
    p.setAddress(prompt.inputString("주소(%s)? ", p.getAddress()));
    p.setPhone(prompt.inputInt("연락처(%d)? ", p.getPhone()));
    p.setGender(inputGender(p.getGender(), prompt));
  }
}
