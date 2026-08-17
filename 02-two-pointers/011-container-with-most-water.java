/*
 * LeetCode 11. Container With Most Water
 *
 * 思路：
 * 使用左右双指针，从数组两端向中间移动。
 * 当前容器面积由较短的柱子决定：
 * area = (right - left) * min(height[left], height[right])
 *
 * 每次移动较矮的一边，因为宽度已经缩小，
 * 只有尝试找到更高的短板，面积才有可能变大。
 *
 * 注意：
 * - left 从左向右移动：left++
 * - right 从右向左移动：right--
 * - 面积由较短的一边决定。
 *
 * 时间复杂度：O(n)
 * 空间复杂度：O(1)
 */

class Solution {
    public int maxArea(int[] height) {
        int maxSize = 0;
        int left = 0;
        int right = height.length - 1;

        while (left < right) {
            int currentHeight = Math.min(height[left], height[right]);
            int currentLength = right - left;
            int currentSize = currentHeight * currentLength;

            maxSize = Math.max(maxSize, currentSize);

            if (height[left] <= height[right]) {
                left++;
            } else {
                right--;
            }
        }

        return maxSize;
    }
}
