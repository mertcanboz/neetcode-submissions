class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        TreeMap<Integer, Integer> window = new TreeMap<>();
        int[] result = new int[nums.length-k+1];
        for (int i=0; i<k; i++) {
            window.put(nums[i], window.getOrDefault(nums[i], 0) + 1);
        }
        result[0] = window.lastKey();
        for (int i=k; i<nums.length; i++) {
            window.put(nums[i], window.getOrDefault(nums[i], 0) + 1);
            window.put(nums[i-k], window.getOrDefault(nums[i-k], 0) - 1);
            if (window.get(nums[i-k]) == 0) window.remove(nums[i-k]);
            result[i-k+1] = window.lastKey();
        }
        return result;
    }
}
