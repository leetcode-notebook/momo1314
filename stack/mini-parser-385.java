/**
 * 简单入栈出栈操作
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *     // Constructor initializes an empty nested list.
 *     public NestedInteger();
 *
 *     // Constructor initializes a single integer.
 *     public NestedInteger(int value);
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // Set this NestedInteger to hold a single integer.
 *     public void setInteger(int value);
 *
 *     // Set this NestedInteger to hold a nested list and adds a nested integer to it.
 *     public void add(NestedInteger ni);
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
class Solution {
    public NestedInteger deserialize(String s) {
        if(s.charAt(0) != '[') return new NestedInteger(Integer.valueOf(s));
        Stack<NestedInteger> stack = new Stack<>();
        NestedInteger result = new NestedInteger();
        for(int i = 0 ; i < s.length() ; i ++){
            char c = s.charAt(i);
            if(c == '[') {
                NestedInteger node = new NestedInteger();
                if(!stack.isEmpty()) {
                    stack.peek().add(node);
                }
                stack.push(node);
            }
            if(c >= '0' && c <= '9' || c == '-') {
                String num = c+"";
                while(i+1 < s.length() && s.charAt(i+1) >= '0' && s.charAt(i+1)<='9') {
                    num = num+s.charAt(++i);
                }
                NestedInteger node = new NestedInteger(Integer.valueOf(num));
                if(stack.isEmpty()) {
                    stack.push(node);
                } else {
                    stack.peek().add(node);
                }
            }
            if(c == ']') {
                result = stack.pop();
            }
        }
        return result;
    }
}