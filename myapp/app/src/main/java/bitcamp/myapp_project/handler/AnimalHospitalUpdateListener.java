package bitcamp.myapp_project.handler;

import bitcamp.myapp_project.dao.PatientDao;
import bitcamp.myapp_project.vo.Patient;
import bitcamp.util.BreadcrumbPrompt;

public class AnimalHospitalUpdateListener implements AnimalHospitalActionListener {

  PatientDao patientDao;

  public AnimalHospitalUpdateListener(PatientDao patientDao) {
    this.patientDao = patientDao;
  }

  @Override
  public void service(BreadcrumbPrompt prompt) {
    int patientNo = prompt.inputInt("환자ID 번호? ");

    Patient p = patientDao.findBy(patientNo);
    if (p == null) {
      System.out.println("해당 번호의 ID가 없습니다.");
      return;
    }

    p.setParentNo(prompt.inputInt("보호자ID(%d)? ", p.getParentNo()));
    p.setName(prompt.inputString("환자명(%s)? ", p.getName()));
    p.setBreeds(prompt.inputString("품종(%s)? ", p.getBreeds()));
    p.setAge(prompt.inputInt("나이(%d)? ", p.getAge()));
    p.setAddress(prompt.inputString("주소(%s)? ", p.getAddress()));
    p.setPhone(prompt.inputInt("연락처(%d)? ", p.getPhone()));
    p.setGender(AnimalHospitalActionListener.inputGender(p.getGender(), prompt));

    patientDao.update(p);
  }
}
