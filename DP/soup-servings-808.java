/**
 * 易于理解的方法(动态规划)
 */
class Solution {
    Double[][] dp;
    public double soupServings(int N) {
        if(N >= 5551) return 1;
        int n = (int)Math.ceil(N / 25.0);
        dp = new Double[n+1][n+1];
        return solve(n,n);
    }
    public double solve(int a , int b){
        if(a <= 0) {
            if(b <= 0) {
                return 0.5;
            }
            return 1;
        }
        if (b <= 0) {
            return 0;
        }
        if (dp[a][b] != null) {
            return dp[a][b];
        }
        double res = 0.25*(solve(a-4,b)+solve(a-3,b-1)+solve(a-2,b-2)+solve(a-1,b-3));
        dp[a][b] = res;
        return res;
    }
    /**
    *阈值计算
    *for (int i = 50;; i++){
    *    if (1 - t.soupServings(i) <= Math.pow(10, -6)){
    *        System.out.println(i);
    *       break;
    *    }
    *}
    */
}


/**
 * 官方题解
 */
class Solution {
    public double soupServings(int N) {
        N = N/25 + (N%25 > 0 ? 1 : 0);
        if (N >= 500) return 1.0;

        double[][] memo = new double[N+1][N+1];
        for (int s = 0; s <= 2*N; ++s) {
            for (int i = 0; i <= N; ++i) {
                int j = s-i;
                if (j < 0 || j > N) continue;
                double ans = 0.0;
                if (i == 0) ans = 1.0;
                if (i == 0 && j == 0) ans = 0.5;
                if (i > 0 && j > 0) {
                    ans = 0.25 * (memo[M(i-4)][j] + memo[M(i-3)][M(j-1)] +
                                  memo[M(i-2)][M(j-2)] + memo[M(i-1)][M(j-3)]);
                }
                memo[i][j] = ans;

            }
        }
        return memo[N][N];
    }
            
    public int M(int x) {
        return Math.max(0,x);
    }

}