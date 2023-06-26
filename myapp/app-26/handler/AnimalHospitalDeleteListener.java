package bitcamp.myapp_project.handler;

import bitcamp.myapp_project.vo.Member;
import bitcamp.util.BreadcrumbPrompt;
import java.util.List;

public class AnimalHospitalDeleteListener extends AbstractAnimalHospitalListener {

  public AnimalHospitalDeleteListener(List<Member> list) {
    super(list);
  }

  @Override
  public void service(BreadcrumbPrompt prompt) {
    if (!this.list.remove(new Member(prompt.inputInt("번호? ")))) {
      System.out.println("해당 번호가 존재하지 않습니다.");
    }
  }
}
