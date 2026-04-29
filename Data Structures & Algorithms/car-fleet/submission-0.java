class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
        Integer[] cars = new Integer[n];
        int numberOfFleets = 0;
        double timeTakenForLastFleet = -1;

        for (int i=0; i<n; i++) {
            cars[i] = i;
        }
        Arrays.sort(cars, (a,b) -> Integer.compare(position[b], position[a]));

        for (int i=0; i<n; i++) {
            int carIndex = cars[i];
            double time = ((double) target - position[carIndex]) / speed[carIndex];
            if (timeTakenForLastFleet == -1 || time > timeTakenForLastFleet) {
                timeTakenForLastFleet = time;
                numberOfFleets++;
            } else {
                continue;
            }
        }
        return numberOfFleets;
    }
}
