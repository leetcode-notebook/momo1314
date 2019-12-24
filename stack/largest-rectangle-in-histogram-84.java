/**
 * 借鉴题解里栈的调用法，第i个的面积算法是( right_i - left_i - 1 ) * h[i] right_i和left_i是右边和左边第一个小于h[i]的
 */
class Solution{
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int res = 0;
        int[] new_heights = new int[heights.length + 2];
        for (int i = 1; i < heights.length + 1 ; i++ ) {
            new_heights[i] = heights[i-1];
        }
        for (int i = 0 ; i < new_heights.length ; i++) {
            while(!stack.isEmpty() && new_heights[stack.peek()] > new_heights[i]) {
                int cur = stack.pop();
                res = Math.max(res , (i - stack.peek() - 1 ) * new_heights[cur]);
            }
            stack.push(i);
        }
        return res;
    }
}