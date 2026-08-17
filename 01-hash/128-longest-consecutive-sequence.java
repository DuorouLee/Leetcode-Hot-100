/*
 * LeetCode 128. Longest Consecutive Sequence
 *
 * 思路：
 * 1. 使用 HashSet 存储所有数字，方便 O(1) 平均时间查找。
 * 2. 如果 num - 1 不存在，说明 num 是一段连续序列的起点。
 * 3. 从起点开始不断查找 currentNum + 1，统计连续序列长度。
 * 4. 更新最长连续序列长度。
 *
 * 注意：
 * - Set 是接口，需要使用 HashSet 实例化。
 * - 后续遍历 Set 而不是原数组 nums，避免重复元素导致重复计算。
 * - 序列长度从 1 开始，因为起点本身已经算一个元素。
 *
 * 时间复杂度：O(n)
 * 空间复杂度：O(n)
 */

 class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();

        for (int num : nums) {
            set.add(num);
        }

        int maxLength = 0;

        for (int num : set) {
            if (!set.contains(num - 1)) {
                int currentNum = num;
                int length = 1;

                while (set.contains(currentNum + 1)) {
                    currentNum++;
                    length++;
                }

                maxLength = Math.max(maxLength, length);
            }
        }

        return maxLength;
    }
}
