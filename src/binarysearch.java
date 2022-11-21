import java.util.*;
import java.io.*;
public class binarysearch {
    public static int solve(int q, int[] nums) {
        int l = 0;
        int r = nums.length - 1;
        while(l <= r) {
            int mid = (l + r)/2;
            if(q < nums[mid]) {
                r = mid - 1;
            } else if(q > nums[mid]){
                l = mid + 1;
            }
        }
        return l;
    }
    public static void main(String[] args) throws IOException{
        Scanner input = new Scanner(new File("case.txt"));
        PrintWriter out = new PrintWriter(new FileWriter("output.txt"));
        int n = input.nextInt();
        int q = input.nextInt();
        int[] nums = new int[n];
        for(int i = 0; i < n; i++) {
            nums[i] = input.nextInt();
        }
        Arrays.sort(nums);
        for(int i = 0; i < q; i++) {
            int temp = input.nextInt();
            out.println(solve(temp, nums) + 1);
        }
        out.close();
    }
}
