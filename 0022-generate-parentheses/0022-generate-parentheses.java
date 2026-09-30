class Solution {
    
    private static List<String> func (int open, int close, int n, StringBuffer temp, List<String> res){

        if (open == n && close == n){
            res.add(temp.toString());
            return res;
        }

        if (open < n){
            temp.append("(");
            func(open + 1, close, n, temp, res);
            temp.deleteCharAt(temp.length() - 1);
        }

        if (open > close){
            temp.append(")");
            func(open, close + 1, n, temp, res);
            temp.deleteCharAt(temp.length() - 1);
        }

        return res;
    }
    public List<String> generateParenthesis(int n) {
        
        List<String> list = new ArrayList<>();

        return func(0,0,n,new StringBuffer(), list);
    }
}