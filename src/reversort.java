import java.util.*;
import java.io.*;
import java.awt.*;

public class reversort {
    public static void main(String[] args) throws IOException {
        Scanner input = new Scanner(System.in);
        int t = input.nextInt();
        for(int i = 0; i < t; i++) {
            int n = input.nextInt();
            int[] nums = new int[n];
            for(int k = 0; k < n; k++) {
                nums[k] = input.nextInt();
            }
            int sum = 0;
            for(int k = 0; k < n - 1; k++) {
                int num = k + 1;
                int pos = -1;
                for(int h = k; h < n; h++) {
                    if(nums[h] == num) {
                        pos = h;
                    }
                }
                sum += pos - k + 1;
                int[] temp = new int[n];
                for(int h = k; h <= pos; h++) {
                    temp[h] = nums[pos - (h - k)];
                }
                for(int h = k; h <= pos; h++) {
                    nums[h] = temp[h];
                }
            }
            System.out.println("Case #" + (i + 1) + ": " + sum);
        }
    }
}