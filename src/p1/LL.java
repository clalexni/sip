package p1;

import java.util.Iterator;

public class LL<T> implements Iterable<T>{

  private int size;
  private int modCount = 0; // Structural modifications are those that change the size of the list
  private Node<T> beginMarker;
  private Node<T> endMarker;

  /* static nested class Node */
  private static class Node<T> {
    public T data;
    public Node<T> prev;
    public Node<T> next;

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
    clear();
  }

  // Collection interface
  public void clear() {
    this.size = 0;

    this.beginMarker = new Node<>(null, null, null);
    this.endMarker = new Node<>(null, beginMarker, null);
    beginMarker.next = endMarker;

    modCount++;
  }

  public int size() {
    return this.size;
  }

  public boolean isEmpty() {
    return this.size == 0;
  }

  public boolean add(T x) {
    add(this.size, x);
    return true;
  }

  // List interface
  public void add(int idx, T x) {
    Node<T> p = getNode(idx);
    Node<T> newNode = new Node<>(x, p.prev, p);
    p.prev = newNode;

    this.size++;
    this.modCount++;
  }

  public T get(int idx) {
    return getNode(idx).data;
  }

  public T set(int idx, T newVal) {
    Node<T> p = getNode(idx);
    T oldVal = p.data;
    p.data = newVal;

    return oldVal;
  }

  public T remove(int idx) {
    Node<T> p = getNode(idx);
    p.prev.next = p.next;
    p.next.prev = p.prev;

    this.modCount++;
    this.size--;

    return p.data;
  }

  public String toString() {
    return null;
  }

  private Node<T> getNode(int idx) {
    Node<T> target;
    if (idx < 0 || idx >= this.size) {  
      throw new IndexOutOfBoundsException("Index: " + idx + "; size: " + this.size);
    }
    if (idx < this.size/2) {
      target = this.beginMarker.next;
      for (int i = 0; i < idx; i++) {
        target = target.next;
      }
    } else {
      target = this.endMarker.prev;
      for (int i = this.size-1; i > idx; i--) {
        target = target.prev;
      }
    }
    return target;
  }

  private class LinkedListIterator implements java.util.Iterator<T> {

    private Node<T> current = beginMarker.next; 
    private int expectedModCount = LL.this.modCount;
    private int size;

    @Override
    public boolean hasNext() {
      return false;
    }

    @Override
    public T next() {
      return null;
    }

    public void remove() {
    }
    
  }
}

class TestLL {
  public static void main(String[] args) {
  }
}
