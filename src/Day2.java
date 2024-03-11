public class Day2 {
    /**
     * Leetcode 14
     */
    public String longestCommonPrefix(String[] strs) {
        int len = strs.length;
        if (len == 0) {
            return "";
        }
        if (len == 1) {
            return strs[0];
        }
        String ans = "";

        int i = 0;
        flag:
        while(i < strs[0].length()) {
            char tempChar = strs[0].charAt(i);
            int j = 1;
            while(j < len) {
               if (strs[j].length() <= i || strs[j].charAt(i) != tempChar) {
                 break flag;
               }
               j++;
            }
            ans += tempChar;
            i++;
        }

        return ans;
    }
}
