import java.util.*;
import java.io.*;
import java.awt.*;

public class snakes {
    public static void main(String[] args) throws IOException {
        //Scanner input = new Scanner(System.in);
        Scanner input = new Scanner(new File("snakes.in"));
        PrintWriter out = new PrintWriter(new File("snakes.out"));
        int n = input.nextInt();
        int k = input.nextInt();
        int[][] dp = new int[n + 1][k + 1];
        for(int i = 0; i <= n; i++) {
            for(int h = 1; h <= k; h++) {
                dp[i][h] = Integer.MAX_VALUE;
            }
        }
        int[] nums = new int[n];
        int sum = 0;
        for(int i = 0; i < n; i++) {
            nums[i] = input.nextInt();
            sum += nums[i];
        }
        int max = 0;
        for(int i = 0; i < n; i++) {
            int cur = nums[i];
            max = Math.max(max, cur);
            dp[i][0] = max * (i + 1);
            for(int b = 1; b <= k; b++) {
                int temp = cur;
                for(int h = i - 1; h >= 0; h--) {
                    if(dp[h][b - 1] == Integer.MAX_VALUE) {
                        continue;
                    }
                    dp[i][b] = Math.min(dp[i][b], dp[h][b - 1] + (i - h) * temp);
                    temp = Math.max(temp, nums[h]);
                }
            }
        }
        out.println(dp[n - 1][k] - sum);
        out.close();
    }
}