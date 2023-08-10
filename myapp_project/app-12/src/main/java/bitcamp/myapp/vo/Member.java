package bitcamp.myapp.vo;

public class Member {
  private static int userId = 1;

  public static final char MALE = 'M';
  public static final char FEMALE = 'W';

  private int no;
  private String name;
  private String breeds;
  private int age;
  private String address;
  private int phone;
  private char gender;

  public Member() {
    this.no = userId++;
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
