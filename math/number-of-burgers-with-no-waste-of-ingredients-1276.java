/**
 * 数学题，注意考虑额外条件。
 */
class Solution {
    public List<Integer> numOfBurgers(int tomatoSlices, int cheeseSlices) {
        List<Integer> res = new ArrayList<>();
        if(tomatoSlices % 2 != 0 || tomatoSlices < cheeseSlices * 2 || cheeseSlices * 4 < tomatoSlices) return res;
        res.add(tomatoSlices/2 - cheeseSlices);
        res.add(cheeseSlices - res.get(0));
        return res;
    }
}