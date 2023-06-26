package bitcamp.util;

public class ListIterator<E> implements Iterator<E> {
  List<E> list;

  // 어느 인덱스의 항목을 꺼낼 것인지 그 인덱스를 보관한다.
  int cursor;

  public ListIterator(List<E> list) {
    this.list = list;
  }

  @Override
  public boolean hasNext() {
    return cursor < list.size();
  }

  @Override
  public E next() {
    return list.get(cursor++);
  }

}
