package bitcamp.myapp_project.handler;

import java.io.IOException;
import bitcamp.myapp_project.dao.PatientDao;
import bitcamp.util.ActionListener;
import bitcamp.util.BreadcrumbPrompt;


public class AnimalHospitalDeleteListener implements ActionListener {

  PatientDao patientDao;

  public AnimalHospitalDeleteListener(PatientDao patientDao) {
    this.patientDao = patientDao;
  }

  @Override
  public void service(BreadcrumbPrompt prompt) throws IOException {
    if (patientDao.delete(prompt.inputInt("번호? ")) == 0) {
      prompt.println("해당 번호가 존재하지 않습니다.");
    }
    prompt.println("삭제했습니다!");
  }
}
