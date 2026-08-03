class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        
        int n = temperatures.length;
        int[] res = new int[n];
        Stack<Integer> st = new Stack<>();
        res[n-1] = 0;
        st.push(n - 1);

        for (int i = n-2; i >= 0; i--){

            while (!st.empty() && temperatures[i] >= temperatures[st.peek()]){
                st.pop();
            }

            if (!st.empty() && temperatures[i] < temperatures[st.peek()]){
                res[i] = st.peek() - i;
            }
            else {
                res[i] = 0;
            }

            st.push(i);
        }
        return res;
    }
}