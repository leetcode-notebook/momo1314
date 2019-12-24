/**
 *  斜率 k1 = (y2 - y1) / (x2 - x1)  k2 = (y3 - y1) / (x3 - x1) 如果相等就共线  换一下就是
 *  (y2 - y1)*(x3 - x1) = (y3 - y1)*(x2 - x1) 
 */
class Solution {    
    public boolean isBoomerang(int[][] points) {
        return  (points[1][1] - points[0][1]) * (points[2][0] - points[0][0]) != (points[2][1] - points[0][1]) * (points[1][0] - points[0][0]) ;
    }
}