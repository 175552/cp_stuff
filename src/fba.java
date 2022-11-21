import java.util.*;
import java.io.*;
public class fba {
    public static void main(String[] args) throws IOException{
        Scanner input = new Scanner(System.in);
        PrintWriter output = new PrintWriter(new FileWriter("test1.txt"));
        int t = input.nextInt();
        for(int i = 0; i < t; i++) {
            int n = input.nextInt();
            char[] in = new char[n];
            input.nextLine();
            String line = input.nextLine();
            for(int k = 0; k < n; k++) {
                in[k] = line.charAt(k);
            }
            line = input.nextLine();
            char[] out = new char[n];
            for(int k = 0; k < n; k++) {
                out[k] = line.charAt(k);
            }
            boolean[][] result = new boolean[n][n];
            for(int k = 0; k < n; k++) {
                for(int h = 0; h < n; h++) {
                    if(k < h) {
                        boolean works = true;
                        for(int p = k; p < h; p++) {
                            if(out[p] == 'Y' && in[p + 1] == 'Y') {
                                continue;
                            } else {
                                works = false;
                                break;
                            }
                        }
                        if(works) {
                            result[k][h] = true;
                        }
                    } else if(k > h){
                        boolean works = true;
                        for(int p = k; p > h; p--) {
                            if(out[p] == 'Y' && in[p - 1] == 'Y') {
                                continue;
                            } else {
                                works = false;
                                break;
                            }
                        }
                        if(works) {
                            result[k][h] = true;
                        }
                    } else {
                        result[k][h] = true;
                    }
                }
            }
            output.println("Case #" + (i + 1) + ":");
            for(int k = 0; k < n; k++) {
                for(int h  = 0; h < n; h++) {
                    if(result[k][h]) {
                        output.print("Y");
                    } else output.print("N");
                }
                output.println();
            }
        }
        output.close();
    }
}
