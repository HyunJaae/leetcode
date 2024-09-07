class WordFilter {

    static class TrieNode {
        TrieNode[] children; // 객체 배열
        ArrayList<Integer> indices; // 인덱스 배열

        public TrieNode(){
            this.children = new TrieNode[26]; // 26 사이즈 배열로 생성
            this.indices = new ArrayList<>(); // ArrayList 로 생성
        }
    }

    TrieNode rootP;
    TrieNode rootS;
    HashSet<String> set;

    public WordFilter(String[] words) {
        this.rootP = new TrieNode();
        this.rootS = new TrieNode();
        this.set = new HashSet<>();
        for(int i = words.length - 1; i > - 1; i--) {
            if(set.contains(words[i])) {
                continue;
            }
            insert(words[i], i);
            set.add(words[i]);
        }
    }

    public int f(String pref, String suff) {
        ArrayList<Integer> preIndices = retrieveIndices(pref, rootP, 0, pref.length(), 1);
        ArrayList<Integer> sufIndices = retrieveIndices(suff, rootS, suff.length() - 1, -1, -1);

        int pPointer = 0;
        int sPointer = 0;

        while(pPointer < preIndices.size() && sPointer < sufIndices.size()) {
            int pIndex = preIndices.get(pPointer);
            int sIndex = sufIndices.get(sPointer);
            if(pIndex == sIndex){
                return sIndex;
            } else if(pIndex > sIndex) {
                pPointer++;
            } else{
                sPointer++;
            }
        }

        return -1;
    }

    private ArrayList<Integer> retrieveIndices(String word, TrieNode node, int start, int end, int step) {
        TrieNode curr = node;
        int n = word.length();
        for(int i = start; i != end; i+=step) {
            char c = word.charAt(i);
            curr = curr.children[c - 'a'];
            if(curr == null) {
                return new ArrayList<>();
            }
        }
        return curr.indices;
    }

    private void insert(String word, int index) {
        TrieNode currP = rootP;
        TrieNode currS = rootS;
        int n = word.length(); // 문자열의 길이

        for(int i = 0; i < n; i++) {
            char c = word.charAt(i); // 문자 값 (앞에서부터)
            if(currP.children[c - 'a'] == null) { // c - 'a' 번째에 TrieNode 가 없는 경우
                currP.children[c - 'a'] = new TrieNode(); // TrieNode 객체 할당
            }
            currP = currP.children[c - 'a'];
            currP.indices.add(index); // 현재 읽고 있는 문자열의 인덱스 할당
        }

        for(int i = n - 1; i > -1; i--){
            char c = word.charAt(i); // 문자 값 (뒤에서부터)
            if(currS.children[c - 'a'] == null){
                currS.children[c - 'a'] = new TrieNode();
            }
            currS = currS.children[c - 'a'];
            currS.indices.add(index);
        }
    }
}

/**
 * Your WordFilter object will be instantiated and called as such:
 * WordFilter obj = new WordFilter(words);
 * int param_1 = obj.f(pref,suff);
 */