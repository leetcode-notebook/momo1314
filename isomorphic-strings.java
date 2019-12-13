class Solution {
    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) {
        	return false;
        }
        char[] tempS = s.toCharArray();
        char[] tempT = t.toCharArray();
        int len = s.length();
        for(int i = 0 ; i < len ; i++ ) {
        	if (s.indexOf(tempS[i]) != t.indexOf(tempT[i])) {
        		return false;
        	}
        }
        return true;
    }
}