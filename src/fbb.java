import java.util.*;
import java.io.*;
public class fbb {
    public static void main(String[] args) throws IOException{
        Scanner input = new Scanner(System.in);
        PrintWriter out = new PrintWriter(new FileWriter("test2.txt"));
        int t = input.nextInt();
        for(int i = 0; i < t; i++) {
            int n = input.nextInt();
            int as = 0;
            int bs = 0;
            int tot = (n - 3)/2 + 1;
            input.nextLine();
            String line = input.nextLine();
            for(int k = 0; k < n; k++) {
                if(line.charAt(k) == 'A') {
                    as++;
                } else bs++;
            }
            out.print("Case #" + (i + 1) + ": ");
            if(Math.min(as, bs) < tot) {
                out.print("N");
            } else out.print("Y");
            out.println();
        }
        out.close();
    }
}
