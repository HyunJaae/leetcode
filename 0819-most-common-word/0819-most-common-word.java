class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {
        // \\W+ 는 하나 이상의 연속된 비-단어 문자를 뜻하는 정규식으로 쉼표와 공백 문자가 같이 있는 경우, 하나의 공백 문자로 대체한다.
        String[] words = paragraph.replaceAll("\\W+", " ").toLowerCase().split(" ");
        Map<String, Integer> map = new HashMap<>();

        for (String word : words) {
            boolean isNotBanned = true;
            for (String banWord : banned) {
                if (word.equals(banWord)) {
                    isNotBanned = false;
                    break;
                }
            }
            if (isNotBanned) {
                if (map.containsKey(word)) {
                    map.put(word, map.get(word) + 1);
                } else {
                    map.put(word, 1);
                }
            }
        }

        int max = 0;
        String mostCommonWord = "";
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() > max) {
                max = entry.getValue();
                mostCommonWord = entry.getKey();
            }
        }

        return mostCommonWord;
    }
}