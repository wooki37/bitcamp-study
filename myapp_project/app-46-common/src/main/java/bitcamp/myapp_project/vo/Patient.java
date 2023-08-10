package bitcamp.myapp_project.vo;

import java.io.Serializable;

public class Patient implements Serializable {
  private static final long serialVersionUID = 1L;

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

  public void setPatientNo(int patientNo) {
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
