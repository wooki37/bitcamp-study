package bitcamp.util;

public class Stack1 extends LinkedList {
  public static void main(String[] args) {
    Stack1 s = new Stack1();
    s.push("김씨");
    s.push("이씨");
    s.push("박씨");
    s.push("유씨");
    s.push("정씨");

    System.out.println(s.pop());
    System.out.println(s.pop());
    System.out.println(s.pop());
    System.out.println(s.pop());
    System.out.println(s.pop());
    System.out.println(s.pop());
  }

  public void push(Object value) {
    this.add(value);
  }

  public Object pop() {
    if (this.empty()) {
      return null;
    }
    return this.remove(this.size() - 1);
  }

  public Object peek() {
    if (this.empty()) {
      return null;
    }
    return this.get(this.size() - 1);
  }

  public boolean empty() {
    return this.size() == 0;
  }
}
