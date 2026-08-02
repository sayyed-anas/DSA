class Solution {
    public String removeDuplicates(String s) {

        Stack<Character> stack = new Stack<>();
        
        for (int i = 0; i < s.length(); i++){

            if (stack.empty()) {
                stack.push(s.charAt(i));
                continue;
            }

            if (stack.peek() == s.charAt(i)) {
                stack.pop();
                continue;
            }

            stack.push(s.charAt(i));
        }
        // Stack<Character> st = new Stack<>();

        // while (!stack.empty()){
        //     st.push(stack.peek());
        //     stack.pop();
        // }

        StringBuilder sb = new StringBuilder();

        for (char ch : stack) {
            sb.append(ch);
        }

        String res = sb.toString();

        return res;
    }
}