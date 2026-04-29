class Solution {
    public int maxProduct(int[] nums) {
        int maximum = 1;
        int minimum = 1;
        int maxSoFar = nums[0];
        for (int j=0; j<nums.length; j++) {
            int num = nums[j];
            int tmpMax = maximum * num;
            maximum = Math.max(num, Math.max(num * maximum, num * minimum));
            minimum = Math.min(num, Math.min(tmpMax,        num * minimum));
            maxSoFar = Math.max(maxSoFar, maximum);
        }
        return maxSoFar;
    }
}
