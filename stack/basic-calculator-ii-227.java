/**
 * 简单计算器2 简单用栈实现，未使用后缀表达式。
 */
class Solution {
    public int calculate(String s) {
        Stack<Integer> stack = new Stack<>();
        int num = 0 , res = 0;
        char op = '+';
        for(int i = 0 ; i < s.length() ; i++) {
            if(s.charAt(i) >='0'){
                num = num*10+(s.charAt(i)-'0');
            }
            if( (s.charAt(i)<'0'&& s.charAt(i)!=' ') || i==s.length()-1) {
                if(op=='+') stack.push(num);
                if(op=='-') stack.push(-num);
                if(op=='*'||op=='/'){
                    int temp = (op=='*')? stack.peek()*num:stack.peek()/num;
                    stack.pop();
                    stack.push(temp);
                }
                op=s.charAt(i);
                num=0;
            }

        }
        while(!stack.isEmpty()) {
            res += stack.peek();
            stack.pop();
        }
        return res;
    }
}