package bitcamp.myapp_project.dao;

import java.util.List;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import bitcamp.myapp_project.vo.Patient;
import bitcamp.util.Component;

@Component
public class MySQLPatientDao implements PatientDao {

  SqlSessionFactory sqlSessionFactory;

  public MySQLPatientDao(SqlSessionFactory sqlSessionFactory) {
    this.sqlSessionFactory = sqlSessionFactory;
  }

  @Override
  public void insert(Patient patient) {
    SqlSession sqlSession = sqlSessionFactory.openSession(false);
    sqlSession.insert("bitcamp.myapp_project.dao.PatientDao.insert", patient);
  }

  @Override
  public List<Patient> findAll(int category) {
    SqlSession sqlSession = sqlSessionFactory.openSession();
    return sqlSession.selectList("bitcamp.myapp_project.dao.PatientDao.findAll");
  }

  @Override
  public Patient findBy(int no) {
    SqlSession sqlSession = sqlSessionFactory.openSession();
    return sqlSession.selectOne("bitcamp.myapp_project.dao.PatientDao.findBy", no);
  }

  @Override
  public Patient findByPatientAndPhone(Patient patient) {
    SqlSession sqlSession = sqlSessionFactory.openSession();
    return sqlSession.selectOne("bitcamp.myapp_project.dao.PatientDao.findByPatientAndPhone",
        patient);
  }

  @Override
  public int update(Patient patient) {
    SqlSession sqlSession = sqlSessionFactory.openSession(false);
    return sqlSession.update("bitcamp.myapp_project.dao.PatientDao.update", patient);
  }

  @Override
  public int delete(int no) {
    SqlSession sqlSession = sqlSessionFactory.openSession(false);
    return sqlSession.delete("bitcamp.myapp_project.dao.PatientDao.delete", no);
  }
}
