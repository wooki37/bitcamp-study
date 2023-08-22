package bitcamp.myapp_project.handler;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import bitcamp.myapp_project.vo.Protector;

@WebServlet("/protector/update")
public class ProtectorUpdateServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    Protector pt = new Protector();
    pt.setNo(Integer.parseInt(request.getParameter("no")));
    pt.setName(request.getParameter("name"));
    pt.setEmail(request.getParameter("email"));
    pt.setPassword(request.getParameter("password"));
    pt.setAddress(request.getParameter("address"));
    pt.setPhone(request.getParameter("phone"));
    pt.setPostNo(request.getParameter("postNo"));

    response.setContentType("text/html;charset=UTF-8");
    PrintWriter out = response.getWriter();
    out.println("<!DOCTYPE html>");
    out.println("<html>");
    out.println("<head>");
    out.println("<meta charset='UTF-8'>");
    out.println("<meta http-equiv='refresh' content='1;url=/member/list'>");
    out.println("<title>보호자</title>");
    out.println("</head>");
    out.println("<body>");
    out.println("<h1>보호자 변경</h1>");

    try {
      if (AHInitServlet.protectorDao.update(pt) == 0) {
        out.println("<p>해당 보호자가 없습니다.</p>");
      } else {
        AHInitServlet.sqlSessionFactory.openSession(false).commit();
        out.println("<p>변경했습니다!</p>");
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
