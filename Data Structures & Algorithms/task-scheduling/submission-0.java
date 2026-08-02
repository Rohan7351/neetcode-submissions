class Solution {
    class Pair{
        int freq;
        int timeLeft;

        Pair(int freq, int timeLeft){
            this.freq = freq;
            this.timeLeft = timeLeft;
        }
    }

    public int leastInterval(char[] tasks, int n) {
        Map<Character, Integer> mp = new HashMap<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->b-a);
        Queue<Pair> q = new LinkedList<>();

        for(char task : tasks){
            mp.put(task, mp.getOrDefault(task, 0)+1);
        }

        for(Map.Entry<Character, Integer> entry : mp.entrySet()){
              pq.offer(entry.getValue());
        }

        int time = 0;

        while(pq.size()>0 || q.size()>0){
            time++;

            if(!pq.isEmpty() ){
                int cnt = pq.poll() - 1;

                if(cnt!=0){
                    q.offer(new Pair(cnt, time + n));
                }
            }

            if(!q.isEmpty() && q.peek().timeLeft == time){
                pq.offer(q.poll().freq);

            }

            
        }

        return time;
    }
}
