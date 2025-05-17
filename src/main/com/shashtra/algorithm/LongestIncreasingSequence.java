package com.shashtra.algorithm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LongestIncreasingSequence {

  public int lengthOfLIS(int[] nums) {
    List<Integer> arr = new ArrayList<>();
    int ans = 0;
    int n = nums.length;

    for (int i = 0; i < n; i++) {
      int size = arr.size();
      int index = Collections.binarySearch(arr, nums[i]);
      if (index < 0) {
        index = -index - 1;
      }
      if (index >= arr.size()) {
        arr.add(nums[i]);
        ans++;
      } else {
        arr.set(index, nums[i]);
      }

    }
    return ans;


  }

}
