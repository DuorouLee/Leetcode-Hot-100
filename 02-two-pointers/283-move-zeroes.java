/*
 * LeetCode 283. Move Zeroes
 *
 * 思路：
 * 使用双指针。
 * fast 负责遍历并寻找非零元素，
 * slow 指向下一个应该放置非零元素的位置。
 *
 * 当 nums[fast] != 0 时，将其移动到 slow 所在位置，
 * 然后 slow 向后移动。
 *
 * 注意：
 * - Java 中的双指针通常就是两个数组下标变量。
 * - fast 每轮向后移动，slow 只在处理非零元素后移动。
 * - 原地修改数组，不额外创建数组。
 *
 * 时间复杂度：O(n)
 * 空间复杂度：O(1)
 */

class Solution {
    public void moveZeroes(int[] nums) {
        int slow = 0; // 指向下一个应该放非 0 元素的位置
        for (int fast = 0; fast < nums.length; fast++) {

            if (nums[fast] != 0) {
                int temp = nums[fast];
                nums[fast] = nums[slow];
                nums[slow] = temp;
                
                slow++;
            }
        }
    }
}
