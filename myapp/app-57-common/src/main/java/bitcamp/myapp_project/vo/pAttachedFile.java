package bitcamp.myapp_project.vo;

import java.io.Serializable;

public class pAttachedFile implements Serializable {
  private static final long serialVersionUID = 1L;

  int no;
  String originName;
  String filePath;
  int patientNo;

  @Override
  public String toString() {
    return "pAttachedFile [no=" + no + ", originName=" + originName + ", filePath=" + filePath
        + ", patientNo=" + patientNo + "]";
  }

  public int getNo() {
    return no;
  }

  public void setNo(int no) {
    this.no = no;
  }

  public String getOriginName() {
    return originName;
  }

  public void setOriginName(String originName) {
    this.originName = originName;
  }

  public String getFilePath() {
    return filePath;
  }

  public void setFilePath(String filePath) {
    this.filePath = filePath;
  }

  public int getPatientNo() {
    return patientNo;
  }

  public void setPatientNo(int patientNo) {
    this.patientNo = patientNo;
  }


}
