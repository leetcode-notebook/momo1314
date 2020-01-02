/**
 * 动态规划，石头游戏2
 */
class Solution {
    private int[] pileOfI;
    private int[][] dp;
    public int stoneGameII(int[] piles) {
        if(piles == null || piles.length == 0 ) {
            return 0;
        }
        int len = piles.length;
        pileOfI = new int[len];
        //避免重复计算，把剩余的数量写入缓存
        pileOfI[len - 1] = piles[len - 1];
        for(int i = len -2 ; i >= 0 ; i--) {
            pileOfI[i] = pileOfI[i+1]+piles[i];
        }
        dp = new int[len][len];
        return handle(piles,0,1);
    }
    public int handle(int[] piles , int i , int m) {
        if(i >= piles.length) {
            return 0;
        }
        //多了一把梭拿走
        if(i + 2 * m >= piles.length) {
            return pileOfI[i];
        }
        if(dp[i][m] == 0) {
            //拿到对面最少能拿的，减下来就是自己拿到最多的
            int minStone = Integer.MAX_VALUE;
            for(int x = 1 ; x <= 2 * m ; x++) {
                minStone = Math.min(minStone , handle(piles , i + x, Math.max(x, m)));
            }
            dp[i][m] = pileOfI[i] - minStone;
        }
        return dp[i][m];
    }
}