import java.util.*;
import java.io.*;
import java.awt.*;

public class street {
    public static void main(String[] args) throws IOException {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int m = input.nextInt();
        int h = input.nextInt();
        int[] nums = new int[n];
        for(int i = 0; i < n; i++) {
            nums[i] = input.nextInt();
        }
        Arrays.sort(nums);
        int l = 1;
        int r = h;
        while(l < r) {
            int mid = (l + r)/2;
            int count = 0;
            for(int i = 0; i < n - 1; i++) {
                count += Math.min(2 * mid, nums[i + 1] - nums[i] - 1);
            }
            count += Math.min(mid, nums[0] - 1);
            count += Math.min(mid, h - nums[n - 1]);
            if(count >= m) {
                r = mid;
            } else l = mid + 1;
        }
        System.out.println(l);
    }
}