/*
 * Map 使用：
 *
 * put(key, value)
 *   → 存入 key-value
 *
 * containsKey(key)
 *   → 判断某个 key 是否存在
 *
 * get(key)
 *   → 根据 key 获取对应的 value
 *
 * 本题：
 * key   = nums[i]，也就是数组中的数字
 * value = i，也就是数字对应的索引
 *
 * 思路：
 * 当前数字 nums[i]
 * 需要寻找的另一个数字 = target - nums[i]
 *
 * 如果 map 中已经存在这个数字：
 * map.containsKey(component)
 *
 * 就通过：
 * map.get(component)
 *
 * 拿到它之前出现时的索引。
 */
class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int component = target - nums[i];
            if (map.containsKey(component)) {
                int[] a = {i, map.get(component)};
                return a;
            } 
            map.put(nums[i],i);
        }
        return null;
    }
}
