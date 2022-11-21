import java.util.*;
import java.io.*;
import java.awt.*;
public class buildgates {
    public static void main(String[] args) throws IOException{
        Scanner input = new Scanner(System.in);
        PrintWriter out = new PrintWriter(new FileWriter("gates.out"));
        int n = input.nextInt();
        input.nextLine();
        String line = input.nextLine();
        int[][] map = new int[n][n];
        Point cur = new Point(0, 0);
        for(int i = 0; i < n; i++) {
            switch(line.charAt(i)) {
                case 'N':

            }
        }
    }
}
