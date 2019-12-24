/**
 * 二分解法 套路记忆ing----长度过长要用long
 */
class Solution {
    public int mySqrt(int x) {
        long left = 0;
        long right = x/2 + 1;
        while(left < right) {
            long mid = (left + right + 1) >>> 1;
            long sqrt = mid*mid;
            if(sqrt > x) {
                right = mid - 1;
            }else {
                left = mid;
            }
        }
        return (int)left;
    }
}

/**
 * 牛顿法学习 迭代公式：x0 = 1/2 (x0 + (a / x0) )
 */
class Solution {
    public int mySqrt(int x) {
       long a = x;
        while (a * a > x) {
            a = (a + x / a) / 2;
        }
        return (int) a;
    }
}