package bitcamp.util;

public interface List<E> {
  boolean add(E value);

  E get(int index);

  Object[] toArray();

  <T> T[] toArray(T[] arr); // <T> 를 붙여서 클래스가 아니고 타입임 컴파일러에게 알려준다.

  boolean remove(E value);

  E remove(int index);

  int size();

  Iterator<E> iterator();
}
