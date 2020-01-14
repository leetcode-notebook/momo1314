//建立数组dp[][]来存储 以word1[i]为结尾的字符串 转换成 以word2[j]为结尾的字符串 所需的最小操作数
    //当新遍历一对来自word1，word2的字符
    //若 word1[i] == word2[j] 表示不需要操作，则dp[i][j]=dp[i-1][j-1]
    //若 word1[i] != word2[j] 则可以有三种情况
    //   1、替换 word1[i] 把 word1[i] 替换成 word2[j] 需要 dp[i-1][j-1]+1步
    //   2、删除 word1[i] 把 word1[i] 删除成 word1[i-1] 需要 dp[i][j-1]+1步
    //   3、删除 word2[j] 把 word2[j] 删除成 word2[j-1] 需要 dp[i-1][j]+1步(增加word1和删除word2一个效果)
    // 取这三个中最小值 
class Solution {
    public int minDistance(String word1, String word2) {
        int len1 = word1.length();
        int len2 = word2.length();
        int[][] dp  = new int[len1+1][len2+1];

        for(int i = 1 ; i <= len1 ; i++) {
            dp[i][0] = i;
        }
        for(int i = 1 ; i <= len2 ;i++) {
            dp[0][i] = i;
        }
        for(int i = 1 ; i <= len1 ; i++) {
            for(int j = 1; j <= len2 ; j++) {
                if(word1.charAt(i-1) == word2.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1];
                } else {
                    dp[i][j] = Math.min(dp[i-1][j-1] , Math.min(dp[i-1][j],dp[i][j-1])) + 1;
                }
            }
        }
        return dp[len1][len2];
    }
}