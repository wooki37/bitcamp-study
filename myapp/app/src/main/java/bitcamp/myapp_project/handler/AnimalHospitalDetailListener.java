package bitcamp.myapp_project.handler;

import java.util.List;
import bitcamp.myapp_project.vo.Patient;
import bitcamp.util.BreadcrumbPrompt;

public class AnimalHospitalDetailListener extends AbstractAnimalHospitalListener {

  public AnimalHospitalDetailListener(List<Patient> list) {
    super(list);
  }

  @Override
  public void service(BreadcrumbPrompt prompt) {
    int memberNo = prompt.inputInt("번호? ");

    Patient p = this.findBy(memberNo);
    if (p == null) {
      System.out.println("해당 번호의 환자가 없습니다!");
      return;
    }
    System.out.printf("환자ID: %d\n", p.getPatientNo());
    System.out.printf("보호자ID: %d\n", p.getParentNo());
    System.out.printf("환자명: %s\n", p.getName());
    System.out.printf("품종: %s\n", p.getBreeds());
    System.out.printf("나이: %d\n", p.getAge());
    System.out.printf("주소: %s\n", p.getAddress());
    System.out.printf("연락처: %d\n", p.getPhone());
    System.out.printf("성별: %s\n", toGenderString(p.getGender()));
  }
}
