/**
 * 回溯思想，不太会，看了解答
 *
 */
class Solution {
    public String getPermutation(int n, int k) {
        int[] factorial = {1, 1, 2, 6, 24, 120, 720, 5040, 40320, 362880};
        return dfs(n, k, new boolean[n], 0, new Stack<Integer>(),factorial);
    }
    private String dfs(int n, int k, boolean[] used, int depth, Stack<Integer> context, int[] factorial) {
        if (depth == n) {
            String res = "";
            for (Integer i : context) {
                res += "" + i;
            }
            return res;
        }
        int ps = factorial[n-1-depth];
        for (int i = 0; i < n; i++) {
            if (used[i]) continue;
            if (ps < k) {
                k -= ps;
                continue;
            }
            context.push(i+1);
            used[i] = true;
            return dfs(n, k,used, depth+1, context,factorial);
        }
        return "";
    }
}

//解法2
class Solution {
    public String getPermutation(int n, int k) {
        boolean[] visited = new boolean[n];        
        // 将 n! 种排列分为：n 组，每组有 (n - 1)! 种排列
        return recursive(n, factorial(n - 1), k, visited);
    }

    /**
    * @param n 剩余的数字个数，递减
    * @param f 每组的排列个数
    */
    private String recursive(int n, int f, int k, boolean[]visited){
        int offset = k%f;// 组内偏移量
        int groupIndex = k/f + (offset > 0 ? 1 : 0);// 第几组
        // 在没有被访问的数字里找第 groupIndex 个数字
        int i = 0;
        for(; i < visited.length && groupIndex > 0; i++){
            if(!visited[i]){
                groupIndex--;
            }
        }
        visited[i-1] = true;// 标记为已访问
        if(n - 1 > 0){
            // offset = 0 时，则取第 i 组的第 f 个排列，否则取第 i 组的第 offset 个排列
            return String.valueOf(i) + recursive(n-1, f/(n - 1), offset == 0 ? f : offset, visited);
        }else{
            // 最后一数字
            return String.valueOf(i);
        }
    }

    /**
    * 求 n!
    */
    private int factorial(int n){
        int res = 1;
        for(int i = n; i > 1; i--){
            res *= i;
        }
        return res;
    }

}