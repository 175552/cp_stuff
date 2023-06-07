import java.util.*;
import java.io.*;
import java.awt.*;

public class haircut {
    public static long get(int pos) {
        long sum = 0;
        pos++;
        while(pos < bit.length) {
            sum += bit[pos];
            pos += pos & (-pos);
        }
        return sum;
    }
    public static void update(int value) {
        value++;
        while(value > 0) {
            bit[value]++;
            value -= value & (-value);
        }
    }
    public static class store implements Comparable<store>{
        int value;
        int pos;
        store(int value, int pos) {
            this.value = value;
            this.pos = pos;
        }
        public int compareTo(store o) {
            return value - o.value;
        }
    }
    static long[] bit;
    public static void main(String[] args) throws IOException{
        Scanner input = new Scanner(new File("haircut.in"));
        PrintWriter out = new PrintWriter(new FileWriter("haircut.out"));
        int n = input.nextInt();
        store[] nums = new store[n];
        bit = new long[2 * n];
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < n; i++) {
            nums[i] = new store(input.nextInt(), i);
        }
        long[] inversions = new long[n];
        for(int i = 0; i < n; i++) {
            int temp = nums[i].value;
            if(map.containsKey(temp)) {
                map.put(temp, map.get(temp) + 1);
            } else map.put(temp, 1);
            update(temp);
            inversions[i] = get(temp) - map.get(temp);
        }
        Arrays.sort(nums);
        long cur = 0;
        int pos = 0;
        for(int i = 0; i < n; i++) {
            for(int k = pos; k < n; k++) {
                store temp = nums[k];
                if(temp.value < i) {
                    cur += inversions[temp.pos];
                } else {
                    pos = k;
                    break;
                }
            }
            out.println(cur);
        }
        out.close();
    }
}