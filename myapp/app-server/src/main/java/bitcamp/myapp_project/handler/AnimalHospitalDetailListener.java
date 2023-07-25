package bitcamp.myapp_project.handler;

import java.io.IOException;
import bitcamp.myapp_project.dao.PatientDao;
import bitcamp.myapp_project.vo.Patient;
import bitcamp.util.ActionListener;
import bitcamp.util.BreadcrumbPrompt;

public class AnimalHospitalDetailListener implements ActionListener {

  PatientDao patientDao;

  public AnimalHospitalDetailListener(PatientDao patientDao) {
    this.patientDao = patientDao;
  }

  @Override
  public void service(BreadcrumbPrompt prompt) throws IOException {
    int patientNo = prompt.inputInt("번호? ");

    Patient p = patientDao.findBy(patientNo);
    if (p == null) {
      prompt.println("해당 번호의 환자가 없습니다!");
      return;
    }
    prompt.printf("환자ID: %d\n", p.getPatientNo());
    prompt.printf("보호자ID: %d\n", p.getParentNo());
    prompt.printf("환자명: %s\n", p.getName());
    prompt.printf("품종: %s\n", p.getBreeds());
    prompt.printf("나이: %d\n", p.getAge());
    prompt.printf("주소: %s\n", p.getAddress());
    prompt.printf("연락처: %d\n", p.getPhone());
    prompt.printf("성별: %s\n", p.getGender() == 'M' ? "수컷" : "암컷");
  }
}
