import java.util.*;
import java.io.*;
import java.awt.*;

public class digitsum {
    public static void main(String[] args) throws IOException {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int m = input.nextInt();
        if(n == 0 && m > 1) {
            System.out.println(-1);
            return;
        }
        String temp = "";
        for(int i = 0; i < m; i++) {
            if(n > 9) {
                temp += "9";
                n -= 9;
            } else {
                temp += n;
                n -= n;
            }
        }
        if(n > 0) {
            System.out.println(-1);
        } else System.out.println(temp);
    }
}