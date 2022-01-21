package project4;

import java.util.ArrayList;
import java.util.List;

public class RadixSort {
  public static int[] radixSort(int[] array) {

    List<Integer>[] buckets = new ArrayList[10];
    for (int i = 0; i < 10; i++) {
      buckets[i] = new ArrayList<Integer>();
    }

    // get the max number
    int max = Integer.MIN_VALUE;
    for (int num: array) {
      if (num > max) {
        max = num;
      }
    }

    int digit = 0;
    while (max/(int)Math.pow(10, digit) > 0) {
      for (int num: array) {
        int idx = (num / (int)Math.pow(10, digit)) % 10;
        buckets[idx].add(num);
      }

      int i = 0;
      int i2 = 0;
      for (List<Integer> b: buckets)  {
        for(int num: b) {
          array[i++] = num;
        }
        b.clear(); // TODO: js vs java?
      }

      digit++;
    }

    return array;
  }

  public static void main(String[] args) {
    int[] arr = {121, 22, 332};
    for( int num: RadixSort.radixSort(arr)) {
      System.out.println(num);
    }
  }
}
