/**
 * 贪心算法
 */
class Solution {
    public List<Integer> partitionLabels(String S) {
        int[] last = new int[26];
        for(int i = 0 ; i < S.length() ; i++) {
            last[S.charAt(i) - 'a'] = i;
        }
        List<Integer> res = new ArrayList<>();
        int pos = 0 , anchor = 0;
        for(int j = 0 ; j < S.length() ; j++) {
            pos = Math.max(pos,last[S.charAt(j) - 'a']);
            if (j == pos) {
                res.add(j - anchor + 1);
                anchor = j + 1;
            }
        }
        return res;
    }
}