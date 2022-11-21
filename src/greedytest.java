import java.util.*;
public class greedytest{
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int t = input.nextInt();
        for(int i = 0; i < t; i++) {
            int n = input.nextInt();
            int[] nums = new int[n];
            for(int k = 0; k < n; k++) {
                nums[k] = input.nextInt();
            }
            int groups = 0;
            Arrays.sort(nums);
            int left = 0;
            for(int k = 0; k < n; k++) {
                if(nums[k] == (k - left + 1)) {
                    groups++;
                    left = k + 1;
                }
            }
            System.out.println(groups);
        }
    }
}