class Solution {
    public int search(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        while (l <= r) {
            int m = l + (r - l) / 2;
            int mid = nums[m];
            if (mid == target) {
                return m;
            }
            int left = nums[l];
            int right = nums[r];
            if (left <= mid) {
                if (left <= target && target < mid) {
                    r = m - 1;
                } else {
                    l = m + 1;
                }
            } else {
                if (mid < target && target <= right) {
                    l = m + 1;
                } else {
                    r = m - 1;
                }
            }
        }
        return -1;
    }
}
