package bitcamp.myapp_project.handler;

import java.io.IOException;
import bitcamp.myapp_project.dao.PatientDao;
import bitcamp.myapp_project.vo.Patient;
import bitcamp.util.BreadcrumbPrompt;

public class AnimalHospitalUpdateListener implements AnimalHospitalActionListener {

  PatientDao patientDao;

  public AnimalHospitalUpdateListener(PatientDao patientDao) {
    this.patientDao = patientDao;
  }

  @Override
  public void service(BreadcrumbPrompt prompt) throws IOException {
    int patientNo = prompt.inputInt("환자ID 번호? ");

    Patient p = patientDao.findBy(patientNo);
    if (p == null) {
      prompt.println("해당 번호의 ID가 없습니다.");
      return;
    }

    p.setParentNo(prompt.inputInt("보호자ID(%d)? ", p.getParentNo()));
    p.setName(prompt.inputString("환자명(%s)? ", p.getName()));
    p.setBreeds(prompt.inputString("품종(%s)? ", p.getBreeds()));
    p.setAge(prompt.inputInt("나이(%d)? ", p.getAge()));
    p.setAddress(prompt.inputString("주소(%s)? ", p.getAddress()));
    p.setPhone(prompt.inputInt("연락처(%d)? ", p.getPhone()));
    p.setGender(AnimalHospitalActionListener.inputGender(p.getGender(), prompt));

    if (patientDao.update(p) == 0) {
      prompt.println("환자 목록 변경 권한이 없습니다..");
    } else {
      prompt.println("변경 완료 되었습니다!");
    }
  }
}
