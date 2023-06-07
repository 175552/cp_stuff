import java.util.*;
public class jackedman {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int m = input.nextInt();
        int[] money = new int[n];
        for(int i = 0; i < n; i++) {
            money[i] = input.nextInt();
        }
        int[] weights = new int[n];
        for(int i = 0; i < n; i++) {
            weights[i] = input.nextInt();
        }
        long[][] dp = new long[n + 1][m + 1];
        dp[0][0] = 0;
        for(int i = 1; i <= n; i++) {
            for(int k = 0; k <= m; k++) {
                if(weights[i - 1] <= k) {
                    dp[i][k] = Math.max(dp[i - 1][k - weights[i - 1]] + money[i - 1], dp[i - 1][k]);
                } else{
                    dp[i][k] = dp[i - 1][k];
                }
            }
        }
        System.out.println(dp[n][m]);
    }
}
