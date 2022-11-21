import java.util.*;
import java.io.*;
public class maxcros {
    public static void main(String[] args) throws IOException{
        Scanner input = new Scanner(new File("maxcross.in"));
        PrintWriter out = new PrintWriter(new FileWriter("maxcross.out"));
        int n = input.nextInt();
        int k = input.nextInt();
        int b = input.nextInt();
        int[] prefix = new int[n + 1];
        for(int i = 0; i < b; i++) {
            int temp = input.nextInt();
            prefix[temp] = 1;
        }
        for(int i = 1; i <= n; i++) {
            prefix[i] = prefix[i - 1] + prefix[i];
        }
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < n - k + 1; i++) {
            min = Math.min(min, prefix[i + k] - prefix[i]);
        }
        out.println(min);
        out.close();
    }
}
