class Solution {
    class Pair{
        int dis;
        int[] point;

        Pair(int dis, int[] point){
           this.dis = dis;
           this.point = point;
        }
    }
    public int[][] kClosest(int[][] points, int k) {
        int n = points.length;
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)->b.dis - a.dis);
         for(int[] point : points){
            int distance = point[0]*point[0] + point[1]*point[1];
            pq.offer(new Pair(distance, point));

            if(pq.size()>k){
                pq.poll();
            }
         }

          int[][] ans = new int[k][2];
         for(int i=0;i<k;++i){
           Pair p = pq.poll();
           ans[i] = p.point;
         }

         return ans;
    }
}
