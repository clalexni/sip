// ******************PUBLIC OPERATIONS*********************
// void insert( x )       --> Insert x
// Comparable deleteMin( )--> Return and remove smallest item
// Comparable findMin( )  --> Return smallest item
// boolean isEmpty( )     --> Return true if empty; else false
// void makeEmpty( )      --> Remove all items
package ex;

public class BinaryHeap <T extends Comparable<? super T>> {
  private static final int DEFAULT_CAPACITY = 10;
  private int size;
  private T[] arr;

  public BinaryHeap() {
    this(DEFAULT_CAPACITY);
  }

  public BinaryHeap(int capacity) {
    size = 0;
    arr = (T[])new Comparable[capacity + 1];
  }

  public BinaryHeap(T[] arr) {
  }

  private void buildHeap() {
  }

  public void insert(T x) {
    if (size == arr.length - 1) {
      enlargeArray(arr.length * 2 + 1);
    }

    // percolate up
    int hole = ++size;
    arr[0] = x;
    while (arr[hole/2].compareTo(x) > 0) {
      arr[hole] = arr[hole/2]; // move parent down and hole up
      hole /= 2;
    }
    arr[hole] = x;
  }

  private void enlargeArray(int newSize) {
    T[] old = arr;
    arr = (T[]) new Comparable[newSize + 1];
    for (int i = 0; i < old.length; i++) {
      arr[i] = old[i];
    }
  }

  public T findMin() {
    if (arr.length == 0) {
      throw new java.util.NoSuchElementException();
    }
    return arr[1];
  }

  public T deleteMin() {
    return null;
  }

  public boolean isEmpty() {
    return false;
  }

  public void makeEmpty() {
  }

  public static void main(String[] args) {
    BinaryHeap<Integer> bh = new BinaryHeap<>();
    bh.insert(30);
    bh.insert(10);
    System.out.println(bh.findMin());
    bh.insert(-1);
    System.out.println(bh.findMin());
  }
}
