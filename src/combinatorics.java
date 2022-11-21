import java.util.*;
import java.io.*;
import java.awt.*;

public class combinatorics {
    public static long nCK(int n, int k, long mod) {
        long[][] dp = new long[2][k + 1];
        int source = 1, target = 0;
        for(int i = 0; i <= n; i++) {
            source = (source + 1) % 2;
            target = (target + 1) % 2;
            for(int h = 0; h <= Math.min(i, k); h++) {
                if(h == 0 || h == i) {
                    dp[target][h] = 1;
                } else {
                    dp[target][h] = (dp[source][h - 1] + dp[source][h]) % mod;
                }
            }
        }
        return dp[target][k];
    }
    public static long fermats(int n, int k, long mod) {
        long[] factorial = new long[n + 1];
        factorial[1] = 1;
        for(int i = 2; i <= n; i++) {
            factorial[i] = (factorial[i - 1] * i) % mod;
        }
        return (((factorial[n] * power(factorial[k], mod - 2, mod)) % mod) * (power(factorial[n - k], mod - 2, mod) % mod)) % mod;
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
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int k = input.nextInt();

        //System.out.println(power(n, k, 1000000007));
        System.out.println(fermats(n, k, 1000000007));
        System.out.println(nCK(n, k, 1000000007));
    }
}