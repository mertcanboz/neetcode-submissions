class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int[] result = new int[2];
        int l=0, r=numbers.length-1;
        while (l<r) {
            int left = numbers[l];
            int right = numbers[r];
            if (left + right == target) {
                result[0] = l+1;
                result[1] = r+1;
                break;
            } else if (left + right < target) {
                l++;
            } else {
                r--;
            }
        }
        return result;
    }
}
