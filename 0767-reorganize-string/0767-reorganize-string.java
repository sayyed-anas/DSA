class Pair<T,U> {

    T first;
    U second;

    Pair(T first, U second){
        this.first = first;
        this.second = second;
    }
}

class Solution {
    public String reorganizeString(String s) {
        
        PriorityQueue<Pair<Integer, Character>> pq = new PriorityQueue<>(
            (a,b) -> {
                if (!b.first.equals(a.first)){
                    return b.first - a.first; 
                }
                return b.second.compareTo(a.second);
            }
        );

        HashMap<Character, Integer> freq = new HashMap<>();

        for (int i = 0; i < s.length(); i++){
            freq.put(s.charAt(i), freq.getOrDefault(s.charAt(i), 0) + 1);
        }

        for (Map.Entry<Character,Integer> entry : freq.entrySet()){

            char elem = entry.getKey();
            int f = entry.getValue();

            Pair<Integer,Character> currPair = new Pair<>(f,elem);
            pq.add(currPair);
        }

        int seat = 0;
        String res = "";

        while (!pq.isEmpty()){

            Pair<Integer,Character> p = pq.peek();
            pq.poll();

            if (seat == 0 || res.charAt(seat - 1) != p.second){

                res = res + p.second;
                p.first--;

                if (p.first != 0){
                    pq.add(p);
                }
                seat++;
            }
            else {
                if (pq.isEmpty()){
                    return "";
                }
                else if (!pq.isEmpty()){
                    Pair<Integer,Character> p1 = pq.peek();
                    pq.poll();

                    res = res + p1.second;
                    p1.first--;

                    if (p1.first != 0){
                        pq.add(p1);
                    }

                    seat++;
                }
                pq.add(p);
            }
        }
        return res;
    }
}