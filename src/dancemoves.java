import java.util.*;
import java.io.*;
import java.awt.*;

public class dancemoves {
    public static class store{
        int pos1;
        int pos2;
        store(int pos1, int pos2) {
            this.pos1 = pos1;
            this.pos2 = pos2;
        }
    }
    public static void main(String[] args) throws IOException {
        Scanner input = new Scanner(System.in);
        //Scanner input = new Scanner(new File("dancemoves.in"));
        PrintWriter out = new PrintWriter(new File("dancemoves.out"));
        int n = input.nextInt();
        int k = input.nextInt();
        int m = input.nextInt();
        store[] swaps = new store[k];
        for(int i = 0; i < k; i++) {
            swaps[i] = new store(input.nextInt(), input.nextInt());
        }
        TreeSet<Integer>[] unique = new TreeSet[n];
        for(int i = 0; i < n; i++) {
            unique[i] = new TreeSet<>();
        }
        int[] array = new int[n];
        for(int i = 0; i < n; i++) {
            array[i] = i;
            unique[array[i]].add(i);
        }
        for(int i = 0; i < m; i++) {
            int cur = i % k;
            int temp1 = array[swaps[cur].pos1];
            int temp2 = array[swaps[cur].pos2];
            unique[temp1].add(swaps[cur].pos2);
            unique[temp2].add(swaps[cur].pos1);
            array[swaps[cur].pos2] = temp1;
            array[swaps[cur].pos1] = temp2;
        }
        for(int i = n - 1; i >= 0; i--) {
            System.out.println(unique[array[i]].size());
        }
    }
}