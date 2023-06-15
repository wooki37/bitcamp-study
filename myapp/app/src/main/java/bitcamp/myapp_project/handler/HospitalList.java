package bitcamp.myapp_project.handler;

import bitcamp.myapp_project.vo.Member;

public class HospitalList {
  private static final int DEFAULT_SIZE = 3;
  private Member[] members = new Member[DEFAULT_SIZE];
  private int length;

  public boolean add(Member m) {
    if (this.length == members.length) {
      increase();
    }
    this.members[this.length++] = m;
    return true;
  }

  private void increase() {
    Member[] arr = new Member[members.length + (members.length >> 1)];
    for (int i = 0; i < members.length; i++) {
      arr[i] = members[i];
    }
    members = arr;
    System.out.println("배열 확장: " + members.length);
  }

  public Member[] list() {
    Member[] arr = new Member[this.length];
    for (int i = 0; i < members.length; i++) {
      arr[i] = this.members[i];
    }
    return arr;
  }

  public Member get(int no) {
    for (int i = 0; i < this.length; i++) {
      Member m = this.members[i];
      if (m.getNo() == no) {
        return m;
      }
    }
    return null;
  }

  public boolean delete(int no) {
    int deletedIndex = indexOf(no);
    if (deletedIndex == -1) {
      return false;
    }

    for (int i = deletedIndex; i < this.length - 1; i++) {
      this.members[i] = this.members[i + 1];
    }
    this.members[--this.length] = null;
    return false;
  }

  private int indexOf(int memberNo) {
    for (int i = 0; i < this.length; i++) {
      Member m = this.members[i];
      if (m.getNo() == memberNo) {
        return i;
      }
    }
    return -1;
  }
}
