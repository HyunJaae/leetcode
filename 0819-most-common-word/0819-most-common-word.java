class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {
        // 비교 메서드를 제공하는 Set으로 변경
        Set<String> ban = new HashSet<>(Arrays.asList(banned));
        // 각 단어별 개수
        Map<String, Integer> counts = new HashMap<>();
        // \\W+ 는 하나 이상의 연속된 비-단어 문자를 뜻하는 정규식으로 쉼표와 공백 문자가 같이 있는 경우, 하나의 공백 문자로 대체
        String[] words = paragraph.replaceAll("\\W+", " ").toLowerCase().split(" ");

        for (String word : words) {
            if (!ban.contains(word)) {
                counts.put(word, counts.getOrDefault(word, 0) + 1);
            }
        }

        return Collections.max(counts.entrySet(), Map.Entry.comparingByValue()).getKey();
    }
}