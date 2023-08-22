package bitcamp.myapp_project.handler;

import java.io.PrintWriter;
import org.apache.ibatis.session.SqlSessionFactory;
import bitcamp.myapp_project.dao.PatientDao;
import bitcamp.myapp_project.vo.Patient;
import bitcamp.util.Component;
import bitcamp.util.HttpServletRequest;
import bitcamp.util.HttpServletResponse;
import bitcamp.util.Servlet;

@Component("/patient/detail")
public class AnimalHospitalDetailServlet implements Servlet {

  PatientDao patientDao;
  SqlSessionFactory sqlSessionFactoruy;

  public AnimalHospitalDetailServlet(PatientDao patientDao, SqlSessionFactory sqlSessionFactoruy) {
    this.patientDao = patientDao;
    this.sqlSessionFactoruy = sqlSessionFactoruy;
  }

  @Override
  public void service(HttpServletRequest request, HttpServletResponse response) throws Exception {
    Patient p = patientDao.findBy(Integer.parseInt(request.getParameter("patientNo")));

    response.setContentType("text/html;charset=UTF-8");
    PrintWriter out = response.getWriter();
    out.println("<!DOCTYPE html>");
    out.println("<html>");
    out.println("<head>");
    out.println("<meta charset='UTF-8'>");
    out.println("<title>환자</title>");
    out.println("</head>");
    out.println("<body>");
    out.println("<h1>환자</h1>");

    if (p == null) {
      out.println("<p>해당 번호의 환자가 없습니다!</p>");
    } else {
      out.println("<form action='/p/update'>");
      out.println("<table border='1'>");
      out.printf("<tr><th style='width:120px;'>환자번호</th>"
          + " <td style='width:300px;'><input type='text' name='patinetNo' value='%d' readonly></td></tr>\n",
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
      out.println("</table>");

      out.println("<div>");
      out.println("<button>변경</button>");
      out.println("<button type='reset'>초기화</button>");
      out.printf("<a href='/p/delete?patientNo=%d'>삭제</a>\n", p.getPatientNo());
      out.println("<a href='/p/list'>목록</a>\n");
      out.println("</div>");
      out.println("</form>");
    }

    out.println("</body>");
    out.println("</html>");

  }
}


