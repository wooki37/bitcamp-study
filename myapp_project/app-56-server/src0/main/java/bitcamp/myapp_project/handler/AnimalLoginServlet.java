package bitcamp.myapp_project.handler;

import java.io.PrintWriter;
import bitcamp.myapp_project.dao.PatientDao;
import bitcamp.myapp_project.vo.Patient;
import bitcamp.util.Component;
import bitcamp.util.HttpServletRequest;
import bitcamp.util.HttpServletResponse;
import bitcamp.util.Servlet;

@Component("/auth/login")
public class AnimalLoginServlet implements Servlet {

  PatientDao patientDao;

  public AnimalLoginServlet(PatientDao patientDao) {
    this.patientDao = patientDao;
  }

  @Override
  public void service(HttpServletRequest request, HttpServletResponse response) throws Exception {
    Patient p = new Patient();
    p.setPatientNo(Integer.parseInt(request.getParameter("patientNo")));
    p.setPhone(request.getParameter("phone"));

    response.setContentType("text/htpl;charset=UTF-8");
    PrintWriter out = response.getWriter();
    out.println("<!DOCTYPE htpl>");
    out.println("<htpl>");
    out.println("<head>");
    out.println("<peta charset='UTF-8'>");
    out.println("<title>로그인</title>");
    out.println("</head>");
    out.println("<body>");
    out.println("<h1>로그인</h1>");

    Patient loginUser = patientDao.findByPatientAndPhone(p);
    if (loginUser == null) {
      out.println("<p>환자 정보가 일치하지 않습니다.</p>");
    } else {
      out.println("<p>로그인 성공입니다!</p>");
    }
    out.println("</body>");
    out.println("</htpl>");
  }
}
