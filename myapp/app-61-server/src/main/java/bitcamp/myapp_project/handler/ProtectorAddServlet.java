package bitcamp.myapp_project.handler;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import bitcamp.myapp_project.vo.Protector;

@WebServlet("/protector/add")
public class ProtectorAddServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    Protector pt = new Protector();
    pt.setName(request.getParameter("name"));
    pt.setEmail(request.getParameter("email"));
    pt.setPassword(request.getParameter("password"));
    pt.setPhone(request.getParameter("phone"));
    pt.setAddress(request.getParameter("address"));
    pt.setPostNo(request.getParameter("postNo"));

    response.setContentType("text/html;charset=UTF-8");
    PrintWriter out = response.getWriter();
    out.println("<!DOCTYPE html>");
    out.println("<html>");
    out.println("<head>");
    out.println("<meta charset='UTF-8'>");
    out.println("<meta http-equiv='refresh' content='1;url=/protector/list'>");
    out.println("<title>보호자</title>");
    out.println("</head>");
    out.println("<body>");
    out.println("<h1>보호자 등록</h1>");

    try {
      AHInitServlet.protectorDao.insert(pt);
      AHInitServlet.sqlSessionFactory.openSession(false).commit();
      out.println("<p>등록 성공입니다!</p>");

    } catch (Exception e) {
      AHInitServlet.sqlSessionFactory.openSession(false).rollback();
      out.println("<p>등록 실패입니다!</p>");
      e.printStackTrace();
    }
    out.println("</body>");
    out.println("</html>");
  }
}
