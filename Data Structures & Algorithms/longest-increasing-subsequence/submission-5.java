class Solution {
    public int lengthOfLIS(int[] nums) {
        TreeSet<Integer> set = new TreeSet<>();
        int max = 0;
        for (int i=0; i<nums.length; i++) {
            int highest = set.isEmpty() ? Integer.MIN_VALUE : set.last();
            if (highest >= nums[i]) {
                int ceiling = set.ceiling(nums[i]);
                set.remove(ceiling);
            }
            set.add(nums[i]);
            max = Math.max(max, set.size());
        }
        return max;
    }
}
