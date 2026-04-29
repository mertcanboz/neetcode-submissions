class Solution {
    public int coinChange(int[] coins, int amount) {
        if (amount == 0) return 0;
        Queue<Integer> nodes = new LinkedList<>();
        Set<Integer> seen = new HashSet<>();
        int coinsNeeded = 0;
        nodes.offer(0);
        while (!nodes.isEmpty()) {
            int size = nodes.size();
            for (int i=0; i<size; i++) {
                int currentAmount = nodes.poll();
                for (int coin: coins) {
                    int nextAmount = currentAmount + coin;
                    if (nextAmount == amount) {
                        return coinsNeeded + 1;
                    }
                    if (nextAmount > amount || seen.contains(nextAmount)) {
                        continue;
                    }
                    nodes.offer(nextAmount);
                    seen.add(nextAmount);
                }
            }
            coinsNeeded++;
        }
        return -1;
    }
}
