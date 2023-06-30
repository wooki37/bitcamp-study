package bitcamp.myapp_project.handler;

import bitcamp.myapp_project.vo.Patient;
import bitcamp.util.BreadcrumbPrompt;
import java.util.List;

public class AnimalHospitalListListener extends AbstractAnimalHospitalListener {

  public AnimalHospitalListListener(List<Patient> list) {
    super(list);
  }

  @Override
  public void service(BreadcrumbPrompt prompt) {
    System.out.println("-----------------------------------------------------------------------");
    System.out.println("보호자ID/환자ID/  환자명/ 품종/ 나이/ 주소/ 연락처/ 성별");
    System.out.println("-----------------------------------------------------------------------");

    for (int i = 0; i < this.list.size(); i++) {
      Patient m = (Patient) this.list.get(i);
      System.out.printf("%d/,    %d/,%s/,  %s/,  %d/, %s/,(010)%d/, %s\n", m.getNo(), m.getNo(),
          m.getName(), m.getBreeds(), m.getAge(), m.getAddress(), m.getPhone(),
          toGenderString(m.getGender()));
    }
  }
}
