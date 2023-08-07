package bitcamp.myapp_project.handler;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import bitcamp.myapp_project.vo.Patient;

@WebServlet("/patient/update")
public class AnimalHospitalUpdateServlet extends HttpServlet {

  private static final long serialVersionUID = 1L;

  @Override
  protected void service(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    Patient p = new Patient();
    p.setPatientNo(Integer.parseInt(request.getParameter("patientNo")));
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
    out.println("<h1>환자 정보 변경</h1>");

    try {
      if (AHInitServlet.patientDao.update(p) == 0) {
        out.println("<p>등록된 환자정보가 없습니다.</p>");
      } else {
        AHInitServlet.sqlSessionFactory.openSession(false).commit();
        out.println("<p>변경 완료 했습니다!</p>");
      }
    } catch (Exception e) {
      AHInitServlet.sqlSessionFactory.openSession(false).rollback();
      out.println("<p>변경 실패입니다!</p>");
      e.printStackTrace();
    }

    out.println("</body>");
    out.println("</html>");
  }
}
