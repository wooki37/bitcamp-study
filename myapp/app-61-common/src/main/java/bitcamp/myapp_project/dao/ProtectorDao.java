package bitcamp.myapp_project.dao;

import java.util.List;
import bitcamp.myapp_project.vo.Protector;

public interface ProtectorDao {
  void insert(Protector protector);

  List<Protector> findAll();

  Protector findBy(int no);

  Protector findByPhoneAndPassword(Protector protector);

  int update(Protector protector);

  int delete(int no);
}
