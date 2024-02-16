import java.util.Arrays;

public class Day1 {
    /**
     * Count the number of divisors of a positive integer n.
     *
     * @param n
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
     * @param boxes
     * @return
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
     * @param nums
     * @return
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
     * @param nums
     * @param target
     * @return
     * @see <a href="https://leetcode.com/problems/search-insert-position/">LeetCode 35 Search Insert Position</a>
     */
    public int searchInsert(int[] nums, int target) {
        int n = nums.length;
        int left = 0, right = n - 1;
        while(left <= right) {
            int mid = left + (right - left) / 2;
            if(nums[mid] == target) {
                return mid;
            } else if(nums[mid] < target) {
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
}
