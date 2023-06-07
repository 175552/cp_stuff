import java.util.*;
import java.io.*;
public class lifeguards{
    public static void main(String[] args) throws IOException{
        Scanner input = new Scanner(new File("lifeguards.in"));
        PrintWriter out = new PrintWriter(new FileWriter("lifeguards.out"));
        int n = input.nextInt();
        int[] start = new int[n];
        int[] end = new int[n];
        for(int i = 0; i < n; i++) {
            start[i] = input.nextInt();
            end[i] = input.nextInt();
        }
        int[] time = new int[1001];
        for(int i = 0; i < n; i++) {
            for(int k = start[i]; k < end[i]; k++) {
                time[k]++;
            }
        }
        int max = 0;
        for(int i = 0; i < n; i++) {
            for(int k = start[i]; k < end[i]; k++) {
                time[k]--;
            }
            int temp = 0;
            for(int k = 0; k <= 1000; k++) {
                if(time[k] > 0) {
                    temp++;
                }
            }
            max = Math.max(max, temp);
            for(int k = start[i]; k < end[i]; k++) {
                time[k]++;
            }
        }
        out.println(max);
        out.close();
    }
}