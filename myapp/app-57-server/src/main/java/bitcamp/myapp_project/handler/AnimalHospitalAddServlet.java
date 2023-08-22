package bitcamp.myapp_project.handler;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import bitcamp.myapp.vo.AttachedFile;
import bitcamp.myapp_project.vo.Patient;

@WebServlet("/patient/add")
public class AnimalHospitalAddServlet extends HttpServlet {

  private static final long serialVersionUID = 1L;

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    try {
      // 멀티파트의 각 파트 데이터를 저장할 객체 공장
      DiskFileItemFactory factory = new DiskFileItemFactory();

      // 멀티파트 형식으로 넘어온 요청 파라미터를 분석하여 처리하는 객체
      ServletFileUpload upload = new ServletFileUpload(factory);

      // 멀티파트 요청 파라미터를 분석
      List<FileItem> parts = upload.parseRequest(request);

      // 각각의 파트에서 값을 꺼낸다.
      Patient p = new Patient();

      // 웹 애플리케이션 환경 정보를 알고 있는 객체 꺼내기
      ServletContext 웹애플리케이션환경정보 = request.getServletContext();

      // 웹 애플리케이션 환경정보에서 /upload/patient/ 디렉토리의 실제 경로를 추출한다.
      String uploadDir = 웹애플리케이션환경정보.getRealPath("/upload/patient/");

      ArrayList<AttachedFile> attachedFiles = new ArrayList<>();

      for (FileItem part : parts) {
        if (part.isFormField()) { // 일반 데이터
          if (part.getFieldName().equals("name")) {
            p.setName(part.getString("UTF-8"));
          } else if (part.getFieldName().equals("phone")) {
            p.setPhone(part.getString("UTF-8"));
          }
        } else { // 파일데이터
          // 업로드 파일은 배포 폴더에 저장한다.
          // 1) 파일을 저장할 때 사용할 이름을 준비한다.
          String filename = UUID.randomUUID().toString();

          // 2) upload 배포 폴더에 파일을 저장한다.
          part.write(new File(uploadDir, filename));

          // 3) 파일 이름을 객체에 보관하여 목록에 추가한다.
          AttachedFile attachedFile = new AttachedFile();
          attachedFile.setFilePath(filename);

          attachedFiles.add(attachedFile);
        }
      }
      p.setAttachedFiles(attachedFiles);

      p.setParentNo(Integer.parseInt(request.getParameter("parentNo")));
      p.setName(request.getParameter("name"));

      // 직접입력인 경우에는 breeds_custom 값을 사용
      String selectedBreeds = request.getParameter("breeds");
      if ("직접입력".equals(selectedBreeds)) {
        p.setBreeds(request.getParameter("breeds_custom"));
      } else {
        p.setBreeds(selectedBreeds);
      }

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
      out.println("<title>환자 등록</title>");
      out.println("</head>");
      out.println("<body>");
      out.println("<h1>환자 등록</h1>");

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
    } catch (Exception e) {
      throw new ServletException(e);
    }
  }
}
