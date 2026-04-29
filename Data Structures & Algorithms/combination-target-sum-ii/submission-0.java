class Solution {
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        
        Arrays.sort(candidates);
        backtrack(candidates, target, new ArrayList<>(), 0, 0);
        return result;
    }

    private void backtrack(int[] candidates, int target, List<Integer> currentList, int currentSum, int i) {
        
        if (currentSum == target) {
            result.add(new ArrayList<>(currentList));
            return;
        }

        if (i >= candidates.length || currentSum > target) {
            return;
        }
        currentList.add(candidates[i]);
        backtrack(candidates, target, currentList, currentSum+candidates[i], i+1);
        currentList.remove(currentList.size()-1);
        
        while (i + 1 < candidates.length && candidates[i] == candidates[i + 1]) {
            i++;
        }
        backtrack(candidates, target, currentList, currentSum, i + 1);
    }
}
