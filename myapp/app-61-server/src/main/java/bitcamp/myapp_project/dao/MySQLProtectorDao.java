package bitcamp.myapp_project.dao;

import java.util.List;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import bitcamp.myapp_project.vo.Protector;

public class MySQLProtectorDao implements ProtectorDao {

  SqlSessionFactory sqlSessionFactory;

  public MySQLProtectorDao(SqlSessionFactory sqlSessionFactory) {
    this.sqlSessionFactory = sqlSessionFactory;
  }

  @Override
  public void insert(Protector protector) {
    SqlSession sqlSession = sqlSessionFactory.openSession(false);
    sqlSession.insert("bitcamp.myapp_project.dao.ProtectorDao.insert", protector);
  }

  @Override
  public List<Protector> findAll() {
    SqlSession sqlSession = sqlSessionFactory.openSession(false);
    return sqlSession.selectList("bitcamp.myapp_project.dao.ProtectorDao.findAll");
  }

  @Override
  public Protector findBy(int no) {
    SqlSession sqlSession = sqlSessionFactory.openSession(false);
    return sqlSession.selectOne("bitcamp.myapp_project.dao.ProtectorDao.findBy", no);
  }

  @Override
  public Protector findByPhoneAndPassword(Protector protector) {
    SqlSession sqlSession = sqlSessionFactory.openSession(false);
    return sqlSession.selectOne("bitcamp.myapp_prject.dao.ProtectorDao.findByPhoneAndPassword",
        protector);
  }

  @Override
  public int update(Protector protector) {
    SqlSession sqlSession = sqlSessionFactory.openSession(false);
    return sqlSession.update("bitcamp.myapp_project.dao.ProtectorDao.update", protector);
  }

  @Override
  public int delete(int no) {
    SqlSession sqlSession = sqlSessionFactory.openSession(false);
    return sqlSession.delete("bitcamp.myapp_project.dao.ProtectorDao.delete", no);
  }

}
