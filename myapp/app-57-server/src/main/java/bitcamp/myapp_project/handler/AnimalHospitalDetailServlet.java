package bitcamp.myapp_project.handler;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import bitcamp.myapp.vo.AttachedFile;
import bitcamp.myapp_project.vo.Patient;

@WebServlet("/patient/detail")
public class AnimalHospitalDetailServlet extends HttpServlet {

  private static final long serialVersionUID = 1L;

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    String patientNoStr = request.getParameter("patientNo");
    if (patientNoStr == null || patientNoStr.isEmpty()) {
      response.sendError(HttpServletResponse.SC_BAD_REQUEST, "환자 번호를 확인할 수 없습니다.");
      return;
    }

    int patientNo;
    try {
      patientNo = Integer.parseInt(patientNoStr);
    } catch (NumberFormatException e) {
      response.sendError(HttpServletResponse.SC_BAD_REQUEST, "유효하지 않은 환자 번호입니다.");
      return;
    }

    Patient p = AHInitServlet.patientDao.findBy(patientNo);

    response.setContentType("text/html;charset=UTF-8");
    PrintWriter out = response.getWriter();
    out.println("<!DOCTYPE html>");
    out.println("<html>");
    out.println("<head>");
    out.println("<meta charset='UTF-8'>");
    out.println("<title>환자 상세 정보</title>");
    out.println("</head>");
    out.println("<body>");
    out.println("<h1>환자</h1>");

    if (p == null) {
      out.println("<p>해당 번호의 환자가 없습니다!</p>");
    } else {
      out.println("<form action='/patient/update' method='post'>");
      out.println("<table border='1'>");
      out.printf("<tr><th style='width:120px;'>환자번호</th>"
          + " <td style='width:300px;'><input type='text' name='patientNo' value='%d' readonly></td></tr>\n",
          p.getPatientNo());
      out.printf("<tr><th style='width:120px;'>보호자번호</th>"
          + " <td style='width:300px;'><input type='text' name='parentNo' value='%d' readonly></td></tr>\n",
          p.getParentNo());
      out.printf("<tr><th>이름</th>" + " <td><input type='text' name='name' value='%s'></td></tr>\n",
          p.getName());
      out.printf(
          "<tr><th>품종</th>" + " <td><input type='text' name='breeds' value='%s'></td></tr>\n",
          p.getBreeds());
      out.printf("<tr><th>나이</th>" + " <td><input type='text' name='age' value='%d'></td></tr>\n",
          p.getAge());
      out.printf(
          "<tr><th>주소</th>" + " <td><input type='text' name='address' value='%s'></td></tr>\n",
          p.getAddress());
      out.printf(
          "<tr><th>전화번호</th>" + " <td><input type='text' name='phone' value='%s'></td></tr>\n",
          p.getPhone());
      out.printf(
          "<tr><th>성별</th>\n" + " <td><select name='gender'>\n"
              + " <option value='M' %s>수컷</option>\n"
              + " <option value='W' %s>암컷</option></select></td></tr>\n",
          (p.getGender() == 'M' ? "selected" : ""), (p.getGender() == 'W' ? "selected" : ""));
      out.printf("<tr><th>등록일</th> <td>%tY-%1$tm-%1$td</td></tr>\n", p.getCreatedDate());
      out.println("<tr><th>첨부파일</th><td>");

      for (AttachedFile file : p.getAttachedFiles()) {
        out.printf("<a href='/upload/patient/%s'>%1$s</a><br>\n", file.getFilePath());
      }
      out.println("</td></tr>");
      out.println("</table>");

      out.println("<div>");
      out.println("<button>변경</button>");
      out.println("<button type='reset'>초기화</button>");
      out.printf("<a href='/patient/delete?patientNo=%d'>삭제</a>\n", p.getPatientNo());
      out.println("<a href='/patient/list'>목록</a>\n");
      out.println("</div>");
      out.println("</form>");
      try {
        AHInitServlet.sqlSessionFactory.openSession(false).commit();

      } catch (Exception e) {
        AHInitServlet.sqlSessionFactory.openSession(false).rollback();
      }
    }

    out.println("</body>");
    out.println("</html>");

  }
}


