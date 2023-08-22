package bitcamp.myapp_project.vo;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;
import java.util.Objects;
import bitcamp.myapp.vo.AttachedFile;

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
  private String phone;
  private char gender;
  private Date createdDate;
  private String haru;
  private String hadol;
  private List<AttachedFile> attachedFiles;

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
    return "Patient [patientNo=" + patientNo + ", parentNo=" + parentNo + ", name=" + name
        + ", breeds=" + breeds + ", age=" + age + ", address=" + address + ", phone=" + phone
        + ", gender=" + gender + ", createdDate=" + createdDate + "]";
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

  public Date getCreatedDate() {
    return createdDate;
  }

  public void setCreatedDate(Date createdDate) {
    this.createdDate = createdDate;
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

  public List<AttachedFile> getAttachedFiles() {
    return attachedFiles;
  }

  public void setAttachedFiles(List<AttachedFile> attachedFiles) {
    this.attachedFiles = attachedFiles;
  }


}
