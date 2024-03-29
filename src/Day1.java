import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Day1 {
    /**
     * Count the number of divisors of a positive integer n.
     *
     * @param n the positive integer
     * @return the number of divisors of n
     */
    public int numberOfDivisor(int n) {
        if (n == 1) return 1;
        int ans = 0;
        int half = n / 2;
        for (int i = 1; i <= half; i++) {
            if (n % i == 0) {
                ans += half >= n / i ? 1 : 2;
            }
        }
        return ans;
    }

    /**
     * LeetCode 1769 Minimum Number of Operations to Move All Balls to Each Box
     *
     * @param boxes a string of '0' and '1'
     * @return an array of integers
     * @see <a href="https://leetcode.com/problems/minimum-number-of-operations-to-move-all-balls-to-each-box/">LeetCode 1769 Minimum Number of Operations to Move All Balls to Each Box</a>
     */
    public int[] minOperations(String boxes) {
        int n = boxes.length();
        int ansArr[] = new int[n];

        for (int i = 0; i < n; i++) {
            int ans = 0;
            int left = i - 1;
            int right = i + 1;
            while (left >= 0) {
                if (boxes.charAt(left) == '1') {
                    ans += i - left;
                }
                left--;
            }
            while (right < n) {
                if (boxes.charAt(right) == '1') {
                    ans += right - i;
                }
                right++;
            }
            ansArr[i] = ans;
        }
        return ansArr;
    }

    /**
     * LeetCode LCR 012 寻找数组的中心下标
     *
     * @param nums 数组
     * @return 中心下标
     * @see <a href="https://leetcode.cn/problems/tvdfij/">LeetCode LCR 012 寻找数组的中心下标</a>
     */
    public int pivotIndex(int[] nums) {
        int total = Arrays.stream(nums).sum();
        int n = nums.length;
        int sum = 0;

        for (int i = 0; i < n; i++) {
            if (2 * sum + nums[i] - total == 0) {
                return i;
            }
            sum += nums[i];
        }
        return -1;
    }

    /**
     * LeetCode 35 Search Insert Position
     *
     * @param nums  有序数组
     * @param target 目标值
     * @return 目标值的索引
     * @see <a href="https://leetcode.com/problems/search-insert-position/">LeetCode 35 Search Insert Position</a>
     */
    public int searchInsert(int[] nums, int target) {
        int n = nums.length;
        int left = 0, right = n - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                if (mid == n - 1 || nums[mid + 1] > target) {
                    return mid + 1;
                }
                left = mid + 1;
            } else {
                if (mid == 0 || nums[mid - 1] < target) {
                    return mid;
                }
                right = mid - 1;
            }
        }

        return -1;
    }

    /**
     * LeetCode 56 Merge Intervals
     * @param intervals 二维数组
     * @return 合并后的二维数组
     * @see <a href="https://leetcode.com/problems/merge-intervals/">LeetCode 56 Merge Intervals</a>
     */
    public int[][] merge(int[][] intervals) {
        int n = intervals.length;

        Arrays.sort(intervals, (lhs, rhs) -> lhs[0] - rhs[0]);
        List<int[]> ans = new ArrayList<>();

        int left = intervals[0][0];
        int right = intervals[0][1];

        for (int i = 1; i < n; i++) {
            if (intervals[i][0] <= right) {
                left = Math.min(left, intervals[i][0]);
                right = Math.max(right, intervals[i][1]);
            } else {
                ans.add(new int[]{left, right});
                left = intervals[i][0];
                right = intervals[i][1];
            }
        }
        ans.add(new int[]{left, right});


       return ans.toArray(new int[ans.size()][]);
    }
    /**
     * LeetCode 48 Rotate Image
     * @param matrix 二维数组
     * @see <a href="https://leetcode.com/problems/rotate-image/">LeetCode 48 Rotate Image</a>
     */
    public void rotate(int[][] matrix) {
        int c= matrix.length;
        int r = matrix[0].length;
        int[][] ans = new int[c][r];

        for (int i = 0; i < c; i++) {
            for (int j = 0; j < r; j++) {
                ans[j][c - i - 1] = matrix[i][j];
            }
        }

        for (int i = 0; i < c; i++) {
            for (int j = 0; j < r; j++) {
                matrix[i][j] = ans[i][j];
            }
        }
    }
    /**
     * LeetCode 73 Set Matrix Zeroes
     * @param matrix 二维数组
     * @see <a href="https://leetcode.com/problems/set-matrix-zeroes/">LeetCode 73 Set Matrix Zeroes</a>
     */
    public void setZeroes(int[][] matrix) {
         int c = matrix.length;
         int r = matrix[0].length;
         boolean[][] mark = new boolean[c][r];
         for (int i = 0; i < c; i++) {
             for (int j = 0; j < r; j++) {
                 if (matrix[i][j] == 0) {
                     for (int k = 0; k < c; k++) {
                         mark[k][j] = true;
                     }
                     for (int k = 0; k < r; k++) {
                        mark[i][k] = true;
                     }
                 }
             }
         }
         for (int i = 0; i < c; i++) {
             for (int j = 0; j < r; j++) {
                 if (mark[i][j]) {
                     matrix[i][j] = 0;
                 }
             }
         }
    }
    /**
     * LeetCode 498 Diagonal Traverse
     * @param matrix 二维数组
     * @return 一维数组
     * @see <a href="https://leetcode.com/problems/diagonal-traverse/">LeetCode 498 Diagonal Traverse</a>
     */
    public int[] findDiagonalOrder(int[][] matrix) {
        int yLen = matrix.length;
        int xLen = matrix[0].length;
        int sumLen = yLen + xLen;
        int[] ans = new int[sumLen];

        int r = 0; // row
        int c = 0; // column
        for (int i = 0; i < sumLen; i++) {
            // 奇数
            if (r % 2 == 1) {
                ans[i] = matrix[c][r];
                if (c == yLen) {
                    c += 1;
                } else {
                    r -= 1;
                    c += 1;
                }
            } else {
                ans[i] = matrix[c][r];
                if (r == 0) {
                    if (c == 0) {
                        r += 1;
                    } else {
                        c += 1;
                    }
                } else {
                    c -= 1;
                }

            }
        }

        return ans;
    }
}
