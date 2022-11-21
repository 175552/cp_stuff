import java.util.*;
import java.io.*;
import java.awt.*;

public class leapinglizards {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int[] nums = new int[n];
        for(int i = 0; i < n; i++) {
            nums[i] = input.nextInt();
        }
        long[] dp = new long[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[1] = 1;
        for(int i = 1; i <= n; i++) {
            long top = Integer.MIN_VALUE;
            long bottom = 1;
            for(int k = i + 1; k <= n; k++) {
                if(((nums[k - 1] - nums[i - 1]) - (top * ((k - i)/(double)bottom))) > .0001) {
                    dp[k] = Math.min(dp[k], dp[i] + 1);
                    top = nums[k - 1] - nums[i - 1];
                    bottom = k - i;
                }
            }
        }
        System.out.println(dp[n]);
    }
}