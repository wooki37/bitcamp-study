package bitcamp.myapp_project.dao;

import java.util.List;
import bitcamp.myapp_project.vo.Patient;

public interface PatientDao {
  void insert(Patient patient);

  List<Patient> list();

  Patient findBy(int no);

  Patient findByParentAndPhone(Patient p);

  int update(Patient patient);

  int delete(int no);
}
