import java.util.*;
import java.io.*;
import java.awt.*;

public class zootour {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int q = input.nextInt();
        long[] nums = new long[n];
        for(int i = 0; i < n; i++) {
            nums[i] = input.nextInt();
        }
        long[] prefixforward = new long[n];
        for(int i = 1; i < n; i++) {
            prefixforward[i] = prefixforward[i - 1] + nums[i - 1];
        }
        long loop = nums[n - 1];
        for(int i = 0; i < q; i++) {
            int temp1 = input.nextInt() - 1;
            int temp2 = input.nextInt() - 1;
            int left = Math.min(temp1, temp2);
            int right = Math.max(temp1, temp2);
            System.out.println(Math.min(prefixforward[right] - prefixforward[left], prefixforward[n - 1] - prefixforward[right] + prefixforward[left] + loop));
        }
    }
}