package ex;

import java.util.Iterator;

public class MyArrayList <T> implements Iterable<T>{

  private static final int DEFAULT_CAPACITY = 10;
  private T[] items[];
  private int size;

  public MyArrayList() {
  }

  @Override
  public Iterator<T> iterator() {
    return null;
  }

  public void ensureCapacity(int newCapacity) {
  }

  public int size() {
    return this.size;
  } 

  public boolean isEmpty() {
    return size() == 0;
  }

  public void clear() {
  }

  public T get(int idx) {
    return null;
  }

  public T set(int idx, T newVal) {
    return null;
  }

  public boolean add(T x) {
    return false;
  }

  public void add(int idx, T x) {
  }

  public T remove(int idx) {
    return null;
  }

  public String toString() {
    return null;
  }
}

class ArrayListIterator<T> implements java.util.Iterator<T> {

  private static final int DEFAULT_CAPACITY = 10;
  private T items[];
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

