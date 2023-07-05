package bitcamp.myapp_project.handler;

import java.util.List;
import bitcamp.myapp_project.vo.Patient;
import bitcamp.util.ActionListener;
import bitcamp.util.BreadcrumbPrompt;

public abstract class AbstractAnimalHospitalListener implements ActionListener {

  // 범용으로 만들어진 ArrayList
  protected List<Patient> list;

  public AbstractAnimalHospitalListener(List<Patient> list) {
    this.list = list;
  }

  protected static String toGenderString(char gender) {
    return gender == 'M' ? "수컷" : "암컷";
  }

  protected Patient findBy(int no) {
    for (int i = 0; i < this.list.size(); i++) {
      Patient p = this.list.get(i);
      if (p.getPatientNo() == no) {
        return p;
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
          return Patient.MALE;
        case "2":
          return Patient.FEMALE;
        default:
          System.out.println("무효한 번호입니다.");
      }
    }
  }
}
