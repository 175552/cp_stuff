import java.util.*;
import java.io.*;
import java.awt.*;

public class H {
    public static void main(String[] args) throws IOException {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int c1 = input.nextInt();
        int c2 = input.nextInt();
        int c3 = input.nextInt();
        HashSet<Integer> prefix = new HashSet<>();
        int sum = 0;
        for(int i = 0; i < n - 1; i++) {
            sum += input.nextInt();
            prefix.add(sum);
        }
        sum += input.nextInt();
        int[][][] dp = new int[sum + 1][c1 + 1][c2 + 1];
        dp[0][0][0] = 1;
        for(int i = 1; i <= sum; i++) {
            if(prefix.contains(i)) {
               continue;
            }
            for(int k = 0; k <= c1; k++) {
                for(int h = 0; h <= c2; h++) {
                    int remain = i - (k + (h * 2));
                    if(remain >= 0 && remain % 3 == 0 && remain/3 <= c3) {
                        try {
                            dp[i][k][h] = Math.max(dp[i - 1][k - 1][h], dp[i][k][h]);
                        } catch(Exception e) {}
                        if(i > 1) {
                            try {
                                dp[i][k][h] = Math.max(dp[i - 2][k][h - 1], dp[i][k][h]);
                            } catch(Exception e) {}
                        }
                        if(i > 2) {
                            try {
                                dp[i][k][h] = Math.max(dp[i - 3][k][h], dp[i][k][h]);
                            } catch(Exception e) {}
                        }
                    }
                }
            }
        }
        boolean works = false;
        for(int k = 0; k <= c1; k++) {
            for(int h = 0; h <= c2; h++) {
                if(dp[sum][k][h] == 1) {
                    works = true;
                }
            }
        }
        if(works) {
            System.out.println("YES");
        } else System.out.println("NO");
    }
}