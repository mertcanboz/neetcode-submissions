class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> pool = new HashSet<>();
        int maxLength = 0;
        for (int num: nums) {
            pool.add(num);
        }
        for (int num: nums) {
            int left = 0, right = 0;
            if (!pool.contains(num)) continue;
            pool.remove(num);
            while (pool.contains(num-left-1)) {
                pool.remove(num-left-1);
                left++;
            }
            while (pool.contains(num+right+1)) {
                pool.remove(num+right+1);
                right++;
            }
            maxLength = Math.max(maxLength, 1+left+right);
        }
        return maxLength;
    }
}
