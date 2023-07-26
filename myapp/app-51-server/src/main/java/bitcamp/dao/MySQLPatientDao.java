package bitcamp.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import bitcamp.myapp_project.dao.PatientDao;
import bitcamp.myapp_project.vo.Patient;
import bitcamp.util.DataSource;

public class MySQLPatientDao implements PatientDao {

  DataSource ds;

  public MySQLPatientDao(DataSource ds) {
    this.ds = ds;
  }

  @Override
  public void insert(Patient patient) {
    try (PreparedStatement stmt = ds.getConnection(false).prepareStatement(
        "insert into myapp_patient(parent_no,name,breeds,age,address,phone,gender)"
            + " values(?, ?, ?, ?, ?, ?, ?)")) {
      stmt.setInt(1, patient.getParentNo());
      stmt.setString(2, patient.getName());
      stmt.setString(3, patient.getBreeds());
      stmt.setInt(4, patient.getAge());
      stmt.setString(5, patient.getAddress());
      stmt.setInt(6, patient.getPhone());
      stmt.setString(7, String.valueOf(patient.getGender()));

      stmt.executeUpdate();

    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }

  @Override
  public List<Patient> list() {
    try (
        PreparedStatement stmt = ds.getConnection(false).prepareStatement(
            "select patient_no, parent_no, name, breeds, age, address, phone, gender"
                + " from myapp_patient" + " order by name asc");
        ResultSet rs = stmt.executeQuery()) {

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
    try (PreparedStatement stmt = ds.getConnection(false).prepareStatement(
        "select patient_no, parent_no, name, breeds, age, address, phone, gender, created_date"
            + " from myapp_patient" + " where patient_no=?")) {

      stmt.setInt(1, no);

      try (ResultSet rs = stmt.executeQuery()) {
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
          p.setCreatedDate(rs.getDate("created_date"));

          return p;
        }
        return null;
      }
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }

  @Override
  public Patient findByParentAndPhone(Patient param) {
    try (PreparedStatement stmt = ds.getConnection(false).prepareStatement(
        "select patient_no, parent_no, name, breeds, age, address, phone, gender, created_date"
            + " from myapp_patient" + " where parent_no=? and phone=?")) {

      stmt.setInt(1, param.getParentNo());
      stmt.setInt(2, param.getPhone());

      try (ResultSet rs = stmt.executeQuery()) {
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
          p.setCreatedDate(rs.getDate("created_date"));

          return p;
        }
        return null;
      }
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }

  @Override
  public int update(Patient patient) {
    try (PreparedStatement stmt = ds.getConnection(false)
        .prepareStatement("update myapp_patient set" + " parent_no=?," + " name=?," + " breeds=?,"
            + " age=?," + " address=?," + " phone=?," + " gender=?" + " where patient_no=?")) {

      stmt.setInt(1, patient.getParentNo());
      stmt.setString(2, patient.getName());
      stmt.setString(3, patient.getBreeds());
      stmt.setInt(4, patient.getAge());
      stmt.setString(5, patient.getAddress());
      stmt.setInt(6, patient.getPhone());
      stmt.setString(7, String.valueOf(patient.getGender()));
      stmt.setInt(8, patient.getPatientNo());

      return stmt.executeUpdate();

    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }

  @Override
  public int delete(int no) {
    try (PreparedStatement stmt =
        ds.getConnection(false).prepareStatement("delete from myapp_patient where patient_no=?")) {

      stmt.setInt(1, no);

      return stmt.executeUpdate();

    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }
}
