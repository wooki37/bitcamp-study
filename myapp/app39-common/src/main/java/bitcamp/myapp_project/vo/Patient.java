package bitcamp.myapp_project.vo;

import java.io.Serializable;
import bitcamp.myapp.vo.AutoIncrement;
import bitcamp.myapp.vo.CsvObject;

public class Patient implements Serializable, CsvObject, AutoIncrement {
  private static final long serialVersionUID = 1L;

  public static int userId = 1;

  public static final char MALE = 'M';
  public static final char FEMALE = 'W';

  private int patientNo;
  private int parentNo;
  private String name;
  private String breeds;
  private int age;
  private String address;
  private int phone;
  private char gender;

  public Patient() {}

  public Patient(int patientNo) {
    this.patientNo = patientNo;
  }

  public static Patient fromCsv(String csv) {
    String[] values = csv.split(",");

    Patient patient = new Patient(Integer.parseInt(values[0]));
    patient.setParentNo(Integer.parseInt(values[1]));
    patient.setName(values[2]);
    patient.setBreeds(values[3]);
    patient.setAge(Integer.parseInt(values[4]));
    patient.setAddress(values[5]);
    patient.setPhone(Integer.parseInt(values[6]));
    patient.setGender(values[7].charAt(0));

    if (Patient.userId <= patient.getPatientNo()) {
      Patient.userId = patient.getPatientNo() + 1;
    }
    return patient;
  }

  @Override
  public String toCsvString() {
    return String.format("%d,%d,%s,%s,%d,%s,%d,%c", this.getPatientNo(), this.getParentNo(),
        this.getName(), this.getBreeds(), this.getAge(), this.getAddress(), this.getPhone(),
        this.getGender());
  }

  @Override
  public void updateKey() {
    if (Patient.userId <= this.patientNo) {
      Patient.userId = this.patientNo + 1;
    }
  }

  public boolean equals(Object obj) {
    if (obj == null) {
      return false;
    }

    if (this.getClass() != obj.getClass()) {
      return false;
    }

    Patient p = (Patient) obj;

    if (this.getPatientNo() != p.getPatientNo()) {
      return false;
    }

    return true;
  }

  public int getPatientNo() {
    return patientNo;
  }

  public void setPatinetNo(int patientNo) {
    this.patientNo = patientNo;
  }

  public int getParentNo() {
    return parentNo;
  }

  public void setParentNo(int parentNo) {
    this.parentNo = parentNo;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getBreeds() {
    return breeds;
  }

  public void setBreeds(String breeds) {
    this.breeds = breeds;
  }

  public int getAge() {
    return age;
  }

  public void setAge(int age) {
    this.age = age;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public int getPhone() {
    return phone;
  }

  public void setPhone(int phone) {
    this.phone = phone;
  }

  public char getGender() {
    return gender;
  }

  public void setGender(char gender) {
    this.gender = gender;
  }
}
