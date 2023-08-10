package bitcamp.myapp_project.handler;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/patient/delete")
public class AnimalHospitalDeleteServlet extends HttpServlet {

  private static final long serialVersionUID = 1L;

  @Override
  protected void service(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    try {
      if (AHInitServlet.patientDao
          .delete(Integer.parseInt(request.getParameter("patientNo"))) == 0) {
        throw new Exception("해당 번호가 존재하지 않습니다.");
      } else {
        response.sendRedirect("/patient/list");
      }
      AHInitServlet.sqlSessionFactory.openSession(false).commit();

    } catch (Exception e) {
      AHInitServlet.sqlSessionFactory.openSession(false).rollback();
      throw new RuntimeException(e);
    }
  }
}
