class WordFilter {

    private final String[] words;

    public WordFilter(String[] words) {
        this.words = words;
    }
    
    public int f(String pref, String suff) {
        int idx = -1;
        for (int i = words.length - 1; i > -1; i--) {
            String word = words[i];
            if (word.charAt(0) != pref.charAt(0)) continue;
            if (word.startsWith(pref) && word.endsWith(suff)) {
                idx = i;
                break;
            }
        }
        return idx;
    }
}

/**
 * Your WordFilter object will be instantiated and called as such:
 * WordFilter obj = new WordFilter(words);
 * int param_1 = obj.f(pref,suff);
 */