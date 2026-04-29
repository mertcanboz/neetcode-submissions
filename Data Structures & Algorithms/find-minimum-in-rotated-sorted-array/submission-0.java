class Solution {
    public int findMin(int[] nums) {
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int m = l + (r - l) /2;
            int mid = nums[m];
            int left = nums[l];
            int right = nums[r];
            if (left > right) {
                if (mid >= left) {
                    l = m + 1;
                } else {
                    r = m;
                }
            } else {
                return left;
            }
        }
        return nums[l];
    }
}
