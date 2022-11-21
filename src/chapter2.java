import java.util.*;
import java.io.*;
public class chapter2 {
    public static class store implements Comparable<store>{
        long start;
        long width;
        long height;
        store(long start, long width, long height) {
            this.start = start;
            this.width = width;
            this.height = height;
        }
        public int compareTo(store o) {
            if(start < o.start) {
                return -1;
            } else if(start > o.start) {
                return 1;
            } else return 0;
        }
    }
    public static void main(String[] args) throws IOException{
        Scanner input = new Scanner(System.in);
        PrintWriter out = new PrintWriter(new FileWriter(new File("round1.txt")));
        int t = input.nextInt();
        long mod = 1000000007;
        for(int i = 0; i < t; i++) {
            int n = input.nextInt();
            int k = input.nextInt();
            long[] ls = new long[n];
            for (int h = 0; h < k; h++) {
                ls[h] = input.nextInt();
            }
            long[] quadruple1 = new long[4];
            for (int h = 0; h < 4; h++) {
                quadruple1[h] = input.nextInt();
            }
            for (int h = k; h < n; h++) {
                ls[h] = ((quadruple1[0] * ls[h - 2] + quadruple1[1] * ls[h - 1] + quadruple1[2]) % quadruple1[3]) + 1;
            }
            long[] ws = new long[n];
            for (int h = 0; h < k; h++) {
                ws[h] = input.nextInt();
            }
            long[] quadruple2 = new long[4];
            for (int h = 0; h < 4; h++) {
                quadruple2[h] = input.nextInt();
            }
            for (int h = k; h < n; h++) {
                ws[h] = ((quadruple2[0] * ws[h - 2] + quadruple2[1] * ws[h - 1] + quadruple2[2]) % quadruple2[3]) + 1;
            }
            long[] hs = new long[n];
            for (int h = 0; h < k; h++) {
                hs[h] = input.nextInt();
            }
            long[] quadruple3 = new long[4];
            for (int h = 0; h < 4; h++) {
                quadruple2[h] = input.nextInt();
            }
            for (int h = k; h < n; h++) {
                hs[h] = ((quadruple2[0] * hs[h - 2] + quadruple2[1] * hs[h - 1] + quadruple2[2]) % quadruple2[3]) + 1;
            }
            store[] stores = new store[n];
            for(int h = 0; h < n; h++) {
                stores[h] = new store(ls[h], ws[h], hs[h]);
            }
            Arrays.sort(stores);
            long[] contribution = new long[n];
            for(int h = 0; h < n; h++) {

            }
        }
    }
}
