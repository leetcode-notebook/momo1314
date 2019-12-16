/**
 * 使用map键值对映射
 * 但是速度和内存占用都比较大
 */
class Solution1 {
    public boolean wordPattern(String pattern, String str) {
        String[] strA = str.split(" ");
        if (strA.length != pattern.length()) return false;
        Map<Object, Integer> temp = new HashMap<>();
        for (int i = 0; i < strA.length; i++) {
            if (!Objects.equals(temp.put(strA[i], i), temp.put(pattern.charAt(i), i)))               return false;
        }
        return true;
    }
}

/**
 * 不使用map映射
 * LeetCode题解
 */
class Solution2 {
    public boolean wordPattern(String pattern, String str) {
        String[] strA = str.split(" ");
        if (strA.length != pattern.length()) return false;
        for(int i = 0 ; i < strA.length ; i ++) {
            if (pattern.indexOf(pattern.charAt(i)) != indexOf(strA,strA[i])) {
                return false;
            }
        }
        return true;
    }
    public static int indexOf(String[] strA , String findString) {
        int ans = -1;
        for(int i = 0; i < strA.length; i++) {
            if (strA[i].equals(findString)) {
                ans = i;
                break;
            };
        };
        return ans;
    }
}