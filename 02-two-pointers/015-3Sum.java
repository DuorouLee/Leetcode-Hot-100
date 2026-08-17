/*
 * LeetCode 15. 3Sum
 *
 * 思路：
 * 数组排序后固定 nums[i]，剩下两个数使用左右双指针寻找。
 * sum < 0 时 left++，sum > 0 时 right--，
 * sum == 0 时记录答案并跳过重复元素。
 *
 * 注意：
 * - i、left、right 都需要去重。
 * - 数组使用 Arrays.sort()，List 使用 Collections.sort()。
 * - List.of() 创建的 List 不可修改。
 *
 * 时间复杂度：O(n²)
 * 空间复杂度：O(1)
 */

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();

        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {

            // 排序后，如果最小的固定数已经大于 0，后面不可能再得到 0
            if (nums[i] > 0) {
                break;
            }

            // 跳过重复的第一个数
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];

                if (sum == 0) {
                    results.add(
                        Arrays.asList(nums[i], nums[left], nums[right])
                    );

                    // 跳过 left 的重复值
                    while (left < right && nums[left] == nums[left + 1]) {
                        left++;
                    }

                    // 跳过 right 的重复值
                    while (left < right && nums[right] == nums[right - 1]) {
                        right--;
                    }

                    left++;
                    right--;

                } else if (sum < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }

        return results;
    }
}
