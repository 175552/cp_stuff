import java.util.*;
import java.io.*;
public class maximumsubarrayofsizek {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int k = input.nextInt();
        int[] nums = new int[n];
        for(int i = 0; i < n; i++) {
            nums[i] = input.nextInt();
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        TreeSet<Integer> set = new TreeSet<>();
        for(int i = 0; i < k; i++) {
            if(!map.containsKey(nums[i])) {
                map.put(nums[i], 1);
            } else {
                map.put(nums[i], map.get(nums[i]) + 1);
            }
            set.add(nums[i]);
        }
        for(int i = k; i < n; i++) {
            System.out.print(set.last() + " ");
            int temp = nums[i - k];
            map.put(temp, map.get(temp) - 1);
            if(map.get(temp) == 0) {
                set.remove(temp);
            }
            if(!map.containsKey(nums[i])) {
                map.put(nums[i], 1);
            } else {
                map.put(nums[i], map.get(nums[i]) + 1);
            }
            set.add(nums[i]);
        }
        System.out.print(set.last());
        System.out.println();
    }
}
