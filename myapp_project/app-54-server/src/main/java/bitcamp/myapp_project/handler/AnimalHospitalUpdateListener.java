package bitcamp.myapp_project.handler;

import java.io.IOException;
import org.apache.ibatis.session.SqlSessionFactory;
import bitcamp.myapp_project.dao.PatientDao;
import bitcamp.myapp_project.vo.Patient;
import bitcamp.util.BreadcrumbPrompt;
import bitcamp.util.Component;

@Component("/patient/update")
public class AnimalHospitalUpdateListener implements AnimalHospitalActionListener {

  PatientDao patientDao;
  SqlSessionFactory sqlSessionFactory;

  public AnimalHospitalUpdateListener(PatientDao patientDao, SqlSessionFactory sqlSessionFactory) {
    this.patientDao = patientDao;
    this.sqlSessionFactory = sqlSessionFactory;
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
    p.setPhone(prompt.inputString("새 연락처(%s)? ", p.getPhone()));
    p.setGender(AnimalHospitalActionListener.inputGender(p.getGender(), prompt));

    try {
      if (patientDao.update(p) == 0) {
        prompt.println("변경 권한이 없습니다.");
      } else {
        prompt.println("변경했습니다!");
      }
      sqlSessionFactory.openSession(false).commit();
    } catch (Exception e) {
      sqlSessionFactory.openSession(false).rollback();
      throw new RuntimeException(e);
    }
  }
}
