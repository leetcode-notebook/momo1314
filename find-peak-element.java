/**
 * 162 寻找峰值，模板二分法解 学习{@link https://leetcode-cn.com/problems/search-insert-position/solution/te-bie-hao-yong-de-er-fen-cha-fa-fa-mo-ban-python-/}
 */
class Solution {
    public int findPeakElement(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while(left < right) {
            int mid = (left + right ) >>> 1;
            if(nums[mid] < nums[mid + 1] ) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return right;
    }
}