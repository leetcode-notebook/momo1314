/**
 * 先拿到第一个断层，然后从断层开始往回减-1直到后面都不大于前面，再对当前的i位后的所有值填充9
 */
class Solution {
    public int monotoneIncreasingDigits(int N) {
        char[] res = String.valueOf(N).toCharArray();
        int i = 1;
        while (i < res.length && res[i-1] <= res[i]) i++;
        while (0 < i && i < res.length && res[i-1] > res[i]) res[--i]--;
        for (int j = i+1; j < res.length; ++j) res[j] = '9';

        return Integer.parseInt(String.valueOf(res));
    }
}