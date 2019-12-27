/**
 * 天际线，遍历，O(2N^2)
 */
class Solution {
    public int maxIncreaseKeepingSkyline(int[][] grid) {
        int len = grid.length;
        int[] rMax = new int[len];
        int[] cMax = new int[len];
        for(int i = 0 ; i < len ; i++) {
            for(int j = 0 ; j < len ; j++) {
                if(grid[i][j] > rMax[i])
                    rMax[i] = grid[i][j];
                if(grid[i][j] > cMax[j])
                    cMax[j] = grid[i][j];
            }
        }
        int res = 0;
        for(int i = 0 ; i < len ; i++) {
            for(int j = 0 ; j < len ; j++) {
                res += Math.min(rMax[i],cMax[j]) - grid[i][j];
            }
        }
        return res;
    }
}