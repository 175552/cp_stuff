import java.util.*;
import java.io.*;
import java.awt.*;

public class sleepy {
    static int[] bit;
    public static void update(int num) {
        num++;
        while(num < bit.length) {
            bit[num]++;
            num += num & (-num);
        }
    }
    public static int get(int num) {
        num++;
        int sum = 0;
        while(num > 0) {
            sum += bit[num];
            num -= num & (-num);
        }
        return sum;
    }
    public static void main(String[] args) throws IOException {
        //Scanner input = new Scanner(System.in);
        Scanner input = new Scanner(new File("sleepy.in"));
        PrintWriter out = new PrintWriter(new File("sleepy.out"));
        int n = input.nextInt();
        int[] nums = new int[n];
        bit = new int[2 * n];
        for(int i = 0; i < n; i++) {
            nums[i] = input.nextInt();
        }
        update(nums[n - 1]);
        int pos = 0;
        for(int i = n - 2; i >= 0; i--) {
            if(nums[i] < nums[i + 1]) {
                update(nums[i]);
            } else {
                pos = i;
                break;
            }
        }
        out.println(pos + 1);
        out.print((get(nums[0]) + (pos)));
        update(nums[0]);
        for(int i = 1; i <= pos; i++) {
            out.print(" " + (get(nums[i]) + (pos - i)));
            update(nums[i]);
        }
        out.close();
    }
}