public class code {

    public static int calculateEditDistance(String A, String B) {
        int m = A.length();
        int n = B.length();
        
        int[][] dp = new int[m + 1][n + 1];
        
        for (int i = 0; i <= m; i++) {
            dp[i][0] = i; 
        }
        for (int j = 0; j <= n; j++) {
            dp[0][j] = j; 
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (A.charAt(i - 1) == B.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = 1 + Math.min(dp[i - 1][j - 1],  
                                            Math.min(dp[i - 1][j],    
                                                     dp[i][j - 1]));  
                }
            }
        }

        return dp[m][n];
    }

    public static void runTests() {
        String[] testA = {"", "abc", "kitten", "sunday", "abcdef"};
        String[] testB = {"", "def", "sitting", "saturday", "ab!@#"};
        
        for (int i = 0; i < testA.length; i++) {
            System.out.println("Edit distance between \"" + testA[i] + 
                               "\" and \"" + testB[i] + "\": " +
                               calculateEditDistance(testA[i], testB[i]));
        }

        System.out.println("Edit distance between \"\" and \"abc\": " + 
                           calculateEditDistance("", "abc"));
        System.out.println("Edit distance between \"abc\" and \"\": " + 
                           calculateEditDistance("abc", ""));
        System.out.println("Edit distance between \"a b c\" and \"abc\": " + 
                           calculateEditDistance("a b c", "abc"));
        System.out.println("Edit distance between \"@hello\" and \"#hello\": " + 
                           calculateEditDistance("@hello", "#hello"));
    }

    public static void main(String[] args) {
        runTests();
    }
}
