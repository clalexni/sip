package ex;

public class MaxSubSum {
  /* 4 ways to solve max subsequence sum from best to worst */

  // O(n)
  public static int maxSubSum1(int[] a) {
    // sum from left to right, reset if negative
    int max = 0;
    int currentSum = 0;
    for (int n: a) {
      currentSum += n;
      if (currentSum > max) {
        max = currentSum;
      }
      if (currentSum < 0) {
        currentSum = 0;
      }
    }
    return max;
  }

  // O(nlogn)
  public static int maxSubSum2(int[] a, int left, int right) {
    if (left == right) {
      return (a[left] > 0)? a[left] : 0;
    }
    
    int center = (left + right) / 2;
    int leftMax = maxSubSum2(a, left, center);
    int rightMax = maxSubSum2(a, center+1, right);

    int centerLeftMax = 0;
    int centerLeftSum = 0;
    for (int i = center; i >= left; i--) {
      centerLeftSum += a[i];
      if (centerLeftSum > centerLeftMax) {
        centerLeftMax = centerLeftSum;
      }
    }

    int centerRightMax = 0;
    int centerRightSum = 0;
    for (int i = center+1; i <= right; i++) {
      centerRightSum += a[i];
      if (centerRightSum > centerRightMax) {
        centerRightMax = centerRightSum;
      }
    }

    return max(leftMax, rightMax, centerRightMax+centerLeftMax);
  }
  
  private static int max(int ...nums) {
    int max = nums[0];
    for (int n: nums) {
      if (n > max) {
        max = n;
      }
    }
    return max;
  }

  // o(n^2)
  public static int maxSubSum3(int[] a) {
    int maxSum = 0;
    for (int i = 0; i < a.length; i++) {
      int localSum = 0;
      for (int j = i; j < a.length; j++) {
        localSum += a[j];
        if (localSum > maxSum) {
          maxSum = localSum;
        }
      }
    }
    return maxSum;
  }

  // O(n^3)
  public static int maxSubSum4(int[] a) {
    int maxSum = 0;
    for (int i = 0; i < a.length; i++) {
      for (int j = i; j < a.length; j++) {
        int localSum = 0;
        for (var k = i; k <= j; k++) {
          localSum += a[k];
          if (localSum > maxSum) {
            maxSum = localSum;
          }
        }
      }
    }
    return maxSum;
  }

  public static void main(String[] args) {
    int[] a = { -2, 11, -4, 13, -5, -2 };
    //System.out.println(maxSubSum2(a, 0, a.length-1));
    System.out.println(maxSubSum1(a));
  }
}
