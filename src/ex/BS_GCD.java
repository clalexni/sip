package ex;

public class BS_GCD {

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

  public static void main(String ...args) {
    // NOTE: autoboxing only works for single element
    Integer[] a = {1, 3, 6, 10, 17, 33, 45, 49, 52, 64, 76, 78, 82, 90, 91, 97};
    System.out.println(bs(a, 1));
    System.out.println(gcd(102, 15));
  }
}
