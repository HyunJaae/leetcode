class Solution {

    private int start;
    private int size;

    public String longestPalindrome(String s) {
        int len = s.length();
        if (len < 2) return s;

        for (int i = 0; i < len; i++) {
            checkedPalindrome(i, i + 1, len, s);
            checkedPalindrome(i, i + 2, len, s);
        }

        return s.substring(start, start + size);
    }

    private void checkedPalindrome(int st, int en, int len, String s) {
        
        while (st >= 0 && en < len && s.charAt(st) == s.charAt(en)) {
            st--;
            en++;
        }
        int pSize = en - st - 1;
        if (size < pSize) {
            size = pSize;
            start = st + 1;
        }
    }
}