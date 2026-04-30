class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        combination(nums, result, new ArrayList<>(), 0, 0, target);
        return result;
    }

    private void combination(int[] nums, List<List<Integer>> result, List<Integer> currentList, int currentSum, int i, int target) {
        if (currentSum == target) {
            result.add(new ArrayList<>(currentList));
            return;
        }

        for (int idx=i; idx<nums.length; idx++) {
            if (currentSum + nums[idx] > target) {
                continue;
            }
            currentList.add(nums[idx]);
            combination(nums, result, currentList, currentSum + nums[idx], idx, target);
            currentList.remove(currentList.size()-1);
        }
    }
}
