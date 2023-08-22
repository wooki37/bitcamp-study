package bitcamp.myapp_project.dao;

import java.util.List;
import bitcamp.myapp_project.vo.Patient;

public interface PatientDao {
  void insert(Patient patient);

  List<Patient> findAll();

  Patient findBy(int no);

  Patient findByPatientAndPhone(Patient p);

  int update(Patient patient);

  int delete(int no);

  int insertFiles(Patient p);
}
