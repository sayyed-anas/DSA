class Pairs<T,U>{

    T first;
    U second;

    Pairs(T first, U second){
        this.first = first;
        this.second = second;
    }
}

class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        
        int n = words.length;
        HashMap<String,Integer> freq = new HashMap<>();

        PriorityQueue<Pairs<Integer,String>> prq = new PriorityQueue<>(
            (a,b) -> {
                if (!a.first.equals(b.first)){
                    return a.first - b.first;
                }

                return b.second.compareTo(a.second);
            }
        );

        for (int i = 0; i < n; i++){
            freq.put(words[i], freq.getOrDefault(words[i], 0) + 1);
        }

        for (Map.Entry<String,Integer> entry : freq.entrySet()){

            int f = entry.getValue();
            String word = entry.getKey();
            
            if (prq.size() < k){
                prq.add(new Pairs(f,word));
            }
            else {
                if (f > prq.peek().first || f == prq.peek().first && word.compareTo(prq.peek().second) < 0){
                    prq.poll();
                    prq.add(new Pairs(f,word));
                }
            }
        }

        List<String> res = new ArrayList<>();

        for (int i = 0; i < k; i++){
            res.add(0,prq.poll().second);
        }

        return res;
    }
}