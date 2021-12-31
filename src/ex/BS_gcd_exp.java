package ex;

import javax.swing.plaf.synth.SynthIcon;

public class BS_gcd_exp {

  public static <T extends Comparable<? super T>> int bs(T[] orderedList, T target) {
    int left = 0, right = orderedList.length-1;
    while (left <= right) {
      int center = (left + right) / 2;
      if (orderedList[center].compareTo(target) > 0) {
        right = center - 1;
      } else if (orderedList[center].compareTo(target) < 0){
        left = center + 1;
      } else {
        return center;
      }
    }
    return -1;
  }

  public static int gcd(int a, int b) {
    int mod = a%b;
    while (mod != 0) {
      a = b;
      b = mod;
      mod = a % b;
    }
    return b;
  }

  public static long exp(int a, int b) {
    if (b == 0) {
      return 1;
    }
    if ( b == 1) {
      return a;
    }

    if (b % 2 == 0) {
      return exp(a*a, b/2);
    } else {
      return exp(a*a, b/2) * a;
    }
  }

  public static void main(String ...args) {
    // NOTE: autoboxing only works for single element
    Integer[] a = {1, 3, 6, 10, 17, 33, 45, 49, 52, 64, 76, 78, 82, 90, 91, 97};
    System.out.println(bs(a, 1));
    System.out.println(gcd(102, 15));
    System.out.println(exp(2, 10));
  }
}
