package bitcamp.myapp_project.handler;

import java.io.IOException;
import org.apache.ibatis.session.SqlSessionFactory;
import bitcamp.myapp_project.dao.PatientDao;
import bitcamp.util.ActionListener;
import bitcamp.util.BreadcrumbPrompt;


public class AnimalHospitalDeleteListener implements ActionListener {

  PatientDao patientDao;
  SqlSessionFactory sqlSessionFactory;

  public AnimalHospitalDeleteListener(PatientDao patientDao, SqlSessionFactory sqlSessionFactory) {
    this.patientDao = patientDao;
    this.sqlSessionFactory = sqlSessionFactory;
  }

  @Override
  public void service(BreadcrumbPrompt prompt) throws IOException {
    try {
      if (patientDao.delete(prompt.inputInt("번호? ")) == 0) {
        prompt.println("해당 번호가 존재하지 않습니다.");
      }
      prompt.println("삭제했습니다!");
      sqlSessionFactory.openSession(false).commit();

    } catch (Exception e) {
      sqlSessionFactory.openSession(false).rollback();
      throw new RuntimeException(e);
    }
  }
}
