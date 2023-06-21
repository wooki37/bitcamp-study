package bitcamp.myapp_project.handler;

import bitcamp.myapp_project.vo.Member;
import bitcamp.util.BreadcrumbPrompt;
import bitcamp.util.List;

public class AnimalHospitalListListener extends AbstractAnimalHospitalListener {

  public AnimalHospitalListListener(List list) {
    super(list);
  }

  @Override
  public void service(BreadcrumbPrompt prompt) {
    System.out.println("-----------------------------------------------------------------------");
    System.out.println("보호자ID/환자ID/  환자명/ 품종/ 나이/ 주소/ 연락처/ 성별");
    System.out.println("-----------------------------------------------------------------------");

    for (int i = 0; i < this.list.size(); i++) {
      Member m = (Member) this.list.get(i);
      System.out.printf("%d/,    %d/,%s/,  %s/,  %d/, %s/,(010)%d/, %s\n", m.getNo(), m.getNo(),
          m.getName(), m.getBreeds(), m.getAge(), m.getAddress(), m.getPhone(),
          toGenderString(m.getGender()));
    }
  }
}
