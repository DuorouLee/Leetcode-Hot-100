/*
 * LeetCode 42. Trapping Rain Water
 *
 * 思路：
 * 使用双指针从数组两端向中间移动。
 * leftMax 记录左侧遇到的最高柱子，rightMax 记录右侧遇到的最高柱子。
 * 如果 height[left] < height[right]，说明当前左侧水量可以确定；
 * 否则处理右侧。
 *
 * 当前柱子低于对应最大高度时：
 * rain += maxHeight - height[i]
 *
 * 注意：
 * - left、right 是数组下标。
 * - leftMax、rightMax 是柱子高度，不能作为数组下标使用。
 * - 每轮只处理较矮的一侧，不需要扫描中间区域。
 * - 不需要修改原 height 数组。
 *
 * 时间复杂度：O(n)
 * 空间复杂度：O(1)
 */

class Solution {
    public int trap(int[] height) {

        int left = 0;
        int right = height.length - 1;

        int leftMax = 0;
        int rightMax = 0;

        int rain = 0;

        while (left < right) {

            // 左边更矮，当前 left 位置的水量可以确定
            if (height[left] < height[right]) {

                if (height[left] < leftMax) {
                    rain += leftMax - height[left];
                } else {
                    leftMax = height[left];
                }

                left++;

            } else {

                // 右边更矮或相等，当前 right 位置的水量可以确定
                if (height[right] < rightMax) {
                    rain += rightMax - height[right];
                } else {
                    rightMax = height[right];
                }

                right--;
            }
        }

        return rain;
    }
}
