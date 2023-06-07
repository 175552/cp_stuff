import java.util.*;
import java.io.*;
import java.awt.*;

public class azran {
    public static void main(String[] args) throws IOException {
        Scanner input = new Scanner(System.in);
        String line = input.nextLine();
        int[] real = new int[line.length()];
        for(int i = 0; i < line.length(); i++) {
            real[i] = (int)line.charAt(i) - 97;
        }
        int[] last = new int[26];
        Arrays.fill(last, -1);
        int[] dp = new int[real.length + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for(int i = 1; i <= real.length; i++) {
            int temp = real[i - 1];
            if(last[temp] != -1) {
                dp[i] = Math.min(dp[last[temp]], dp[i]);
            }
            dp[i] = Math.min(dp[i], dp[i - 1] + 1);
            last[temp] = i;
        }
        System.out.println(dp[real.length]);
    }
}