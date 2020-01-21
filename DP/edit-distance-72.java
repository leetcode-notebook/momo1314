//��������dp[][]���洢 ��word1[i]Ϊ��β���ַ��� ת���� ��word2[j]Ϊ��β���ַ��� �������С������
    //���±���һ������word1��word2���ַ�
    //�� word1[i] == word2[j] ��ʾ����Ҫ��������dp[i][j]=dp[i-1][j-1]
    //�� word1[i] != word2[j] ��������������
    //   1���滻 word1[i] �� word1[i] �滻�� word2[j] ��Ҫ dp[i-1][j-1]+1��
    //   2��ɾ�� word1[i] �� word1[i] ɾ���� word1[i-1] ��Ҫ dp[i][j-1]+1��
    //   3��ɾ�� word2[j] �� word2[j] ɾ���� word2[j-1] ��Ҫ dp[i-1][j]+1��(����word1��ɾ��word2һ��Ч��)
    // ȡ����������Сֵ 
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