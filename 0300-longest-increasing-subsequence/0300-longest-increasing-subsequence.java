class Solution {
    public int lengthOfLIS(int[] nums) {
        int[] len = new int[nums.length];
        Arrays.fill(len, 1);

        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) { // 나보다 작고
                    len[i] = Math.max(len[i], len[j] + 1); // 수열 길이 가장 큰 값 + 1
                }
            }
        }

        int max = 0;
        for (int l : len) {
            max = Math.max(max, l);
        }

        return max;
    }
}