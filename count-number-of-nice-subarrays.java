/**
 * 题解-滑动窗口写法，额外用一个数组保存奇数的位置，实现双指针遍历，每层数量计算方法：(odds[i] - odds[i - 1])*(odds[i+k] - odds[i+k-1])
 */
class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        int res = 0,pos = 0, len = nums.length;
        int[] odds = new int[len + 2];
        for(int i = 0 ; i < len ; i++) {
            if(isOdd(nums[i])) {
                odds[++pos] = i;
            }
        }
        odds[0] = -1;
        odds[pos + 1] = len;
        for(int i = 1 ; i + k < pos + 2 ; i++) {
            res += (odds[i] - odds[i - 1])*(odds[i+k] - odds[i+k-1]);
        }
        return res;
    }
    public static boolean isOdd(int num) {
        return (num & 1) == 1;
    }
}