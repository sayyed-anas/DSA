class Solution {
    public int[] nextGreaterElements(int[] nums) {
        
        int n = nums.length;
        int[] res = new int[n];
        Stack<Integer> st = new Stack<>();

        for (int i = n * 2 - 1; i >= 0; i--){

            int index = i % n;

            while (!st.empty() && nums[index] >= st.peek()){
                st.pop();
            }

            if (i < n){
                if (!st.empty() && nums[i] < st.peek()){
                    res[index] = st.peek();
                }
                else {
                    res[index] = -1;
                }
            }

            st.push(nums[index]);
        }
        return res;
    }
}