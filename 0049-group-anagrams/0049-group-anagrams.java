class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<Integer, String> map = new HashMap<>();
        List<List<String>> lists = new ArrayList<>();
        for (int i = 0; i < strs.length; i++) {
            char[] chars = strs[i].toCharArray();
            Arrays.sort(chars);
            map.put(i, String.valueOf(chars));
        }
        List<Integer> indexList = map.entrySet().stream()
                                                .sorted(Map.Entry.comparingByValue())
                                                .map(Map.Entry::getKey)
                                                .collect(Collectors.toList());
        String prev = map.get(indexList.get(0));
        List<String> list = new ArrayList<>();
        for (int i : indexList) {
            if (map.get(i).equals(prev)) {
                list.add(strs[i]);
            } else {
                lists.add(list);
                list = new ArrayList<>();
                list.add(strs[i]);
                prev = map.get(i);
            }
        }
        lists.add(list);
        return lists;
    }
}