class Solution {
    public boolean isValid(String s) {

        Stack<Character> stack = new Stack<>();
        char ch;
        
        for (int i = 0; i < s.length(); i++){

            ch = s.charAt(i);

            if (ch == '(' || ch == '[' || ch == '{'){
                stack.push(ch);
                continue;
            }

            // Closing
            if (stack.empty()){
                if (ch == ')' || ch == ']' || ch == '}'){
                    return false;
                }
            }

            if (!stack.empty()){
                if (ch == ')' && stack.peek() == '('){
                    stack.pop();
                }
                else if (ch == ']' && stack.peek() == '['){
                    stack.pop();
                }
                else if (ch == '}' && stack.peek() == '{'){
                    stack.pop();
                }
                else {
                    return false;
                } 
            }
        }

        if (!stack.empty()){
            return false;
        }

        return true;
    }
}