package bitcamp.myapp_project.vo;

import java.io.Serializable;
import bitcamp.myapp.vo.CsvObject;

public class Patient implements Serializable, CsvObject {
  private static final long serialVersionUID = 1L;

  public static int userId = 1;

  public static final char MALE = 'M';
  public static final char FEMALE = 'W';

  private int no;
  private String name;
  private String breeds;
  private int age;
  private String address;
  private int phone;
  private char gender;

  public Patient() {
    this.no = userId++;
  }

  public Patient(int no) {
    this.no = no;
  }

  public static Patient fromCsv(String csv) {
    String[] values = csv.split(",");

    Patient patient = new Patient(Integer.parseInt(values[0]));
    patient.setNo(Integer.parseInt(values[1]));
    patient.setName(values[2]);
    patient.setBreeds(values[3]);
    patient.setAge(Integer.parseInt(values[4]));
    patient.setAddress(values[5]);
    patient.setPhone(Integer.parseInt(values[6]));
    patient.setGender(values[7].charAt(0));

    if (Patient.userId <= patient.getNo()) {
      Patient.userId = patient.getNo() + 1;
    }
    return patient;
  }

  @Override
  public String toCsvString() {
    return String.format("%d,%d,%s,%s,%d,%s,%d,%c", this.getNo(), this.getNo(), this.getName(),
        this.getBreeds(), this.getAge(), this.getAddress(), this.getPhone(), this.getGender());
  }

  public boolean equals(Object obj) {
    if (obj == null) {
      return false;
    }

    if (this.getClass() != obj.getClass()) {
      return false;
    }

    Patient p = (Patient) obj;

    if (this.getNo() != p.getNo()) {
      return false;
    }

    return true;
  }

  public int getNo() {
    return no;
  }

  public void setNo(int no) {
    this.no = no;
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
