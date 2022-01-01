package ex;

import java.util.Iterator;

public class MyArrayList <T> implements Iterable<T>{

  private static final int DEFAULT_CAPACITY = 10;
  private T[] items;
  private int size;

  public MyArrayList() {
    clear();
  }

  @Override
  public Iterator<T> iterator() {
    return new ArrayListIterator();
  }

  public void ensureCapacity(int newCapacity) {
    if (newCapacity < this.size) {
      return;
    }
    T[] old = this.items;
    this.items = (T[])new Object[newCapacity];
    for (int i = 0; i < this.size; i++) {
      this.items[i] = old[i];
    }
  }

  // Collection Interface
  public int size() {
    return this.size;
  } 

  public boolean isEmpty() {
    return size() == 0;
  }

  public void clear() {
    this.size = 0;
    ensureCapacity(DEFAULT_CAPACITY);
  }

  public boolean add(T x) {
    add(this.size, x);
    return true;
  }

  // List Interface
  public T get(int idx) {
    if (idx < 0 || idx >= this.size) {
      throw new IndexOutOfBoundsException("Index: " + idx + "; size: " + this.size);
    }
    return this.items[idx];
  }

  public T set(int idx, T newVal) {
    if (idx < 0 || idx >= this.size) {
      throw new IndexOutOfBoundsException("Index: " + idx + "; size: " + this.size);
    }
    T old = this.items[idx];
    this.items[idx] = newVal;
    return old;
  }

  public void add(int idx, T x) {
    if (this.items.length == this.size) {
      ensureCapacity(this.size * 2 + 1);
    }

    for( int i = this.size; i > idx; i--) {
      this.items[i] = this.items[i-1];
    }

    this.items[idx] = x;
    this.size++; 
  }

  public T remove(int idx) {
    T old = this.items[idx];
    for (int i = idx; i < this.size-1; i++) {
      this.items[i] = this.items[i+1];
    }
    this.size--;
    return old;
  }

  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("[");
    for (T e: this) { // IMPORTANT: enhanced for loop uses iterator
      sb.append(e + ", ");
    }
    sb.append("]");
    return new String(sb);
  }

  private class ArrayListIterator implements java.util.Iterator<T> {
    private int current = 0;
    private boolean okToRemove = false;

    @Override
    public boolean hasNext() {
      return current < MyArrayList.this.size; // IMPORTANT
    }

    @Override
    public T next() {
      if (!hasNext()) {
        throw new java.util.NoSuchElementException();
      }

      this.okToRemove = true;
      return MyArrayList.this.items[current++];
    }
    
    public void remove() {
      if (!okToRemove) {
        throw new IllegalStateException();
      }
      MyArrayList.this.remove(--current);
      okToRemove = false;
    }
  }
}

class TestArrayList {
  public static void main(String[] args) {
    MyArrayList<Integer> lst = new MyArrayList<>();

    for (int i = 0; i < 10; i++) {
      lst.add(i);
    }
    System.out.println(lst);

    Iterator<Integer> iter = lst.iterator();
    while (iter.hasNext()) {
      System.out.println(iter.next());
      iter.remove();
    }
    System.out.println(lst);

  }
}

