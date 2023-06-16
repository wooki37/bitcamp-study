package bitcamp.myapp_project.handler;

public class ArrayList_My {
  private static final int DEFAULT_SIZE = 3;

  private Object[] list = new Object[DEFAULT_SIZE];
  private int length;

  public boolean add(Object obj) {
    if (this.length == list.length) {
      increase();
    }
    this.list[this.length++] = obj;
    return true;
  }

  private void increase() {
    Object[] arr = new Object[list.length + (list.length >> 1)];
    for (int i = 0; i < list.length; i++) {
      arr[i] = list[i];
    }
    list = arr;
  }

  public Object[] list() {
    // 리턴할 값을 담을 배열을 생성
    Object[] arr = new Object[this.length];
    // 원본 배열에서 입력된 인스턴스 주소를 꺼내 새 배열에 담는다.
    for (int i = 0; i < this.length; i++) {
      arr[i] = this.list[i];
    }
    // 새 배열을 리턴한다.
    return arr;
  }

  public Object get(Object obj) {
    for (int i = 0; i < this.length; i++) {
      Object item = this.list[i];
      if (item.equals(obj)) {
        return item;
      }
    }
    return null;
  }

  public boolean delete(Object obj) {
    int deletedIndex = indexOf(obj);
    if (deletedIndex == -1) {
      return false;
    }

    for (int i = deletedIndex; i < this.length - 1; i++) {
      this.list[i] = this.list[i + 1];
    }
    this.list[--this.length] = null;
    return true;
  }

  private int indexOf(Object obj) {
    for (int i = 0; i < this.length; i++) {
      Object item = this.list[i];
      if (item.equals(obj)) {
        return i;
      }
    }
    return -1;
  }
}
