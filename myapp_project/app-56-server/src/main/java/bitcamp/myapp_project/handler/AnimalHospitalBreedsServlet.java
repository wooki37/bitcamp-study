package bitcamp.myapp_project.handler;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import bitcamp.myapp_project.vo.Patient;

@WebServlet("/patient/breeds")
public class AnimalHospitalBreedsServlet extends HttpServlet {

  private static final long serialVersionUID = 1L;

  @Override
  protected void service(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    Patient p = new Patient();

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
    out.println("<title>품종 선택</title>");
    out.println("</head>");
    out.println("<body>");
    out.println("<h1>품종 선택</h1>");
    out.println("<form method='post' action='/getBreed'>");
    out.println("<label>품종을 선택해주세요:</label>");
    out.println("<select name='breedType'>");
    out.println("<option value='1'>강아지</option>");
    out.println("<option value='2'>고양이</option>");
    out.println("<option value='3'>직접입력</option>");
    out.println("</select>");
    out.println("<input type='submit' value='확인'>");
    out.println("</form>");

    try {
      AHInitServlet.patientDao.insert(p);
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

  // private static String getPatientBreed(HttpServletRequest request, HttpServletResponse response)
  // throws Exception {
  // boolean isValidNum = true; // 입력된 번호가 유효한지 여부
  // String num = null;
  // String breedType = null;
  // while (isValidNum) {
  // num = prompt.inputString("품종? 1. 강아지, 2.고양이. 3.직접입력").trim(); // trim() : 입력된 문자열의 양쪽 공백
  // // 제거
  // if ("1".equals(num)) {
  // breedType = "강아지";
  // isValidNum = false;
  // } else if ("2".equals(num)) {
  // breedType = "고양이";
  // isValidNum = false;
  // } else if ("3".equals(num)) {
  // breedType = prompt.inputString("품종 타입을 직접 입력해주세요 > ");
  // isValidNum = false;
  // } else { // isValidNum 변수는 여전히 true이므로 루프가 반복됩니다.
  // prompt.println("입력에 없는 번호입니다. 다시 입력해주세요");
  // }
  // }
  // return breedType;
  // }
}

