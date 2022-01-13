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
    arr = new LinkedList[nextPrime(size)];
    for (int i = 0; i < arr.length; i++) {
      arr[i] = new LinkedList<>();
    }
  }

  public boolean insert(T x) {
    // find hash or bucket id
    // see if linklist contains x
    List<T> list = arr[myHash(x)];
    if (!list.contains(x)) { // use equals in background
      list.add(x);
      return true;
    }
    return false;
  }

  private int myHash(T x) {
    int hashVal = x.hashCode() % arr.length;
    if (hashVal < 0) {
      hashVal += arr.length;
    }
    return hashVal;
  }


  private int nextPrime(int num) {
    if (num % 2== 0) {
      num++;
    }

    while (!isPrime(num)) {
      num += 2;
    }
    return num;
  }

  private boolean isPrime(int num) {
    for (int i = 2; i <= Math.sqrt(num); i++) {
      if (num % i == 0) {
        return false;
      }
    }
    return true;
  }
  public static void main(String[] args) {
    SeperateChainingHashTable<Integer> ht = new SeperateChainingHashTable<>();
    System.out.println(ht.insert(1));
    System.out.println(ht.insert(1));
  }
}

