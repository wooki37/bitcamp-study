package bitcamp.myapp_project.handler;

import java.io.IOException;
import bitcamp.myapp_project.vo.Patient;
import bitcamp.util.ActionListener;
import bitcamp.util.BreadcrumbPrompt;

public interface AnimalHospitalActionListener extends ActionListener {

  static char inputGender(char gender, BreadcrumbPrompt prompt) throws IOException {
    String label;
    if (gender == 0) {
      label = "성별?\n";
    } else {
      label = String.format("성별(%s)?\n", gender == 'M' ? "수컷" : "암컷");
    }
    while (true) {
      String menuNo = prompt.inputString(label + " 1. 수컷\n" + " 2. 암컷\n" + "> ");

      switch (menuNo) {
        case "1":
          return Patient.MALE;
        case "2":
          return Patient.FEMALE;
        default:
          prompt.println("무효한 번호입니다.");
      }
    }
  }
}
