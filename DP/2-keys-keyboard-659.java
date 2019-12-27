/**
 *动态规划
 *可以发现，因子相同的情况下，交换因子相乘的顺序，需要的步骤是一样的。所以我们可以简化一下分解的步骤，只需要找到小于sqrt(n)的因子即可。
 *假设找到的因子是 j ，那么需要的最小步骤就是 dp[j] + dp[i/j]，其中，dp[j]表示需要多少步生成这个因子，dp[i/j]表示需要多少步基于这个因子得到 i
 */
class Solution {
    public int minSteps(int n) {
        int[] dp = new int[n + 1];
        int h = (int) Math.sqrt(n);
        for (int i = 2; i <= n; i++) {
            dp[i] = i;
            for (int j = 2; j <= h; j++) {
                if (i % j == 0) {
                    dp[i] = dp[j] + dp[i / j];
                    break;
                }
            }
        }
        return dp[n];
    }
}

/**
 *非动态规划
 *如果n是质数，则只能一个个复制粘贴，结果就是n
 *寻找n的最大因子i，先得到i，然后复制1次，粘贴n/i - 1次，因此steps[n] = steps[i] + n/i
 */
class Solution {
    public int minSteps(int n) {
        if (n == 1) {
            return 0;
        }
        for (int i = n / 2; i > 1; i--) {
            if (n % i == 0) {
                return minSteps(i) + n / i;
            }
        }
        return n;
    }
}
        
