import java.util.*;
import java.io.*;
import java.awt.*;

public class climbingtrees {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int k = input.nextInt();
        int[] nums = new int[n];
        for(int i = 0; i < n; i++) {
            nums[i] = input.nextInt();
        }
        Arrays.sort(nums);
        long sum = 0;
        int pos = 0;
        long temp = nums[pos];
        for(int i = 1; i < n; i++) {
            if(nums[i] - nums[pos] > k) {
                sum = Math.max(sum, temp);
                temp = nums[i];
            } else {
                temp += nums[i];
            }
            pos = i;
        }
        sum = Math.max(sum, temp);
        System.out.println(sum);
    }
}
