import java.util.*;
import java.io.*;
import java.awt.*;

public class F {
    public static void main(String[] args) throws IOException {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int t = input.nextInt();
        for(int i = 0; i < t; i++) {
            int k = input.nextInt();
            int left = 1;
            int right = n;
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