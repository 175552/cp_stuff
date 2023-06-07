import java.util.*;
import java.io.*;
import java.awt.*;

public class F1 {
    public static void main(String[] args) throws IOException {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int t = input.nextInt();
        int prev = 0;
        int left = 1;
        int right = n;
        for(int i = 0; i < t; i++) {
            int k = input.nextInt();
            int realk = k;
            if(i != 0) {
                if(k < prev) {
                    right = left - 1;
                    left = 1;
                } else {
                    left++;
                    right = n;
                    k = k - prev + 1;
                }
            }
            prev = realk;
            while(left < right) {
                int mid = (left + right)/2;
                System.out.println("? " + left + " " + mid);
                System.out.flush();
                int sum1 = input.nextInt();
                int zeroes = mid - left + 1 - sum1;
                if(zeroes >= k) {
                    right = mid;
                } else {
                    left = mid + 1;
                    k -= zeroes;
                }
            }
            System.out.println("! " + left);
            System.out.flush();
        }
    }
}