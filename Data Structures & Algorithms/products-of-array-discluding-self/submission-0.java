class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];
        int zeroIdx = -1;
        int product = 1;
        for (int i=0; i<nums.length; i++) {
            if (nums[i] == 0) {
                if (zeroIdx != -1) return result;
                zeroIdx = i;
            } else {
                product *= nums[i];
            }
        }
        for (int i=0; i<nums.length; i++) {
            if (zeroIdx == -1) {
                result[i] = product / nums[i];
            } else {
                if (nums[i] == 0) result[i] = product;
            }
        }
        return result;
    }
}  
