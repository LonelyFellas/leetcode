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
}
