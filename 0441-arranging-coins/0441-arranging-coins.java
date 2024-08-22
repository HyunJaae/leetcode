class Solution {
    public int arrangeCoins(int n) {
        int cnt = 1;
        while(n >= 0) {
            n -= cnt;
            cnt++;
        }
        return cnt - 2;
    }
}