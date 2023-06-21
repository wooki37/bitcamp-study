package bitcamp.myapp_project.handler;

import static bitcamp.myapp_project.handler.AbstractAnimalHospitalListener.toGenderString;
import bitcamp.myapp_project.vo.Member;
import bitcamp.util.BreadcrumbPrompt;
import bitcamp.util.List;

public class AnimalHospitalDetailListener extends AbstractAnimalHospitalListener {

  public AnimalHospitalDetailListener(List list) {
    super(list);
  }

  @Override
  public void service(BreadcrumbPrompt prompt) {
    int memberNo = prompt.inputInt("번호? ");

    Member m = this.findBy(memberNo);
    if (m == null) {
      System.out.println("해당 번호의 환자가 없습니다!");
      return;
    }
    System.out.printf("보호자ID: %d\n", m.getNo());
    System.out.printf("환자ID: %d\n", m.getNo());
    System.out.printf("환자명: %s\n", m.getName());
    System.out.printf("품종: %s\n", m.getBreeds());
    System.out.printf("나이: %d\n", m.getAge());
    System.out.printf("주소: %s\n", m.getAddress());
    System.out.printf("연락처: %d\n", m.getPhone());
    System.out.printf("성별: %s\n", toGenderString(m.getGender()));
  }
}
