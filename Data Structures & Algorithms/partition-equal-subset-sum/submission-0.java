class Solution {
    public boolean canPartition(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        if (sum % 2 == 1) return false;
        int target = sum / 2;
        Set<Integer> seen = new HashSet<>();
        seen.add(0);
        for (int num: nums) {
            Set<Integer> newSeen = new HashSet<>();
            for (int s: seen) {
                newSeen.add(s+num);
                newSeen.add(s);
            }
            if (newSeen.contains(target)) return true;
            seen = newSeen;
        }
        return false;
    }
}
