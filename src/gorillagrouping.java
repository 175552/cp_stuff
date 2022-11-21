import java.util.*;
import java.io.*;
import java.awt.*;

public class gorillagrouping {
    public static long binpow(long x, long y, long p) {
        long res = 1;
        x = x % p;
        if (x == 0) return 0;
        while (y > 0) {
            if((y & 1)==1) {
                res = (res * x) % p;
            }
            y = y >> 1;
            x = (x * x) % p;
        }
        return res;
    }
    public static long numofsubset(int[] arr, int n, int k, long mod) {
        Arrays.sort(arr);
        int count = 1;
        for (int i = 0; i < n - 1; i++) {
            if (arr[i] + k != arr[i + 1]) {
                count++;
                count %= mod;
            }
        }
        return count;
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        long mod = 1000000007;
        int n = input.nextInt();
        int k = input.nextInt();
        int[] nums = new int[n];
        for(int i = 0; i < n; i++) {
            nums[i] = input.nextInt();
        }
        long total = binpow(2, n, mod) - 1;
        long num = numofsubset(nums, n, k, mod);
        System.out.println(total + " " +  num);
    }
}