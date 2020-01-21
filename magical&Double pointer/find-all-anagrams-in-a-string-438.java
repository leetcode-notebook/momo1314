/**
 * 滑动窗口解法，双指针
 */
class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        if(s == null || s.length() == 0) return new ArrayList<>();
        List<Integer> res = new ArrayList<>();
        int[] needs = new int[26];
        int[] windows = new int[26];
        int left = 0 , right = 0 , total = p.length();

        for(char a : p.toCharArray()) {
            needs[a - 'a']++;
        }

        while(right < s.length()) {
            char now = s.charAt(right);
            if(needs[now - 'a'] > 0) {
                windows[now - 'a']++;
                if(windows[now - 'a'] <= needs[now - 'a']) {
                    total -= 1;
                }
            }
            while(total == 0) {
                if(right-left+1 == p.length()){
                    res.add(left);
                }
                char c = s.charAt(left);
                if(needs[c - 'a'] > 0) {
                    windows[c - 'a']--;
                    if(windows[c - 'a'] < needs[c - 'a']) {
                        total++;
                    }
                }
                left++;
            }
            right++;
        }
        return res;
    }
}