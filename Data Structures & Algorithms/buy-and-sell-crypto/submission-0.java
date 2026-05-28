class Solution {
    public int maxProfit(int[] prices) {
        int preMin = prices[0];
        int mxProfit = 0;

        for(int i=1;i<prices.length;++i){
           mxProfit = Integer.max(mxProfit, prices[i]-preMin);
           if(prices[i]<preMin) preMin = prices[i];
       }

         return mxProfit;
    }
}
