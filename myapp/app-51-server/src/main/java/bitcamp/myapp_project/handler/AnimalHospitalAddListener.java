package bitcamp.myapp_project.handler;

import java.io.IOException;
import bitcamp.myapp_project.dao.PatientDao;
import bitcamp.myapp_project.vo.Patient;
import bitcamp.util.BreadcrumbPrompt;
import bitcamp.util.DataSource;

public class AnimalHospitalAddListener implements AnimalHospitalActionListener {

  PatientDao patientDao;
  DataSource ds;

  public AnimalHospitalAddListener(PatientDao patientDao, DataSource ds) {
    this.patientDao = patientDao;
    this.ds = ds;
  }

  @Override
  public void service(BreadcrumbPrompt prompt) throws IOException {
    Patient p = new Patient();

    p.setParentNo(Integer.parseInt(prompt.inputString("보호자ID? ")));
    p.setName(prompt.inputString("환자명? "));
    p.setBreeds(getMemberBreed(prompt));
    p.setAge(Integer.parseInt(prompt.inputString("나이? ")));
    p.setAddress(prompt.inputString("주소? "));
    p.setPhone(Integer.parseInt(prompt.inputString("연락처?(010) ")));
    p.setGender(AnimalHospitalActionListener.inputGender((char) 0, prompt));

    try {
      patientDao.insert(p);
      Thread.sleep(5000);

      patientDao.insert(p);
      Thread.sleep(5000);

      patientDao.insert(p);
      Thread.sleep(5000);

      ds.getConnection().commit();
    } catch (Exception e) {
      try {
        ds.getConnection().rollback();
      } catch (Exception e2) {
      }
      throw new RuntimeException(e);
    }

    patientDao.insert(p);
  }

  private static String getMemberBreed(BreadcrumbPrompt prompt) throws IOException {
    boolean isValidNum = true; // 입력된 번호가 유효한지 여부
    String num = null;
    String breedType = null;
    while (isValidNum) {

      num = prompt.inputString("품종? 1. 강아지, 2.고양이. 3.직접입력").trim(); // trim() : 입력된 문자열의 양쪽 공백
      // 제거
      if ("1".equals(num)) {
        breedType = "강아지";
        isValidNum = false;
      } else if ("2".equals(num)) {
        breedType = "고양이";
        isValidNum = false;
      } else if ("3".equals(num)) {
        breedType = prompt.inputString("품종 타입을 직접 입력해주세요 > ");
        isValidNum = false;
      } else { // isValidNum 변수는 여전히 true이므로 루프가 반복됩니다.
        prompt.println("입력에 없는 번호입니다. 다시 입력해주세요");
      }
    }
    return breedType;
  }
}

