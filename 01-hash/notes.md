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

## 128 Longest Consecutive Sequence
1. Set 是接口，不能写 new Set<>()，应使用 new HashSet<>()。
2. set.contains(num) 可以快速判断某个数字是否存在。
3. 只有当 num - 1 不存在时，才从 num 开始向后查找，避免重复计算连续序列。
4. 连续序列长度从 1 开始，因为起点 num 本身已经算一个元素。
5. 使用 while (set.contains(currentNum + 1)) 不断向后查找连续数字。
6. 建立 HashSet 后，后续应遍历 Set 而不是原数组 nums，可以去除重复数字，避免同一连续序列被重复扫描。
7. HashSet 的查找平均时间复杂度为 O(1)，因此整体平均时间复杂度可以达到 O(n)。
