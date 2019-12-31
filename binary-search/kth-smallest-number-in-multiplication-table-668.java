/**
 * 用值做二分
 */
class Solution {
    public int findKthNumber(int m, int n, int k) {
        int left = 1 , right = m*n , mid;
        while( left < right ) {
            mid = left + (right - left ) / 2;
            if(enough(mid,m,n,k)) {
                right = mid;
            }else {
                left = mid + 1;
            }
        }
        return left;
    }
    public boolean enough(int x, int m, int n, int k) {
        int count = 0;
        for (int i = 1; i <= m; i++) {
            count += Math.min(x / i, n);
        }
        return count >= k;
    }
}