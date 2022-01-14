// ******************PUBLIC OPERATIONS*********************
// bool insert( x )       --> Insert x
// bool remove( x )       --> Remove x
// bool contains( x )     --> Return true if x is present
// void makeEmpty( )      --> Remove all items
// int size()
// int capacity()
package ex;

public class QuadraticProbingHashTable <T>{

  public HashEntry<T> [] arr;
  private int occupied; // lazy deleted will count toward occupied
  private int size; // actual size count

  private static final int DEFAULT_TABLE_SIZE = 101;

  /* inner class */
  private static class HashEntry<T> {
    public T data;
    public boolean isActive;

    public HashEntry(T x) {
      this(x, true);
    }

    public HashEntry(T x, boolean i) {
      this.data = x;
      this.isActive = i;
    }
  }

  /* class methods start here*/ 

  public QuadraticProbingHashTable() {
    this(DEFAULT_TABLE_SIZE);
  }

  public QuadraticProbingHashTable(int size) {
    allocateArray(size);
    makeEmpty();
  }

  public int capacity() {
    return arr.length;
  }

  public int size() {
    return size;
  }

  private void allocateArray(int size) {
    // arr= new HashEntry<T>[100];
    arr = new HashEntry[ nextPrime(size) ];
  }

  private static int nextPrime (int num) {
    if (num % 2 == 0) {
      num++;
    }
    while(!isPrime(num)) {
      num += 2;
    }
    return num;
  }

  private static boolean isPrime(int num) {
    for (int i = 2; i <= Math.sqrt(num); i++) {
      if (num % i == 0) {
        return false;
      }
    }
    return true;
  }

  public void makeEmpty() {
    occupied = 0;
    for (int i = 0; i < arr.length; i++) {
      arr[i] = null;
    }
  }

  public boolean insert(T x) {
    int currentPos = findPos(x);

    // if the position returned stored x already
    if (arr[currentPos] != null && arr[currentPos].isActive) {
      return false;
    }

    // if x is stored but not active => occupied had increased before
    // if current position is null => increase occupied
    if (arr[currentPos] == null) {
      ++occupied;
    }

    arr[currentPos] = new HashEntry<>(x, true);
    size++;

    if (occupied > arr.length/2) {
      rehash();
    }
    return true;
  }

  private int findPos(T x) {
    /* TODO: 
    prove that in quadratic probing, 
    if table size is prime => a new element can always 
    be inserted if the table is at least half empty
    */
    int offset = 1;
    int currentPos = myHash(x);

    while (arr[currentPos] != null && !arr[currentPos].data.equals(x)) {
      currentPos += offset;
      offset += 2;
      if (currentPos >= arr.length) {
        currentPos -= arr.length;
      }
    }
    // currentPos is a null or currentPos is x
    return currentPos;
  }

  private int myHash(T x) {
    int hashVal = x.hashCode() % arr.length;
    return (hashVal > 0)? hashVal: hashVal + arr.length;
  }

  private void rehash() {
    HashEntry<T>[] oldArr = arr;
    allocateArray(size * 2);
    occupied = 0;
    size = 0;
    for (HashEntry<T> v: oldArr) {
      if (v != null && v.isActive) {
        insert(v.data);
      }
    }
  }

  public boolean remove(T x) {
    int pos = findPos(x);
    if (arr[pos] != null && arr[pos].isActive) {
      arr[pos].isActive = false;
      size--;
      return true;
    }
    return false;
  }

  public boolean contains(T x) {
    int pos = findPos(x);
    if (arr[pos] != null && arr[pos].isActive) {
      return true;
    }
    return false;
  }

  public static void main(String[] args) {
    QuadraticProbingHashTable<Integer> ht = new QuadraticProbingHashTable<>();
    System.out.println(ht.insert(1));
    System.out.println(ht.insert(1));
    System.out.println("contains: " + ht.contains(1));
    System.out.println("cap: " + ht.capacity() + "; size: " + ht.size());
    System.out.println(ht.remove(1));
    System.out.println(ht.remove(1));
    System.out.println("contains: " + ht.contains(1));
    System.out.println("cap: " + ht.capacity() + "; size: " + ht.size());
  }
}
