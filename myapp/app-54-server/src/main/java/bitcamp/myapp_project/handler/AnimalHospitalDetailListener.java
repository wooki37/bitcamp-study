package bitcamp.myapp_project.handler;

import java.io.IOException;
import org.apache.ibatis.session.SqlSessionFactory;
import bitcamp.myapp_project.dao.PatientDao;
import bitcamp.myapp_project.vo.Patient;
import bitcamp.util.BreadcrumbPrompt;
import bitcamp.util.Component;

@Component("/patient/detail")
public class AnimalHospitalDetailListener implements AnimalHospitalActionListener {

  PatientDao patientDao;
  SqlSessionFactory sqlSessionFactoruy;

  public AnimalHospitalDetailListener(PatientDao patientDao, SqlSessionFactory sqlSessionFactoruy) {
    this.patientDao = patientDao;
    this.sqlSessionFactoruy = sqlSessionFactoruy;
  }

  @Override
  public void service(BreadcrumbPrompt prompt) throws IOException {
    int patientNo = prompt.inputInt("번호? ");

    Patient p = patientDao.findBy(patientNo);
    if (p == null) {
      prompt.println("해당 번호의 환자가 없습니다!");
      return;
    }
    prompt.printf("보호자ID: %d\n", p.getParentNo());
    prompt.printf("환자명: %s\n", p.getName());
    prompt.printf("품종: %s\n", p.getBreeds());
    prompt.printf("나이: %d\n", p.getAge());
    prompt.printf("주소: %s\n", p.getAddress());
    prompt.printf("연락처: %s\n", p.getPhone());
    prompt.printf("성별: %s\n", p.getGender() == 'M' ? "수컷" : "암컷");
    prompt.printf("등록일: %s\n", p.getCreatedDate());

  }
}


