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

    ArrayList<Integer> list1 = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();
        int n = nums.length;
        int i = 0;
        int j = 0;
        int[] res = new int[n];
        // System.out.println(n);

        for (int k = 0; k < n; k++) {
            if (nums[i] < 0) {
                list1.add(i, nums[k]);
                i++;
            } else {
                list2.add(j, nums[k]);
                j++;
            }
        }

        if (list1.size() == 0) {
            for (int k = 0; k < list2.size(); k++) {
                res[k] = list2.get(k) * list2.get(k);
            }
            return res;
        }

        if (list2.size() == 0) {
            for (int k = 0; k < list1.size(); k++) {
                res[k] = list1.get(k) * list1.get(k);
            }

            i = 0;
            j = list1.size() - 1;

            while (i < j) {
                int temp = res[j];
                res[j] = res[i];
                res[i] = temp;
                j--;
                i++;
            }

            return res;
        }

        for (int l1 = 0; l1 < list1.size(); l1++) {
            list1.set(l1, list1.get(l1) * list1.get(l1));
        }

        i = 0;
        j = list1.size() - 1;

        while (i < j) {
            int temp = list1.get(j);
            list1.set(j, list1.get(i));
            list1.set(i, temp);

            i++;
            j--;
        }

        for (int s = 0; s < list2.size(); s++) {
            list2.set(s, list2.get(s) * list2.get(s));
        }

        i = 0;
        j = 0;
        int id = 0;

        while (i < list1.size() && j < list2.size()) {
            if (list1.get(i) < list2.get(j)) {
                res[id++] = list1.get(i++);
            } else {
                res[id++] = list2.get(j++);
            }
        }

        while (i < list1.size()) {
            res[id++] = list1.get(i++);
        }

        while (j < list2.size()) {
            res[id++] = list2.get(j++);
        }

        return res;
    }
}