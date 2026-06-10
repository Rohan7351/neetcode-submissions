class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
        int[][] pair = new int[n][2];
        
        for(int i=0;i<n;++i){
            pair[i][0] = position[i];
            pair[i][1] = speed[i];
        }

        Arrays.sort(pair, (a,b)->(b[0] - a[0]));

        double prevTime = -1;
        int ans = 0;

        for(int i=0;i<n;++i){
            double time = (double)(target - pair[i][0]) / pair[i][1];
        
        if(time>prevTime){
            prevTime = time;
            ans++;
        }
        }

        return ans;

    }
}
