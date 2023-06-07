import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class jog {

    public static void main(String[] args) throws IOException{
        Scanner input = new Scanner(new File("cowjog.in"));
        PrintWriter out = new PrintWriter(new FileWriter("cowjog.out"));
        int n = input.nextInt();
        int[] speeds = new int[n];
        for(int i = 0; i < n; i++) {
            int pos = input.nextInt();
            speeds[i] = input.nextInt();
        }
        int min = Integer.MAX_VALUE;
        int groups = 0;
        for(int i = n - 1; i >= 0; i--) {
            if(speeds[i] <= min) {
                min = speeds[i];
                groups++;
            }
        }
        out.println(groups);
        out.close();
    }
}