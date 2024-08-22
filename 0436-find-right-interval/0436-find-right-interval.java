class Solution {
    public int[] findRightInterval(int[][] intervals) {
        int[] output = new int[intervals.length];
        Arrays.fill(output, -1);
        for (int i = 0; i < intervals.length; i++) {
            int end = intervals[i][1];
            int min = 1_000_000;
            for (int j = 0; j < intervals.length; j++) {
                int start = intervals[j][0];
                if (start >= end && start <= min) {
                    output[i] = j;
                    min = start;
                }
            }
        }
        return output;
    }
}