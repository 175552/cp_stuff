import java.util.*;
import java.io.*;
import java.awt.*;

public class teamwork {
    public static void main(String[] args) throws IOException {
        //Scanner input = new Scanner(System.in);
        Scanner input = new Scanner(new File("teamwork.in"));
        PrintWriter out = new PrintWriter(new File("teamwork.out"));
        int n = input.nextInt();
        int k = input.nextInt();
        int[] nums = new int[n + 1];
        for(int i = 1; i <= n; i++) {
            nums[i] = input.nextInt();
        }
        int[] dp = new int[n + 1];
        dp[0] = 0;
        for(int i = 1; i <= n; i++) {
            int max = nums[i];
            for(int j = i - 1; j >= 0 && i - j <= k; j--) {
                dp[i] = Math.max(dp[i], dp[j] + max * (i - j));
                max = Math.max(max, nums[j]);
            }
        }
        out.println(dp[n]);
        out.close();
    }
}