import java.util.*;
public class FenwickTest {
    public static int solve(int[] nums, int bound) {
        int sum = 0;
        for(int i = 0; i <= bound; i++) {
            sum += nums[i];
        }
        return sum;
    }
    final static int VAL_BOUND = 10;
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int[] nums = new int[n];
        Random r = new Random();
        for(int i = 0; i < n; i++) {
            nums[i] = r.nextInt(VAL_BOUND);
            System.out.print(nums[i] + " ");
        }
        System.out.println();
        Fenwick fenwick = new Fenwick(nums);
        for(int i = 0; i < 10; i++) {
            int bound = r.nextInt(n);
            int expected = solve(nums, bound);
            int got = fenwick.query(bound);
            if(expected != got) {
                System.out.println("Sum til " + bound + " got " + got + ". Expected " + expected);
                return;
            }
            int update = r.nextInt(n);
            int val = r.nextInt(VAL_BOUND);
            System.out.println("Updated " + update + " with " + val);
            nums[update] += val;
            fenwick.update(update, val);
        }
    }
}
