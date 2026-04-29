class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int sum = 0;
        int max = 0;
        for (int pile: piles) {
            sum += pile;
            max = Math.max(max, pile);
        }
        
        int l = (int) Math.ceil( ((double) sum) / h), r = max;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (canFinish(piles, mid, h)) r = mid;
            else l = mid + 1;
        }
        return l;
    }

    private boolean canFinish(int[] piles, int rate, int limit) {
        double time = 0;
        for (int pile: piles) {
            time += Math.ceil((double) pile / rate);
        }
        return time <= limit;
    }
}
