import java.util.*;
import java.io.*;
import java.awt.*;

public class greedy {
    public static void main(String[] args) throws IOException {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int one = 0;
        int two = 0;
        int[] nums = new int[n];
        for(int i = 0; i < n; i++) {
            nums[i] = input.nextInt();
        }
        Arrays.sort(nums);
        for(int i = n - 1; i >= 0; i--) {
            int temp = nums[i];
            if(two < one) {
                two += temp;
            } else one += temp;
        }
        System.out.println(one + " " + two + " " + (one - two));
    }
}