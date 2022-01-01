package ex;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Iterator;

import java.util.concurrent.ThreadLocalRandom;


public class IteratorEx {

  public static void removeEvensVer1(List<Integer> lst) {
    int i = 0;
    while (i < lst.size()) {
      if (lst.get(i) % 2 == 0) { // O(1) for ArrayList; O(n) for LinkedList
        lst.remove(i); // O(N) for both
      } else {
        i++;
      }
    }
  }

  // using iterator to iterate and remove
  public static void removeEvensVer2(List<Integer> lst) {
    Iterator<Integer> iter = lst.iterator();
    while (iter.hasNext()) {
      if (iter.next() % 2 == 0) { // O(1) for both
        iter.remove(); // O(N) for ArrayList; O(1) for LinkedList
      }
    }
  }

  // iterator violated by altering the original list
  // java.util.ConcurrentModificationException
  public static void removeEvenVer3(List<Integer> lst) {
    for (Integer num: lst) {
      if (num % 2 == 0) {
        lst.remove(num);
      }
    }
  }
}

class TestIterEx {
  public static void main(String[] args) {
    List<Integer> al= new ArrayList<>();
    List<Integer> ll = new LinkedList<>();

    for (int i = 0; i < 10; i++) {
      al.add(ThreadLocalRandom.current().nextInt(-100, 100));
      ll.add(ThreadLocalRandom.current().nextInt(-100, 100));
    }
    System.out.println(al);
    System.out.println(ll);

    IteratorEx.removeEvensVer1(al);
    IteratorEx.removeEvensVer1(ll);

    IteratorEx.removeEvensVer2((al));
    IteratorEx.removeEvensVer2((ll));
    // IterEx.removeEvenVer3((al));
    // IterEx.removeEvenVer3((ll));

    System.out.println(al);
    System.out.println(ll);
  }
}
