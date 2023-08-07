package bitcamp.myapp_project.handler;

import java.io.PrintWriter;
import org.apache.ibatis.session.SqlSessionFactory;
import bitcamp.myapp_project.dao.PatientDao;
import bitcamp.myapp_project.vo.Patient;
import bitcamp.util.Component;
import bitcamp.util.HttpServletRequest;
import bitcamp.util.HttpServletResponse;
import bitcamp.util.Servlet;

@Component("/patient/add")
public class AnimalHospitalAddServlet implements Servlet {

  PatientDao patientDao;
  SqlSessionFactory sqlSessionFactory;

  public AnimalHospitalAddServlet(PatientDao patientDao, SqlSessionFactory sqlSessionFactory) {
    this.patientDao = patientDao;
    this.sqlSessionFactory = sqlSessionFactory;
  }

  @Override
  public void service(HttpServletRequest request, HttpServletResponse response) throws Exception {
    Patient p = new Patient();

    p.setParentNo(Integer.parseInt(request.getParameter("parentNo")));
    p.setName(request.getParameter("name"));
    p.setBreeds(request.getParameter("breeds"));
    p.setAge(Integer.parseInt(request.getParameter("age")));
    p.setAddress(request.getParameter("address"));
    p.setPhone(request.getParameter("phone"));
    p.setGender(request.getParameter("gender").charAt(0));

    response.setContentType("text/html;charset=UTF-8");
    PrintWriter out = response.getWriter();
    out.println("<!DOCTYPE html>");
    out.println("<html>");
    out.println("<head>");
    out.println("<meta charset='UTF-8'>");
    out.println("<meta http-equiv='refresh' content='1;url=/patient/list'>");
    out.println("<title>환자</title>");
    out.println("</head>");
    out.println("<body>");
    out.println("<h1>환자 등록</h1>");

    try {
      patientDao.insert(p);
      sqlSessionFactory.openSession(false).commit();
      out.println("<p>등록 성공입니다!</p>");

    } catch (Exception e) {
      sqlSessionFactory.openSession(false).rollback();
      out.println("<p>등록 실패입니다!</p>");
      e.printStackTrace();
    }
    out.println("</body>");
    out.println("</html>");
  }
}

