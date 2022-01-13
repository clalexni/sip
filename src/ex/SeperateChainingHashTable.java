// ******************PUBLIC OPERATIONS*********************
// void insert( x )       --> Insert x
// void remove( x )       --> Remove x
// boolean contains( x )  --> Return true if x is present
// void makeEmpty( )      --> Remove all items
package ex;

import java.util.LinkedList;
import java.util.List;

public class SeperateChainingHashTable<T> {
  private final static int DEFAULT_TABLE_SIZE = 101;
  private List<T>[] arr;
  private int size;

  public SeperateChainingHashTable() {
    this(DEFAULT_TABLE_SIZE);
  }
  public SeperateChainingHashTable(int size) {
    arr = new LinkedList[size];
    for (int i = 0; i < arr.length; i++) {
      arr[i] = new LinkedList<>();
    }
  }

  public boolean insert(T x) {
    return false;
  }

  // private int findPos(T x) {

  // }

  // private int nextPimre() {
  // }

}

