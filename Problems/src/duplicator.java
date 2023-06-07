import java.util.*;
import java.io.*;
import java.awt.*;

public class duplicator {
    public static class store{
        int num = 0;
        TreeSet<Integer> set;
        store(TreeSet<Integer> set) {
            this.set = set;
        }
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int[] a = new int[n];
        int[] b = new int[n];
        for(int i = 0; i < n; i++) {
            a[i] = input.nextInt();
            b[i] = input.nextInt();
        }
        HashMap<Integer, store> map1 = new HashMap<>();
        HashMap<Integer, store> map2 = new HashMap<>();
        for(int i = 0; i < n; i++) {
            int temp = a[i];
            if(!map1.containsKey(temp)) {
                map1.put(temp, new store(new TreeSet<Integer>(Arrays.asList(i))));
            } else {
                map1.get(temp).set.add(i);
            }
        }
        for(int i = 0; i < n; i++) {
            int temp = b[i];
            if(!map2.containsKey(temp)) {
                map2.put(temp, new store(new TreeSet<Integer>(Arrays.asList(i))));
            } else {
                map2.get(temp).set.add(i);
            }
        }
        boolean[] used = new boolean[n];
        for(int i = 0; i < n; i++) {

        }
    }
}
