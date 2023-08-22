package bitcamp.myapp_project.handler;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import bitcamp.myapp_project.vo.Protector;

@WebServlet("/protector/list")
public class ProtectorListServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    response.setContentType("text/html;charset=UTF-8");
    PrintWriter out = response.getWriter();
    out.println("<!DOCTYPE html>");
    out.println("<html>");
    out.println("<head>");
    out.println("<meta charset='UTF-8'>");
    out.println("<title>보호자</title>");
    out.println("</head>");
    out.println("<body>");
    out.println("<h1>보호자 목록</h1>");
    out.println("<div style='margin:5px;'>");
    out.println("<a href='/protector/form.html'>새 보호자</a>");
    out.println("</div>");
    out.println("<table border='1'>");
    out.println("<thead>");
    out.println("  <tr><th>번호</th> <th>이름</th> <th>이메일</th> <th>전화번호</th> <th>주소</th></tr>");
    out.println("</thead>");

    List<Protector> list = AHInitServlet.protectorDao.findAll();
    for (Protector pt : list) {
      out.printf(
          "<tr>" + " <td>%d</td>" + " <td><a href='/protector/detail?no=%d'>%s</a></td>"
              + " <td>%s</td></tr>\n",
          pt.getNo(), pt.getNo(), pt.getName(), pt.getEmail(), pt.getPhone(), pt.getAddress());
    }

    out.println("</tbody>");
    out.println("</table>");
    out.println("<a href='/'>메인</a>");
    out.println("</body>");
    out.println("</html>");
  }

}
