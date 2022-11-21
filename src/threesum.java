import java.util.*;
import java.io.*;
import java.awt.*;

public class threesum {
    public static void main(String[] args) throws IOException {
        //Scanner input = new Scanner(System.in);
        Scanner input = new Scanner(new File("threesum.in"));
        PrintWriter out = new PrintWriter(new File("threesum.out"));
        int n = input.nextInt();
        int q = input.nextInt();
        int[] nums = new int[n];
        for(int i = 0; i < n; i++) {
            nums[i] = input.nextInt();
        }
        long[][] calc = new long[n][n];
        long[] temp = new long[2 * 1000000 + 1];
        for(int i = 0; i < n; i++) {
            for(int k = i + 1; k < n; k++) {
                int bru = (-(nums[i] + nums[k]) + 1000000);
                if(bru <= 2000000 && bru >= 0) {
                    calc[i][k] = temp[bru];
                }
                temp[(nums[k] + 1000000)]++;
            }
            for(int k = i + 1; k < n; k++) {
                temp[(nums[k] + 1000000)]--;
            }
        }
        long[][] ans = new long[n][n];
        for(int i = n - 1; i >= 0; i--) {
            for(int k = i + 1; k < n; k++) {
                ans[i][k] = calc[i][k] + ans[i][k - 1] + ans[i + 1][k] - ans[i + 1][k - 1];
            }
        }
        for(int i = 0; i < q; i++) {
            int a = input.nextInt() - 1;
            int b = input.nextInt() - 1;
            out.println(ans[a][b]);
        }
        out.close();
    }
}