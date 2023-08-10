package bitcamp.myapp_project.handler;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import bitcamp.myapp_project.dao.MySQLPatientDao;
import bitcamp.myapp_project.dao.PatientDao;
import bitcamp.util.SqlSessionFactoryProxy;

@WebServlet(value = "/AHinit", loadOnStartup = 1)
public class AHInitServlet extends HttpServlet {

  private static final long serialVersionUID = 1L;

  public static SqlSessionFactory sqlSessionFactory;
  public static PatientDao patientDao;

  @Override
  public void init() throws ServletException {
    System.out.println("AHInitServlet.init() 호출됨!");

    try {
      sqlSessionFactory = new SqlSessionFactoryProxy(new SqlSessionFactoryBuilder()
          .build(Resources.getResourceAsStream("bitcamp/myapp/config/mybatis-config.xml")));

      patientDao = new MySQLPatientDao(sqlSessionFactory);

    } catch (Exception e) {
      System.out.println("AHInitServlet.init() 실행 중 오류 발생!");
      e.printStackTrace();
    }
  }
}
