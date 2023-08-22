package bitcamp.myapp_project.handler;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/patient/form")
public class AnimalFormServlet extends HttpServlet {
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
    out.println("<title>동물사랑</title>");
    out.println("</head>");
    out.println("<body>");
    out.println("<h1>저장</h1>");
    out.println("<form action='/patient/add' method='post' enctype='multipart/form-data'>");
    out.println("이름 <input type='text' name='name'><br>");
    out.println("전화번호 <textarea name='phone'></textarea><br>");
    out.println("파일 <input type='file' name='files' multiple><br>");
    out.println("<button>등록</button>");
    out.println("</form>");
    out.println("</body>");
    out.println("</html>");
  }
}
