package bitcamp.myapp_project.handler;

import java.io.IOException;
import bitcamp.myapp_project.dao.PatientDao;
import bitcamp.myapp_project.vo.Patient;
import bitcamp.util.BreadcrumbPrompt;

public class AnimalLoginListener implements AnimalHospitalActionListener {

  PatientDao patientDao;

  public AnimalLoginListener(PatientDao patientDao) {
    this.patientDao = patientDao;
  }

  @Override
  public void service(BreadcrumbPrompt prompt) throws IOException {
    while (true) {
      Patient p = new Patient();
      p.setPatientNo(prompt.inputInt("환자 ID? "));
      p.setPhone(prompt.inputString("전화번호?(뒷번호 8자리) "));
      System.out.println(p.toString());
      Patient loginUser = patientDao.findByPatientAndPhone(p);
      if (loginUser == null) {
        prompt.println("입력하신 정보가 일치하지 않습니다..");
      } else {
        prompt.setAttribute("loginUser", loginUser);
        break;
      }
      prompt.end();
    }
  }
}
