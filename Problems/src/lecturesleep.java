import java.util.*;
public class lecturesleep {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int k = input.nextInt();
        int[] nums = new int[n];
        for(int i = 0; i < n; i++) {
            nums[i] = input.nextInt();
        }
        int[] other = new int[n];
        int total = 0;
        for(int i = 0; i < n; i++) {
            if(input.nextInt() == 1) {
                other[i] = nums[i];
                total += nums[i];
            }
        }
        int[] first = new int[n + 1];
        for(int i = 1; i <= n; i++) {
            first[i] = first[i - 1] + nums[i - 1];
        }
        int[] second = new int[n + 1];
        for(int i = 1; i <= n; i++) {
            second[i] = second[i - 1] + other[i - 1];
        }
        int max = 0;
        for(int i = 0; i < n - k + 1; i++) {
            int added = (first[i + k] - first[i]) - (second[i + k] - second[i]);
            max = Math.max(max, total + added);
        }
        System.out.println(max);
    }
}
