class Solution {
    fun groupAnagrams(strs: Array<String>): List<List<String>> {
        val results: MutableMap<String, MutableList<String>> = mutableMapOf()
        for (str in strs) {
            val key = str.toCharArray().sorted().joinToString("")
            results.getOrPut(key) { mutableListOf() }.add(str)
        }
        return ArrayList<List<String>>(results.values)
    }
}