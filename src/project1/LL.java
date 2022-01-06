package p1;

import java.util.ArrayList;
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
    //add(this.size, x);
    Node<T> newNode = new Node<>(x,this.endMarker.prev, this.endMarker);
    this.endMarker.prev.next = newNode;
    this.endMarker.prev = newNode;
    this.size++;
    this.modCount++;
    return true;
  }

  // List interface
  public void add(int idx, T x) {
    Node<T> p = getNode(idx);
    Node<T> newNode = new Node<>(x, p.prev, p);
    newNode.prev.next = newNode;
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
    return remove(p);
  }

  private T remove(Node<T> p) {
    p.prev.next = p.next;
    p.next.prev = p.prev;

    this.size--;
    this.modCount++;
    return p.data;
  }

  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("[ ");
    for (T n: this) {
      sb.append(n + " ");
    }
    sb.append("]");
    return new String(sb);
  }

  private Node<T> getNode(int idx) {
    Node<T> target;
    if (idx < 0 || idx > this.size-1) {  
      throw new IndexOutOfBoundsException("Index: " + idx + "; size: " + this.size);
    }
    if (idx < this.size/2) {
      target = this.beginMarker.next;
      for (int i = 0; i < idx; i++) {
        target = target.next;
      }
    } else {
      //target = this.endMarker.prev; // IMPORTANT
      target = this.endMarker;
      for (int i = this.size; i > idx; i--) {
        target = target.prev;
      }
    }
    return target;
  }

  private class LinkedListIterator implements java.util.Iterator<T> {

    private Node<T> current = beginMarker.next; 
    private int expectedModCount = LL.this.modCount;
    private boolean okToRemove = false;

    @Override
    public boolean hasNext() {
      return current != LL.this.endMarker;
    }

    @Override
    public T next() {
      if (!hasNext()) {
        throw new java.util.NoSuchElementException();
      }
      if (LL.this.modCount != this.expectedModCount) {
        throw new java.util.ConcurrentModificationException();
      }
      T oldVal = current.data; 
      current = current.next;
      okToRemove = true;
      return oldVal;
    }

    public void remove() {
      if (LL.this.modCount != this.expectedModCount) {
        throw new java.util.ConcurrentModificationException();
      }
      if (!okToRemove) {
        throw new IllegalStateException();
      }
      // remove current.prev
      LL.this.remove(current.prev);
      this.expectedModCount++;
      okToRemove = false;
    }
  }

  /**
   * p1 implementation starts here 
   */

  public int itemCount(T val) {
    int count = 0;
    for (T n: this) {
      if (n == val) {
        count++;
      }
    }
    return count;
  }

  public void swap(int idx1, int idx2) {
    Node<T> n1 = getNode(idx1);
    Node<T> n2 = getNode(idx2);

    Node<T> n1_prev = n1.prev;
    Node<T> n1_next = n1.next;

    n1.next = n2.next;
    n1.prev = n2.prev;

    n1.next.prev = n1;
    n1.prev.next = n1;

    n2.next = n1_next;
    n2.prev = n1_prev;

    n1_next.prev = n2;
    n1_prev.next = n2;
  }

  public ArrayList<T> sublist(int idx1, int idx2) {
    ArrayList<T> al = new ArrayList<>();

    // make sure that these two indices exist, otherwise will throw error in getNode
    // TODO: faster way?
    Node<T> n1 = getNode(idx1);
    Node<T> n2 = getNode(idx2);

    if (idx1 <= idx2) {
      for (int i = 0; i < (idx2-idx1+1); i++) {
        al.add(n1.data);
        n1 = n1.next;
      }
    } else {
      for (int i = 0; i < (idx1-idx2+1); i++) {
        al.add(n2.data);
        n2 = n2.next;
      }
    }
    return al;
  }

  public ArrayList<T> select(int ...idx) {
    ArrayList<T> list = new ArrayList<>();
    for (int i: idx) {
      list.add(getNode(i).data);
    }
    return list;
  }

  public LL<T> reverse() {
    LL<T> mll = new LL<>();
    Node<T> node = this.endMarker.prev;
    while (node != this.beginMarker) {
      mll.add(node.data);
      node = node.prev;
    }
    return mll;
  }

  public void erase(int idx, int count) {
    // check if both exist
    int idx2 = idx+count-1;
    if (idx  < 0 || idx >= this.size || idx2 < 0 || idx2 >= this.size()) {
      throw new IndexOutOfBoundsException("Index: " + idx + "; Count: " + count + "; Size: " + this.size);
    }
    for(int i = 0; i < count; i++) {
      this.remove(idx);
    }
  }

  public void insertList(LL<T> list, int idx) {
    if (idx < 0 || idx >= this.size) {
      throw new IndexOutOfBoundsException("Index: " + idx + "; Size: " + this.size);
    }

    for (T x: list) {
      this.add(idx, x);
      idx++;
    }
  }

  public void shift(int offset) {
    // move the first offset items to the end
    offset %= this.size;
    if (offset < 0) {
      offset = this.size + offset;
    }
    Node<T> first = this.beginMarker.next;
    Node<T> last = getNode(offset-1);
    this.beginMarker.next = last.next;
    last.next.prev = this.beginMarker;
    
    first.prev = this.endMarker.prev;
    this.endMarker.prev.next = first;
    this.endMarker.prev = first;

    last.next = this.endMarker;
  }
}

class TestLL {
  public static void main(String[] args) {
    LL<Integer> ll = new LL<>();

    for (int i = 0; i < 10; i++) {
      ll.add(i);
    }
    System.out.println(ll);

    Iterator<Integer> iter = ll.iterator();
    while (iter.hasNext()) {
      System.out.print(iter.next());
    }
    System.out.println("");
    
    // itemCount
    System.out.println("itemCount: " + ll.itemCount(0));

    // swap
    ll.swap(0, 9);
    System.out.println("swapped: " + ll);

    // sublist
    System.out.println("sublist: " + ll.sublist(3, 0));

    // select
    System.out.println("select: " + ll.select(0, 1, 3, 5, 9));

    // reverse
    System.out.println(ll.reverse());

    // erase
    System.out.println("before erase: " + ll);
    ll.erase(0, 3);
    System.out.println("after erase: " + ll);

    // insertList
    LL<Integer> ll2 = new LL<>();
    for (int i = 0; i < 5; i++) {
      ll2.add(i);
    }
    ll.insertList(ll2, 1);
    System.out.println(ll);

    // shift
    ll.shift(-11);
    System.out.println(ll);
  }
}
