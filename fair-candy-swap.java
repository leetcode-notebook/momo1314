/**
 * 888. fair-candy-swap  集合解法，问题理解有点问题，实际上意思是只能换一颗糖的情况，这时候可以通过contains的方法检查是否存在
 */
class Solution {
    public int[] fairCandySwap(int[] A, int[] B) {
        int countA = 0, countB = 0 , count = 0 , del = 0;
        Set<Integer> setB = new HashSet<>();
        for(int i : A) { countA += i ;}
        for(int i : B) { 
            countB += i ;
            setB.add(i);
        }
		del = (countA - countB) / 2;
        for(int i : A) {
            if(setB.contains(i - del)) {
                return new int[]{i , i - del};
            }
        }
        return new int[]{0,0};
    }
}