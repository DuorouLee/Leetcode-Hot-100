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

1. `List<List<Integer>>` 表示外层是结果列表，每一个元素又是一个 `List<Integer>` 三元组。

2. `List` 不能使用 `{}` 初始化，应写：

```java
List<List<Integer>> results = new ArrayList<>();
```

3. `Set` 的泛型写法是：

```java
Set<List<Integer>> set = new HashSet<>();
```

不能写：

```java
Set<<List<Integer>>
```

4. 数组排序使用：

```java
Arrays.sort(array);
```

例如：

```java
Arrays.sort(nums);
```

5. `List` 排序使用：

```java
Collections.sort(list);
```

不能对 `List` 使用 `Arrays.sort()`。

6. `List.of(...)` 创建的 List 不可修改：

```java
List<Integer> list = List.of(1, 2, 3);
```

不能再对它执行需要修改元素的操作，例如：

```java
Collections.sort(list);
```

7. 如果后续需要修改 List，可以使用：

```java
new ArrayList<>(...)
```

例如：

```java
List<Integer> list =
    new ArrayList<>(Arrays.asList(3, 1, 2));

Collections.sort(list);
```

8. `Arrays.asList(...)` 可以快速创建一个 List：

```java
Arrays.asList(nums[i], nums[left], nums[right])
```

本题中三元组创建后不需要修改，因此可以直接加入结果。

9. 单纯使用 `Set<List<Integer>>` 去重时，需要保证三元组内部顺序一致。

例如：

```text
[-1, 0, 1]
[-1, 1, 0]
```

对于题目来说是同一个三元组，但对于 `List.equals()` 来说是两个不同的 List。

因此如果采用 `Set` 去重，需要先统一三元组内部顺序。

10. 本题更适合直接：

```text
排序 + 双指针 + 跳过重复元素
```

这样可以在生成答案时直接避免重复，而不是生成大量重复结果后再使用 `Set` 去重。

11. 固定 `nums[i]` 后：

```java
if (nums[i] > 0) {
    break;
}
```

因为数组已经排序，如果当前最小的固定数字都大于 `0`，后面的数字只会更大，不可能再得到和为 `0` 的三元组。

12. 第一个数字需要去重：

```java
if (i > 0 && nums[i] == nums[i - 1]) {
    continue;
}
```

找到一个三元组之后，`left` 和 `right` 同样需要跳过重复值。

---

### 我原来的思路

最开始尝试将问题转化为：

```text
固定一个 nums[i]
+
对剩下的数组做 Two Sum
```

使用：

```java
Map<Integer, Integer> map = new HashMap<>();
```

寻找：

```java
component = -nums[i] - nums[j]
```

这个思路可以找到满足条件的三元组，但处理重复答案会比较麻烦。

最开始尝试：

```text
先保存所有答案
→ 对每个三元组排序
→ 放入 Set 去重
```

虽然可以继续实现，但代码更加复杂，也容易遇到：

```text
List / Array 排序 API 混淆
List.of() 不可修改
Set 泛型写错
三元组内部顺序不同导致 Set 无法直接去重
```

因此最终改为：

```text
排序
→ 固定第一个数
→ 双指针寻找另外两个数
→ 在遍历过程中直接去重
```

代码更简洁，也更适合作为 3Sum 的标准解法。

---

### 复杂度

* 时间复杂度：`O(n²)`
* 空间复杂度：`O(1)`（不考虑结果列表以及排序实现使用的额外空间）

排序需要 `O(n log n)`，但后续外层循环配合双指针需要 `O(n²)`，因此总体时间复杂度为：


O(n²)
```
