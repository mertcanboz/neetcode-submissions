class Solution {
    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        backtrack(candidates, target, 0, new ArrayList<>());
        return result;
    }

    private void backtrack(int[] candidates, int target,
                           int start, List<Integer> curr) {

        if (target == 0) {
            result.add(new ArrayList<>(curr));
            return;
        }

        for (int i = start; i < candidates.length; i++) {

            // ❌ skip duplicates at the same recursion level
            if (i > start && candidates[i] == candidates[i - 1])
                continue;

            // ❌ pruning
            if (candidates[i] > target)
                break;

            curr.add(candidates[i]);

            // i + 1 → cannot reuse same element
            backtrack(candidates, target - candidates[i], i + 1, curr);

            curr.remove(curr.size() - 1);
        }
    }
}
