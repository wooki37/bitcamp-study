package bitcamp.util;

public class Queue1 extends LinkedList {
  public static void main(String[] args) {
    Queue1 q = new Queue1();
    q.offer("김씨");
    q.offer("이씨");
    q.offer("박씨");
    q.offer("유씨");
    q.offer("정씨");

    System.out.println(q.poll());
    System.out.println(q.poll());
    System.out.println(q.poll());
    System.out.println(q.poll());
    System.out.println(q.poll());
    System.out.println(q.poll());
    System.out.println(q.poll());
  }

  public void offer(Object value) {
    this.add(value);
  }

  public Object poll() {
    if (this.size() == 0) {
      return null;
    }
    return this.remove(0);
  }

}
