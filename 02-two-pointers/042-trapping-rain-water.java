/*
思路：

最开始想从左右两边向中间移动。

1. left 和 right 表示当前左右边界。
2. 两边较矮的柱子决定当前能够达到的水位：
   lower = min(height[left], height[right])
3. 遍历中间比 lower 矮的位置，计算可以填入的水。
4. 最开始通过 height[h] = lower 模拟已经填入的水。
5. 后来发现这种方法会反复遍历中间区间，可以进一步优化成标准双指针。
*/

class Solution {
    public int trap(int[] height) {
        int left = 0;
        int right = height.length - 1;

        int rain = 0;

        while (left < right) {
            while (height[left] == 0 && left < right) {
                left++;
            }

            while (height[right] == 0 && left < right ) {
                right--;
            }

            int lower = Math.min(height[left], height[right]);

            for (int h = left + 1; h < right; h++) {
                if (height[h] < lower) {
                    rain = rain + lower - height[h];
                    height[h] = lower;
                }
            }
            // 移动更矮的那边
            if (height[left] < height[right]) {
                left++;
            } else if (height[left] > height[right]) {
                right--;
            } else {
                left++;
                right--;
            }

            while (left > 0 && left < right && height[left] == height[left - 1]) {
                left++;
            }

            while (right < height.length - 1 && left < right && height[right] == height[right + 1]) {
                right--;
            }
        }

        return rain;
    }
}
