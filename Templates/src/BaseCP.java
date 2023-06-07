import java.util.*;
import java.io.*;
import java.awt.*;
public class BaseCP {
    public static int nextInt() {
        return Integer.parseInt(next());
    }
    public static long nextLong() {
        return Long.parseLong(next());
    }
    public static double nextDouble() {
        return Double.parseDouble(next());
    }
    public static String nextLine() throws IOException{
        return br.readLine();
    }
    public static String next() {
        if(st == null || !st.hasMoreTokens()) {
            try{
                st = new StringTokenizer(br.readLine());
            } catch(Exception e) {}
        }
        return st.nextToken();
    }
    static BufferedReader br;
    static StringTokenizer st;
    static BufferedWriter out;
    public static void main(String[] args) throws IOException{
        br = new BufferedReader(new InputStreamReader(System.in));
        out = new BufferedWriter(new OutputStreamWriter(System.out));
        out.close();
    }
}
