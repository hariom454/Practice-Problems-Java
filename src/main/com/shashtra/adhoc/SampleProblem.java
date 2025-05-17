package com.shashtra.adhoc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SampleProblme {

  /*

  List of positive integer
  sort based on frequency of item
  [3, 1, 4, 2, 2, 6, 6, 3, 2, 5, 5]
  [1, 4, 3, 3, 5, 5, 6, 6, 2, 2, 2]
   */


  /*


   */


  private static List<Integer> Solution(int[] a)
  {
    List<Pair> arr = new ArrayList<>();

    Map<Integer, Integer> freq = new HashMap<>();
    for(int elem: a){
      int localFreq = freq.getOrDefault(elem, 0);
      freq.put(elem, localFreq+1);
    }

    //iterate hashmap and store this into an array
    for(Map.Entry<Integer, Integer> entry: freq.entrySet()){
      //value = freq
      //key = element's actual value
      arr.add(new Pair(entry.getValue(), entry.getKey()));
    }

    arr.sort((a1, b) -> {
      if(a1.count == b.count){
        return Integer.compare(a1.val, b.val);
      }
      return a1.count - b.count;
    });

    List<Integer> ans = new ArrayList<>();
    for(Pair elem: arr){
      int elementFreq = elem.count;
      for(int i = 0; i < elementFreq; i ++){
        ans.add(elem.val);
        System.out.print(elem.val + " ");
      }
    }

    return ans;
  }

  public static void main(String[] args) {
    int[] arr = {3, 1, 4, 2, 2, 6, 6, 3, 2, 5, 5};
    List<Integer> ans = Solution(arr);
  }


}

class Pair{
  int count;
  int val;

  public Pair(int freq, int val){
    this.count = freq;
    this.val = val;
  }
}
