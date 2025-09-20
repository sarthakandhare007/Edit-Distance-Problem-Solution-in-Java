public class EditDistance {
    public int minDistance(String word1, String word2) {
        int m = word1.length(), n = word2.length();
        int[][] dp = new int[m + 1][n + 1];

        // Base cases
        for (int i = 0; i <= m; i++) dp[i][0] = i; // delete all
        for (int j = 0; j <= n; j++) dp[0][j] = j; // insert all

        // Fill dp table
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = 1 + Math.min(
                        dp[i - 1][j - 1], // replace
                        Math.min(dp[i - 1][j], // delete
                                 dp[i][j - 1]) // insert
                    );
                }
            }
        }

        return dp[m][n];
    }

    // Quick test
    public static void main(String[] args) {
        EditDistance sol = new EditDistance();
        System.out.println(sol.minDistance("horse", "ros")); // Output: 3
        System.out.println(sol.minDistance("intention", "execution")); // Output: 5
    }
}
