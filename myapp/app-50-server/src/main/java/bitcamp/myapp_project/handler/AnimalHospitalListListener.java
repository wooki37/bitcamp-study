package bitcamp.myapp_project.handler;

import java.util.List;
import bitcamp.myapp_project.dao.PatientDao;
import bitcamp.myapp_project.vo.Patient;
import bitcamp.util.ActionListener;
import bitcamp.util.BreadcrumbPrompt;

public class AnimalHospitalListListener implements ActionListener {

  PatientDao patientDao;

  public AnimalHospitalListListener(PatientDao patientDao) {
    this.patientDao = patientDao;
  }

  @Override
  public void service(BreadcrumbPrompt prompt) {
    prompt.println("-----------------------------------------------------------------------");
    prompt.println("환자ID/보호자ID/환자명/품종/나이/주소/연락처/성별");
    prompt.println("-----------------------------------------------------------------------");

    List<Patient> list = patientDao.list();
    for (Patient p : list) {
      prompt.printf("%d,%d,%s,%s,%d,%s,(010)%d,%s\n", p.getPatientNo(), p.getParentNo(),
          p.getName(), p.getBreeds(), p.getAge(), p.getAddress(), p.getPhone(),
          p.getGender() == 'M' ? "수컷" : "암컷");
    }
  }
}
