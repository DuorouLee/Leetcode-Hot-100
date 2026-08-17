/*
 * LeetCode 49. Group Anagrams
 *
 * 核心思路：
 * 字母异位词包含相同的字符，因此排序后得到的字符串一定相同。
 *
 * 例如：
 * eat -> aet
 * tea -> aet
 * ate -> aet
 *
 * 使用 Map 分组：
 * key   = 排序后的字符串
 * value = 属于该组的所有原字符串
 *
 * Map 示例：
 * "aet" -> ["eat", "tea", "ate"]
 * "ant" -> ["tan", "nat"]
 * "abt" -> ["bat"]
 *
 * 时间复杂度：
 * 设字符串数量为 n，每个字符串最大长度为 k
 * 排序每个字符串需要 O(k log k)
 * 总时间复杂度：O(n * k log k)
 *
 * 空间复杂度：O(n * k)
 */
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);

            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
            }

            map.get(key).add(str);
        }

        return new ArrayList<>(map.values());
    }
}
