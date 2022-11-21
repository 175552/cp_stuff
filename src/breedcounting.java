import java.util.*;
import java.io.*;
public class breedcounting {
    public static void main(String[] args) throws IOException{
        Scanner input = new Scanner(new File("bcount.in"));
        PrintWriter out = new PrintWriter(new FileWriter("bcount.out"));
        int n = input.nextInt();
        int q = input.nextInt();
        int[] ids = new int[n];
        for(int i = 0; i < n; i++) {
            ids[i] = input.nextInt();
        }
        int[] h = new int[n + 1];
        int[] g = new int[n + 1];
        int[] j = new int[n + 1];
        for(int i = 1; i <= n; i++) {
            if(ids[i - 1] == 1) {
                h[i] = h[i - 1] + 1;
                g[i] = g[i - 1];
                j[i] = j[i - 1];
            } else if(ids[i - 1] == 2) {
                h[i] = h[i - 1];
                g[i] = g[i - 1] + 1;
                j[i] = j[i - 1];
            } else {
                h[i] = h[i - 1];
                g[i] = g[i - 1];
                j[i] = j[i - 1] + 1;
            }
        }
        for(int i = 0; i < q; i++) {
            int left = input.nextInt();
            int right = input.nextInt();
            out.println((h[right] - h[left - 1] + " " + (g[right] - g[left - 1]) + " " + (j[right] - j[left - 1])));
        }
        out.close();
    }
}
