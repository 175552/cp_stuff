import java.util.*;
import java.io.*;
import java.awt.*;

public class reverengineering {
    public static void main(String[] args) throws IOException {
        Scanner input = new Scanner(System.in);
        int t = input.nextInt();
        for(int i = 0; i < t; i++) {
            int n = input.nextInt();
            int c = input.nextInt();
            if(c >= (n * (n + 1)/2) || c < n - 1) {
                System.out.println("Case #" + (i + 1) + ": IMPOSSIBLE");
                continue;
            }
            int switches = n - 1;
            int[] nums = new int[n];
            Arrays.fill(nums, -1);
            ArrayList<Integer> nexts = new ArrayList<>();
            for(int k = 0; k <= n/2; k++) {
                nexts.add(n - 1 - k);
                nexts.add(k);
            }
            int cur = 0;
            boolean reverse = true;
            int lastpos = -1;
            for(int k = n; k >= 2; k--) {
                if(k <= c - (switches - 1)) {
                    c -= k;
                    nums[nexts.get(cur)] = cur;
                    cur++;
                    reverse = !reverse;
                } else {
                    if(reverse) {
                        int temppos = nexts.get(cur);
                        int left = c - (switches - 1);
                        nums[temppos - (k - left)] = cur;
                        cur++;
                        lastpos = temppos - (k - left);
                    } else {
                        int temppos = nexts.get(cur);
                        int left = c - (switches - 1);
                        nums[temppos + (k - left)] = cur;
                        cur++;
                        lastpos = temppos + (k - left);
                    }
                    break;
                }
                switches--;
            }
            if(reverse) {
                int temptemp = lastpos - 1;
                while(temptemp >= 0 && nums[temptemp] == -1) {
                    nums[temptemp] = cur;
                    cur++;
                    temptemp--;
                }
                int clean = n - 1;
                for(int k = n - 1; k >= 0; k--) {
                    if(nums[k] == -1) {
                        nums[k] = clean;
                        clean--;
                    }
                }
            } else {
                int temptemp = lastpos + 1;
                while(temptemp < n && nums[temptemp] == -1) {
                    nums[temptemp] = cur;
                    cur++;
                    temptemp++;
                }
                int clean = n - 1;
                for(int k = 0; k < n; k++) {
                    if(nums[k] == -1) {
                        nums[k] = clean;
                        clean--;
                    }
                }
            }
            System.out.print("Case #" + (i + 1) + ": ");
            for(int k = 0; k < n; k++) {
                System.out.print((nums[k] + 1) + " ");
            }
            System.out.println();
        }
    }
}