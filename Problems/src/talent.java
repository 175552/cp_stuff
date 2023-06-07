import java.util.*;
import java.io.*;
import java.awt.*;
import java.lang.Math.*;
public class talent {
    public static class cow{
        int talent;
        int weight;
        int pos;
        cow(int pos, int weight, int talent) {
            this.pos = pos;
            this.talent = talent;
            this.weight = weight;
        }
    }
    static int[] dp;
    public static int convert(int talent, int weight) {
        return (int)(1000 * (double)(talent)/weight);
    }
    public static void main(String[] args) throws IOException {
        Scanner input = new Scanner(System.in);
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("talent.out")));
        int n = input.nextInt();
        int w = input.nextInt();
        cow[] cows = new cow[n];
        int maxtalent = 0;
        for(int i = 0; i < n; i++) {
            int weight = input.nextInt();
            int talent = input.nextInt();
            cows[i] = new cow(i, weight, talent);
            maxtalent += talent;
        }
        dp = new int[maxtalent + 1];
        Arrays.fill(dp, 0);
        for(int i = 0; i < n; i++) {
            cow temp = cows[i];
            for(int k = maxtalent; k >= 0; k--) {
                if(dp[k] != 0 || k == 0) {
                    if(dp[k + temp.talent] == 0) {
                        dp[k + temp.talent] = dp[k] + temp.weight;
                    } else {
                        dp[k + temp.talent] = Math.min(dp[k + temp.talent], dp[k] + temp.weight);
                    }
                }
            }
        }
        int max = 0;
        for(int i = 0; i <= n; i++) {
            for(int k = 0; k < maxtalent; k++) {
                if(dp[k] == 0 || dp[k] < w) {
                    continue;
                }
                max = Math.max(max, convert(k, dp[k]));
            }
        }
        System.out.println(max);
        out.close();
    }
}