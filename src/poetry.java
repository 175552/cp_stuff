import java.util.*;
import java.io.*;
import java.awt.*;

public class poetry {
    public static class word{
        int length;
        int rhyme;
        word(int length, int rhyme) {
            this.length = length;
            this.rhyme = rhyme;
        }
    }
    public static long power(long a, long b, long mod) {
        long res = 1;
        while(b > 0) {
            if(b % 2 == 1) {
                res *= a;
                res %= mod;
            }
            a *= a;
            a %= mod;
            b /= 2;
        }
        return res;
    }
    static long mod = 1000000007;
    public static void main(String[] args) throws IOException{
        Scanner input = new Scanner(new File("poetry.in"));
        PrintWriter out = new PrintWriter(new FileWriter("poetry.out"));
        int n = input.nextInt();
        int m = input.nextInt();
        int k = input.nextInt();
        HashMap<Integer, Long> map = new HashMap<>();
        word[] words = new word[n];
        for(int i = 0; i < n; i++) {
            words[i] = new word(input.nextInt(), input.nextInt());
        }
        long[] dp = new long[k + 1];
        dp[0] = 1;
        for(int i = 0; i <= k; i++) {
            if(dp[i] == 0) {
                continue;
            }
            for(int h = 0; h < n; h++) {
                if(words[h].length + i > k) {
                    continue;
                }
                dp[words[h].length + i] += dp[i];
                dp[words[h].length + i] %= mod;
                if(words[h].length + i == k) {
                    if(map.containsKey(words[h].rhyme)) {
                        map.put(words[h].rhyme, (map.get(words[h].rhyme) + dp[i]) % mod);
                    } else map.put(words[h].rhyme, dp[i]);
                }
            }
        }
        int[] scheme = new int[26];
        input.nextLine();
        for(int i = 0; i < m; i++) {
            String line = input.nextLine();
            scheme[(int)line.charAt(0) - 65]++;
        }
        long result = 1;
        for(int i = 0; i < 26; i++) {
            long temp = 0;
            if(scheme[i] == 0) {
                continue;
            }
            for(Integer h : map.keySet()) {
                temp += power(map.get(h), scheme[i], mod);
                temp %= mod;
            }
            result *= temp;
            result %= mod;
        }
        out.println(result);
        out.close();
    }
}