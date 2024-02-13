public class Day1 {
    /**
     * Count the number of divisors of a positive integer n.
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
}
