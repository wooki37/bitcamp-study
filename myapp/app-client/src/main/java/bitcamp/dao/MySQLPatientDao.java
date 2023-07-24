package bitcamp.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import bitcamp.myapp_project.dao.PatientDao;
import bitcamp.myapp_project.vo.Patient;

public class MySQLPatientDao implements PatientDao {

  Connection con;

  public MySQLPatientDao(Connection con) {
    this.con = con;
  }

  @Override
  public void insert(Patient patient) {
    try (Statement stmt = con.createStatement()) {

      stmt.executeUpdate(String.format(
          "insert into myapp_patient(parent_no,name,breeds,age,address,phone,gender) values('%d', '$s', '%s', '%d', '%s', '%d', '%c')",
          patient.getParentNo(), patient.getName(), patient.getBreeds(), patient.getAge(),
          patient.getAddress(), patient.getPhone(), patient.getGender()));

    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }

  @Override
  public List<Patient> list() {
    try (Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(
            "select patient_no, parent_no, name, breeds, age, address, phone, gender from myapp_patient order by name asc")) {

      List<Patient> list = new ArrayList<>();

      while (rs.next()) {
        Patient p = new Patient();
        p.setPatientNo(rs.getInt("patient_no"));
        p.setParentNo(rs.getInt("parent_no"));
        p.setName(rs.getString("name"));
        p.setBreeds(rs.getString("breeds"));
        p.setAge(rs.getInt("age"));
        p.setAddress(rs.getString("address"));
        p.setPhone(rs.getInt("phone"));
        p.setGender(rs.getString("gender").charAt(0));

        list.add(p);
      }
      return list;
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }

  @Override
  public Patient findBy(int no) {
    try (Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(
            "select patient_no, parent_no, name, breeds, age, address, phone, gender from myapp_patient where patient_no="
                + no)) {

      if (rs.next()) {
        Patient p = new Patient();
        p.setPatientNo(rs.getInt("patient_no"));
        p.setParentNo(rs.getInt("parent_no"));
        p.setName(rs.getString("name"));
        p.setBreeds(rs.getString("breeds"));
        p.setAge(rs.getInt("age"));
        p.setAddress(rs.getString("address"));
        p.setPhone(rs.getInt("phone"));
        p.setGender(rs.getString("gender").charAt(0));

        return p;
      }
      return null;
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }

  @Override
  public int update(Patient patient) {
    try (Statement stmt = con.createStatement()) {

      return stmt.executeUpdate(String.format(
          "update myapp_patient set parent_no='%d', name='%s', breeds='%s', age='%d', address='%s', phone='%d', gender='%c', where patient_no=%d",
          patient.getParentNo(), patient.getName(), patient.getBreeds(), patient.getAge(),
          patient.getAddress(), patient.getPhone(), patient.getGender()));

    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }

  @Override
  public int delete(int no) {
    try (Statement stmt = con.createStatement()) {

      return stmt.executeUpdate(String.format("delete from myapp_patient where patient_no=%d", no));

    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }
}
