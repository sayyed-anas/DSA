class Solution {

    private static void func(int idx, int n, StringBuilder temp, String digits, List<String> res, HashMap<Character, String> hm){

        if (idx == n){
            res.add(temp.toString());
            return;
        }

        String choices = hm.get(digits.charAt(idx));

        for (int j = 0; j < choices.length(); j++){

            temp.append(choices.charAt(j));
            func(idx + 1, n, temp, digits, res,hm);
            temp.deleteCharAt(temp.length() - 1);
        }
    }
    public List<String> letterCombinations(String digits) {

        List<String> res = new ArrayList<>();

        if (digits == null || digits.isEmpty()){
            return res;
        }
        
        int n = digits.length();
        StringBuilder temp = new StringBuilder();
        int idx = 0;

        HashMap<Character, String> hm = new HashMap<>();

        hm.put('2', "abc");
        hm.put('3', "def");
        hm.put('4', "ghi");
        hm.put('5', "jkl");
        hm.put('6', "mno");
        hm.put('7', "pqrs");
        hm.put('8', "tuv");
        hm.put('9', "wxyz");

        func(idx, n, temp, digits, res, hm);

        return res;
    }
}