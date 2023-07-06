package bitcamp.myapp_project.dao;

import java.util.ArrayList;
import java.util.List;
import bitcamp.myapp_project.vo.Patient;
import bitcamp.util.JsonDataHelper;

public class PatientListDao implements PatientDao {
  String filename;
  ArrayList<Patient> list = new ArrayList<>();

  public PatientListDao(String filename) {
    this.filename = filename;
    JsonDataHelper.loadJson(filename, list, Patient.class);
  }

  @Override
  public void insert(Patient patient) {
    // 데이터 입력할 때 해당 데이터의 식별 번호는 DAO에서 관리한다.
    patient.setPatinetNo(Patient.userId++);
    this.list.add(patient);

    // 데이터를 등록할 때 마다 즉시 파일에 저장한다.
    JsonDataHelper.saveJson(filename, list);
  }

  @Override
  public List<Patient> list() {
    return this.list;
  }

  @Override
  public Patient findBy(int no) {
    for (int i = 0; i < this.list.size(); i++) {
      Patient p = this.list.get(i);
      if (p.getPatientNo() == no) {
        return p;
      }
    }
    return null;
  }

  @Override
  public int update(Patient patient) {
    for (int i = 0; i < list.size(); i++) {
      if (list.get(i).getPatientNo() == patient.getPatientNo()) {
        list.set(i, patient);
        JsonDataHelper.saveJson(filename, list);
        return 1;
      }
    }
    return 0;
  }

  @Override
  public int delete(int no) {
    for (int i = 0; i < list.size(); i++) {
      if (list.get(i).getPatientNo() == no) {
        list.remove(i);
        JsonDataHelper.saveJson(filename, list);
        return 1;
      }
    }
    return 0;
  }
}
