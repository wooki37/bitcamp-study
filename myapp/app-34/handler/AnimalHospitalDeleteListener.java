package bitcamp.myapp_project.handler;

import bitcamp.myapp_project.vo.Patient;
import bitcamp.util.BreadcrumbPrompt;
import java.util.List;

public class AnimalHospitalDeleteListener extends AbstractAnimalHospitalListener {

  public AnimalHospitalDeleteListener(List<Patient> list) {
    super(list);
  }

  @Override
  public void service(BreadcrumbPrompt prompt) {
    if (!this.list.remove(new Patient(prompt.inputInt("번호? ")))) {
      System.out.println("해당 번호가 존재하지 않습니다.");
    }
  }
}
