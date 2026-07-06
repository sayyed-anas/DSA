import java.util.ArrayList;
import java.util.List;

class Solution {
    public int[] sortedSquares(int[] nums) {

        // int n = nums.length;
        // int right = n - 1;
        // int left = 0;
        // int pos = n - 1;
        // int[] res = new int[n];

        // while (left <= right){
        // int l = nums[left] * nums[left];
        // int r = nums[right] * nums[right];

        // if (l > r){
        // res[pos--] = l;
        // left++;
        // }
        // else{
        // res[pos--] = r;
        // right--;
        // }
        // }
        // return res;

        ArrayList<Integer> neg = new ArrayList<>();
    ArrayList<Integer> pos = new ArrayList<>();
    int n = nums.length;
    int[] res = new int[n];

    for (int i = 0; i < n; i++) {
      if (nums[i] < 0) {
        neg.add(nums[i]);
      } else {
        pos.add(nums[i]);
      }
    }

    if (neg.size() == 0) {
      for (int i = 0; i < pos.size(); i++) {
        res[i] = pos.get(i) * pos.get(i);
      }
      return res;
    }

    if (pos.size() == 0) {
      for (int i = 0; i < neg.size(); i++) {
        res[i] = neg.get(i) * neg.get(i);
      }

      int i = 0;
      int j = res.length - 1;

      while (i < j) {
        int temp = res[i];
        res[i] = res[j];
        res[j] = temp;

        i++;
        j--;
      }

      return res;
    }

    for (int i = 0; i < pos.size(); i++) {
      pos.set(i, pos.get(i) * pos.get(i));
    }

    for (int i = 0; i < neg.size(); i++) {
      neg.set(i, neg.get(i) * neg.get(i));
    }

    int i = 0;
    int j = neg.size() - 1;

    while (i < j) {
      int temp = neg.get(i);
      neg.set(i, neg.get(j));
      neg.set(j, temp);

      i++;
      j--;
    }

    for (int val : neg) {
      System.out.print(val + " ");
    }
    System.out.println();
    for (int val : pos) {
      System.out.print(val + " ");
    }
    System.out.println();

    int left = 0;
    int right = 0;
    int id = 0;

    while (left < pos.size() && right < neg.size()) {
      if (pos.get(left) < neg.get(right)) {
        res[id] = pos.get(left);
        id++;
        left++;
      } else {
        res[id] = neg.get(right);
        id++;
        right++;
      }
    }

    while (left < pos.size()) {
      res[id++] = pos.get(left++);
    }
    while (right < neg.size()) {
      res[id++] = neg.get(right++);
    }

    return res;
    }
}