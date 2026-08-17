## 01 Two Sum

1. Map<Integer, Integer> 中，key 是数组中的数，value 是对应的索引。
2. map.containsKey(key) 用来判断某个数是否已经出现过。
3. map.get(key) 可以根据数字获取它对应的索引。
4. map.put(nums[i], i) 用来记录“数字 → 索引”的对应关系。
5. 本题应先查找 target - nums[i]，再把当前 nums[i] 放入 Map，避免当前元素和自己匹配。
6. Java 返回数组不能写 return [i, j]，应写 return new int[]{i, j}。
7. 双重循环时要注意内层循环变量是 j，递增也应写 j++。
8. HashMap 解法平均时间复杂度为 O(n)，空间复杂度为 O(n)。


## 49 Group Anagrams

1. char[] 排序使用 Arrays.sort(chars)，不能写 chars.sort()。
2. char[] 转 String 使用 new String(chars)，不能使用 chars.toString()。
3. List 是接口，不能 new List<>()，应使用 new ArrayList<>()。
4. Map<String, List<String>> 中：
   key 是排序后的字符串，
   value 是对应的一组原字符串。
5. map.get(key).add(str) 会直接修改 Map 中存储的 List，不需要再次 put。
6. map.values() 返回的是 Collection，因此返回 List<List<String>> 时可写：
   new ArrayList<>(map.values())

