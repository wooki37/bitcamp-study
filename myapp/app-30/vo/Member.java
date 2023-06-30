package bitcamp.myapp_project.vo;

public class Member {
  // 모든인스턴스 공유하는 값은 스태틱 필드에 보관한다.
  public static int userId = 1;

  // 상수는 스태틱 필드로 정의한다.
  // 정보를 다룰 때는 그 정보를 갖고 있는 클래스에 그 기능을 둔다.
  // 필드도 마찬가지이다.
  // GRASP 패턴 : Information Expert

  public static final char MALE = 'M';
  public static final char FEMALE = 'W';

  // 인스턴스 필드는 각각 개별적으로 유지해야 하는 값을 저장할 때 사용한다.
  // new 명령을 통해 변수를 Heap 영역에 생성한다.
  private int no;
  private String name;
  private String breeds;
  private int age;
  private String address;
  private int phone;
  private char gender;
  private String email;
  private String password;

  public Member() {
    this.no = userId++;
  }

  // 같은 기능을 수행하는 생성자가 위에 있다.
  // 다만, 파라미터가 다를 뿐이다.
  // => "생성자 오버로딩"
  public Member(int no) {
    this.no = no;
  }

  // Object의 equals()는 Member 인스턴스를 비교하는데 적합하지 않다.
  // 왜? Object의 equals()는 단순히 인스턴스 주소가 같은지 비교하기 때문이다.
  // 우리가 원하는 것은 인스턴스 주소가 다르더라도 두 인스터스는 같은 것으로 처리하는 것
  // 그래서 수퍼 클래스의 equals() 를 재정의 한다.
  // => 이것을 "오버라이딩(OverRiding)" 이라 부른다.
  public boolean equals(Object obj) {
    if (obj == null) {
      return false;
    }
    if (this.getClass() != obj.getClass()) {
      return false;
    }
    // 위 조건에서 this가 가리키는 인스턴스의 클래스와
    // 파라미터 obj가 가리키는 인스턴스의 클래스가 같다고 결론이 났기 때문에
    // 다음과 같이 obj를 Member 타입으로 형변환한다.
    Member m = (Member) obj;

    if (this.getNo() != m.getNo()) {
      return false;
    }
    // if (this.getName() != null && !this.getName().equals(m.getName())) {
    // return false;
    // }
    // if (this.getEmail() != null && !this.getEmail().equals(m.getEmail())) {
    // return false;
    // }
    // if (this.getPassword() != null &&
    // !this.getPassword().equals(m.getPassword())) {
    // return false;
    // }
    // if (this.getGender() != m.getGender()) {
    // return false;
    // }
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

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }
}
