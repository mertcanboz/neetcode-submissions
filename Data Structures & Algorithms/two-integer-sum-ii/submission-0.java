class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int i=0, j=numbers.length-1;

        while (i<j) {
            int left = numbers[i];
            int right = numbers[j];
            if (left + right < target) {
                i++;
            } else if (left + right > target) {
                j--;
            } else {
                return new int[]{i+1, j+1};
            }
        }
        return new int[]{-1,-1};
    }
}
