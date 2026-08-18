## 283. Move Zeroes

1. Java 中算法题里的“指针”通常就是保存数组下标的 int 变量。
2. fast 用来遍历整个数组，因此每一轮都会向后移动。
3. slow 只在处理完一个非零元素后向后移动。
4. 使用交换可以把非零元素向前移动，同时把 0 留在后面。
5. 不需要创建新的数组，满足原地修改的要求。
6. 循环条件应根据数组边界判断，而不是判断 slow == fast。
7. 当 slow == fast 时交换自己没有影响，也可以通过条件判断减少不必要的交换。

## 011. Container With Most Water

1. 左指针向右移动使用 left++。
2. 右指针向左移动使用 right--，不要写成 right++。
3. 容器高度使用 Math.min(height[left], height[right])。
4. 容器宽度是 right - left。
5. 面积由较短的一边限制，因此每次移动较矮的指针。因为容器高度由较短的柱子决定，而指针向内移动后宽度一定会减小，所以只有移动较矮的一边，才有可能通过找到更高的柱子获得更大的面积。
6. 双指针从两端向中间移动，可以将暴力枚举的 O(n²) 优化为 O(n)。


## 15. 3Sum

### Java API 记录
- List<List<Integer>>
- Set<List<Integer>>
- Arrays.sort()
- Collections.sort()
- List.of() 不可修改
- Arrays.asList()

### 去重注意
- Set 去重要求三元组内部顺序一致
- 本题更适合排序 + 双指针直接去重

### 解题思路
排序
→ 固定 nums[i]
→ left / right 双指针
→ sum < 0：left++
→ sum > 0：right--
→ sum == 0：记录答案
→ 移动左右指针并跳过重复值

### Debug 记录
1. sum == 0 后不移动指针
   → 死循环
   → Memory Limit Exceeded

2. 去重使用 if
   → 只能跳过一个重复值
   → Duplicate Answer / Wrong Answer

### 原来的思路
HashMap Two Sum
→ 能做
→ 但重复答案处理更麻烦

### 复杂度
时间 O(n²)
空间 O(1)
