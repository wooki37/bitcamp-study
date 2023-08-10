package bitcamp.myapp_project.handler;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import bitcamp.myapp_project.vo.Patient;

@WebServlet("/patient/list")
public class AnimalHospitalListServlet extends HttpServlet {

  private static final long serialVersionUID = 1L;
  SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd");

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    response.setContentType("text/html;charset=UTF-8");
    PrintWriter out = response.getWriter();
    out.println("<!DOCTYPE html>");
    out.println("<html>");
    out.println("<head>");
    out.println("<meta charset='UTF-8'>");
    out.println("<title>환자목록</title>");
    out.println("</head>");
    out.println("<body>");
    out.println("<h1>동물병원 환자 목록</h1>");
    out.println("<div style='margin:5px;'>");
    out.println("<a href='/patient/form.html'>새 환자</a>");
    out.println("</div>");
    out.println("<table border='1'>");
    out.println("<thead>");
    out.println(
        "  <tr><th>환자번호</th> <th>보호자번호</th> <th>이름</th> <th>품종</th> <th>나이</th> <th>주소</th> <th>성별</th> <th>등록일</th> </tr>");
    out.println("</thead>");
    out.println("<tbody>");

    List<Patient> list = AHInitServlet.patientDao.findAll();
    for (Patient p : list) {
      out.printf(
          "<tr> <td><a href='/patient/detail?patientNo=%d'>%d</a></td>,<td>%d</td>,<td>%s</td>,<td>%s</td>,<td>%d</td>,<td>%s</td>,<td>%s</td>,<td>%s</td> </tr>\n",
          p.getPatientNo(), p.getPatientNo(), p.getParentNo(), p.getName(), p.getBreeds(),
          p.getAge(), p.getAddress() != null ? p.getAddress() : "", p.getGender(),
          (p.getCreatedDate() != null ? dateFormatter.format(p.getCreatedDate()) : ""));
    }
    out.println("</tbody>");
    out.println("</table>");
    out.println("<a href='/'>메인</a>");
    out.println("</body>");
    out.println("</html>");
  }
}
