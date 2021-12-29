package ex;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/*
interface Listable {
  <T> void copy(List<? super T> dst, List<? extends T> src);
  void printList(List<? extends Number> nums);
}
*/

public class GenericEx {

  private static <T> void copy(List<? super T> dst, List<? extends T> src) {
    // dst limits to superclass of T or T itself
    // src limits to subclass of T or T itself
    int i = 0;
    for (T n : src) {
      dst.set(i, n);
      i++;
    }
  }

  private static void printList(List<? extends Number> nums) {
    for (Number n : nums) {
      System.out.println(n);
    }
  }

  public static <T extends Comparable<? super T>> T max(Collection <T> col) {
    // Type Bound
    T max = col.iterator().next(); // first item
    for (T item: col) {
      if (max.compareTo(item) < 0) {
        max = item;
      }
    }
    return max;
  }

  public static void main(String ...args) {
    // example1();
    example2();
  }

  public static void example1() {
    List<Integer> ints = Arrays.asList(1, 2);
    List<Number> nums = new ArrayList<>();
    nums.add(1);
    nums.add(3.14);

    // nums = ints; // collections does not have covariant
    // copy(ints, nums); // compile error
    copy(nums, ints);

    printList(nums);
    printList(ints);
  }

  public static void example2() {
    List<Apple> apples = Arrays.asList(new Apple(1), new Apple(2));
    List<Orange> oranges = Arrays.asList(new Orange(1), new Orange(2));
    List<Fruit> fruits = Arrays.asList(new Apple(1), new Orange(2));
    System.out.println(max(apples));
    System.out.println(max(oranges));
    System.out.println(max(fruits));
  }
}

class Fruit implements Comparable<Fruit> {
  private String name;
  private int size;

  public Fruit(String name ,int size) {
    this.name = name;
    this.size = size;
  }

  @Override
  public int compareTo(Fruit o) {
    return (this.size < o.size)? -1 : (this.size == o.size)? 0 : 1;
  }

  public String toString() {
    return this.name + "(" + size + ")";
  }
}

class Apple extends Fruit {
  public Apple(int size) {
    super("Apple", size);
  }
}

class Orange extends Fruit {
  public Orange(int size) {
    super("Orange", size);
  }
}