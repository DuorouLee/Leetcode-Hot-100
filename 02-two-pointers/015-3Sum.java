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
            // 如果最小的固定数 > 0 后面的三数相加都不可能得到0
            if (nums[i] > 0) {
                break;
            }

            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {

                int sum = nums[i] + nums[left] + nums[right];

                if (sum == 0) {
                    results.add(
                            Arrays.asList(nums[i], nums[left], nums[right]));
                    left++;
                    right--;

                    while (left < right && nums[left] == nums[left - 1]) {
                        left++;
                    }

                    while (left < right && nums[right] == nums[right + 1]) {
                        right--;
                    }

                } else if (sum > 0) {
                    right--;
                } else {
                    left++;
                }
            }
        }
        return results;
    }
}
