import java.util.*;
import java.awt.*;
import java.io.*;
public class chapter1 {
    public static class store implements Comparable<store>{
        int num;
        int max;
        int end;

        store(int num, int end, int max) {
            this.num = num;
            this.end = end;
            this.max = max;
        }
        public int compareTo(store o) {
            return end - o.end;
        }
    }
    public static void main(String[] args) throws IOException{
        Scanner input = new Scanner(new File("perimetric_chapter_1_input.txt"));
        PrintWriter out = new PrintWriter(new FileWriter(new File("round1.txt")));
        int t = input.nextInt();
        long mod = 1000000007;
        for(int i = 0; i < t; i++) {
            int n = input.nextInt();
            int k = input.nextInt();
            int w = input.nextInt();
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
            long[] hs = new long[n];
            for (int h = 0; h < k; h++) {
                hs[h] = input.nextInt();
            }
            long[] quadruple2 = new long[4];
            for (int h = 0; h < 4; h++) {
                quadruple2[h] = input.nextInt();
            }
            for (int h = k; h < n; h++) {
                hs[h] = ((quadruple2[0] * hs[h - 2] + quadruple2[1] * hs[h - 1] + quadruple2[2]) % quadruple2[3]) + 1;
            }
            long result = (w + hs[0]) * 2;
            long perim = (w + hs[0]) * 2;
            long right = ls[0] + w;
            for(int h = 1; h < n; h++) {
                if(ls[h] <= right) {
                    boolean found = false;
                    long max = 0;
                    for(int j = h - 1; j >= 0; j--) {
                        if(ls[j] + w >= ls[h]) {
                            if(hs[j] >= hs[h]) {
                                found = true;
                                break;
                            } else {
                                max = Math.max(max, hs[j]);
                            }
                        } else break;
                    }
                    if(!found) {
                        perim += 2 * (hs[h] - max);
                    }
                    perim += 2 * (ls[h] + w - right);
                } else {
                    perim += 2 * (w + hs[h]);
                }
                right = ls[h] + w;
                perim %= mod;
                result *= perim;
                result %= mod;
            }
            out.println("Case #" + (i + 1) + ": " + result);
        }
        out.close();
    }
}
