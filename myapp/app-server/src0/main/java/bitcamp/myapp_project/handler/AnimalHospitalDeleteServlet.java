package bitcamp.myapp_project.handler;

import org.apache.ibatis.session.SqlSessionFactory;
import bitcamp.myapp_project.dao.PatientDao;
import bitcamp.util.Component;
import bitcamp.util.HttpServletRequest;
import bitcamp.util.HttpServletResponse;
import bitcamp.util.Servlet;

@Component("/patient/delete")
public class AnimalHospitalDeleteServlet implements Servlet {

  PatientDao patientDao;
  SqlSessionFactory sqlSessionFactory;

  public AnimalHospitalDeleteServlet(PatientDao patientDao, SqlSessionFactory sqlSessionFactory) {
    this.patientDao = patientDao;
    this.sqlSessionFactory = sqlSessionFactory;
  }

  @Override
  public void service(HttpServletRequest request, HttpServletResponse response) throws Exception {
    try {
      if (patientDao.delete(Integer.parseInt(request.getParameter("patientNo"))) == 0) {
        throw new Exception("해당 번호가 존재하지 않습니다.");
      } else {
        response.sendRedirect("/patient/list");
      }
      sqlSessionFactory.openSession(false).commit();

    } catch (Exception e) {
      sqlSessionFactory.openSession(false).rollback();
      throw new RuntimeException(e);
    }
  }
}
