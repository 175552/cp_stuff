import java.util.*;
import java.awt.*;
public class C {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int t = input.nextInt();
        for(int i = 0; i < t; i++) {
            int n = input.nextInt();
            int[] nums = new int[n];
            for(int k = 0; k < n; k++) {
                nums[k] = input.nextInt();
            }
            if(n == 1) {
                System.out.println(1);
                continue;
            } else if(n == 2) {
               System.out.println(3);
            } else if(n == 3){
                int temp = 5;
                int fuck = 0;
                if(nums[0] <= nums[1] && nums[1] <= nums[2]) {
                    fuck++;
                } else if(nums[0] >= nums[1] && nums[1] >= nums[2]) {
                    fuck++;
                }
                System.out.println(n - 2 - fuck + temp);
            } else {
                int temp = n + n - 1 + n - 2 + n - 3;
                int fuck = 0;
                for(int k = 2; k < n; k++) {
                    if(nums[k - 2] <= nums[k - 1] && nums[k - 1] <= nums[k]) {
                        fuck++;
                    } else if(nums[k - 2] >= nums[k - 1] && nums[k - 1] >= nums[k]) {
                        fuck++;
                    }
                }
                for(int k = 3; k < n; k++) {
                    if(nums[k - 2] <= nums[k - 1] && nums[k - 1] <= nums[k]) {
                        fuck++;
                    } else if(nums[k - 2] >= nums[k - 1] && nums[k - 1] >= nums[k]) {
                        fuck++;
                    } else if(nums[k - 3] <= nums[k - 1] && nums[k - 1] <= nums[k]) {
                        fuck++;
                    } else if(nums[k - 3] >= nums[k - 1] && nums[k - 1] >= nums[k]) {
                        fuck++;
                    } else if(nums[k - 3] <= nums[k - 2] && nums[k - 2] <= nums[k]) {
                        fuck++;
                    } else if(nums[k - 3] >= nums[k - 2] && nums[k - 2] >= nums[k]) {
                        fuck++;
                    } else if(nums[k - 3] <= nums[k - 2] && nums[k - 2] <= nums[k - 1]) {
                        fuck++;
                    } else if(nums[k - 3] >= nums[k - 2] && nums[k - 2] >= nums[k - 1]) {
                        fuck++;
                    }
                }
                System.out.println(temp - fuck);
            }
        }
    }
}
