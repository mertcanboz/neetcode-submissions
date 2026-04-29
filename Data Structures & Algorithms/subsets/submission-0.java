class Solution {
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        backtrack(new ArrayList<>(), 0, nums);
        return result;
    }

    private void backtrack(List<Integer> current, int i, int[] nums) {
        if (i == nums.length) {
            result.add(new ArrayList<>(current));
            return;
        }

        backtrack(current, i+1, nums);
        current.add(nums[i]);
        backtrack(current, i+1, nums);
        current.remove(current.size()-1);
    }
}
