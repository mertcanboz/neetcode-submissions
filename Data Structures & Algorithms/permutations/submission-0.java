class Solution {
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        Set<Integer> seen = new HashSet<>();
        permutation(nums, new ArrayList<>(), seen);
        return result;
    }

    private void permutation(int[] nums, List<Integer> currentList, Set<Integer> seen) {
        if (currentList.size() == nums.length) {
            result.add(new ArrayList<>(currentList));
            return;
        }

        for (int i=0; i<nums.length; i++) {
            if (seen.contains(i)) {
                continue;
            }
            seen.add(i);
            currentList.add(nums[i]);
            permutation(nums, currentList, seen);
            seen.remove(i);
            currentList.remove(currentList.size()-1);
        }
    }
}
