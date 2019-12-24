/**
 * 自己遍历的52ms....
 * 看提示要排序，想到把字典按长度排序，同长度按顺序，后面暴力遍历
 */
class Solution {
    public String findLongestWord(String s, List<String> d) {
        Collections.sort(d, new Comparator < String > () {
            public int compare(String s1, String s2) {
                return s2.length() != s1.length() ? s2.length() - s1.length() : s1.compareTo(s2);
            }
        });
        for(String str : d) {
            int j = 0;
            for(int i = 0 ; i < s.length() && j < str.length(); i ++) {
                if(str.charAt(j) == s.charAt(i)) {
                    j++;
                }
            }
            if(j == str.length()) {
                return str;
            }
        }
        return "";
    }
}

/**
 * 链接：{@link https://leetcode-cn.com/problems/longest-word-in-dictionary-through-deleting/solution/524-tong-guo-shan-chu-zi-mu-pi-pei-dao-zi-dian-l-2/}
 * 19ms ...
 */
class Solution {
    public String findLongestWord(String s, List<String> d) {
        int i;
        String answer;

        answer = "";
        for(String str : d){
            if(str.length() > answer.length() || str.length() == answer.length() && str.compareTo(answer) < 0){
                if(canMatches(s, str)){
                    answer = str;
                }
            }
        }
        return answer;
    }

    private boolean canMatches(String t, String s){
        int i, j, lt, ls;

        lt = t.length();
        ls = s.length();
        i = 0;
        j = 0;
        while(i < lt){
            while(i < lt && s.charAt(j) != t.charAt(i)){
                i++;
            }
            if(i < lt && s.charAt(j) == t.charAt(i)) {
                i++;
                j++;
            }
            if(j == ls){
                return true;
            }
        }
        return false;
    }
}