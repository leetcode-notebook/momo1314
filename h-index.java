//只做了排序+遍历(O(nlogn))，后面看题解有O(n)的,记录下来学习了下
/**
 * 排序+遍历
 * O(nlogn)
 * 排序耗时O(nlogn) 后面无论是二分O(logn)还是顺序O(n)都一样，空间复杂度O(1)，sort使用堆排序，不消耗额外空间
 */
public class Solution {
    public int hIndex(int[] citations) {
        // 排序（注意这里是升序排序，因此下面需要倒序扫描）
        Arrays.sort(citations);
        // 倒序扫描找出i，i要大于等于引用数
        int i = 0;
        while (i < citations.length && citations[citations.length - 1 - i] > i) {
            i++;
        }
        return i;
    }
}

/**
 * 计数法
 * O(n)
 * 额外创建了数组存，空间复杂度O(n)
 */
public class Solution {
    public int hIndex(int[] citations) {
        int n = citations.length;
        int[] papers = new int[n + 1];
        // 计数，如果引用次数超过论文数对h来说没意义，换成最大值n就行。
        for (int c: citations)
            papers[Math.min(n, c)]++;
        // 找出最大的h，s作为记录h次引用的论文数合
        int h = n;
        for (int s = papers[n]; h > s; s += papers[h])
            h--;
        return h;
    }
}

