package p1;

import java.util.Iterator;

public class LL<T> implements Iterable<T>{

  private int size;
  private int modCount = 0;
  private Node<T> beginMarker;
  private Node<T> endMarker;

  /* static nested class Node */
  private static class Node<T> {
    private T data;
    private Node<T> prev;
    private Node<T> next;

    public Node(T data, Node<T> prev, Node<T> next) {
      this.data = data;
      this.prev = prev;
      this.next = next;
    }
  }

  @Override
  public Iterator<T> iterator() {
    return new LinkedListIterator();
  }

  /* constructor */
  public LL() {
  }

  // Collection interface
  public void clear() {
  }

  public int size() {
    return this.size;
  }

  public boolean isEmpty() {
    return this.size == 0;
  }

  public boolean add(T x) {
    return false;
  }

  // List interface
  public void add(int idx, T x) {
  }

  public T get(int idx) {
    return null;
  }

  public T set(int idx, T newVal) {
    return null;
  }

  public T remove(int idx) {
    return null;
  }

  public String toString() {
    return null;
  }

  private class LinkedListIterator implements java.util.Iterator<T> {

    @Override
    public boolean hasNext() {
      return false;
    }

    @Override
    public T next() {
      return null;
    }
    
  }
}

class TestLL {
  public static void main(String[] args) {
  }
}
