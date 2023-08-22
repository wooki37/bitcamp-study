package bitcamp.myapp_project.vo;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;
import java.util.Objects;

public class Patient implements Serializable {
  private static final long serialVersionUID = 1L;

  public static final char MALE = 'M';
  public static final char FEMALE = 'W';

  private int patientNo;
  private Protector protectorNo;
  private String name;
  private String breeds;
  private int age;
  private String address;
  private String phone;
  private char gender;
  private Timestamp createdDate;
  private String haru;
  private String hadol;
  private int category;
  private List<AHAttachedFile> attachedFiles;

  @Override
  public int hashCode() {
    return Objects.hash(patientNo);
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    Patient other = (Patient) obj;
    return patientNo == other.patientNo;
  }

  @Override
  public String toString() {
    return "Patient [patientNo=" + patientNo + ", protectorNo=" + protectorNo + ", name=" + name
        + ", breeds=" + breeds + ", age=" + age + ", address=" + address + ", phone=" + phone
        + ", gender=" + gender + ", createdDate=" + createdDate + ", haru=" + haru + ", hadol="
        + hadol + ", category=" + category + ", attachedFiles=" + attachedFiles + "]";
  }

  public int getPatientNo() {
    return patientNo;
  }

  public void setPatientNo(int patientNo) {
    this.patientNo = patientNo;
  }

  public Protector getProtectorNo() {
    return protectorNo;
  }

  public void setProtectorNo(Protector protectorNo) {
    this.protectorNo = protectorNo;
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

  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }

  public char getGender() {
    return gender;
  }

  public void setGender(char gender) {
    this.gender = gender;
  }

  public String getHaru() {
    return haru;
  }

  public void setHaru(String haru) {
    this.haru = haru;
  }

  public String getHadol() {
    return haru;
  }

  public void setHadol(String hadol) {
    this.hadol = hadol;
  }

  public Timestamp getCreatedDate() {
    return createdDate;
  }

  public void setCreatedDate(Timestamp createdDate) {
    this.createdDate = createdDate;
  }

  public int getCategory() {
    return category;
  }

  public void setCategory(int category) {
    this.category = category;
  }

  public List<AHAttachedFile> getAttachedFiles() {
    return attachedFiles;
  }

  public void setAttachedFiles(List<AHAttachedFile> attachedFiles) {
    this.attachedFiles = attachedFiles;
  }

}
