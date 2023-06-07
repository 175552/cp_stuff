import java.util.*;
import java.io.*;
import java.awt.*;

public class moonandumbrella {
    public static void main(String[] args) throws IOException {
        Scanner input = new Scanner(System.in);
        int t = input.nextInt();
        input.nextLine();
        for(int i = 0; i < t; i++) {
            String[] line = input.nextLine().split(" ");
            int x = Integer.parseInt(line[0]);
            int y = Integer.parseInt(line[1]);
            String s = line[2];
            int cost = 0;
            int start = s.length();
            int end = 0;
            for(int k = 0; k < s.length(); k++) {
                if(!s.substring(k, k + 1).equals("?")) {
                    start = k;
                    break;
                }
            }
            for(int k = s.length() - 1; k >= 0; k--) {
                if(!s.substring(k, k + 1).equals("?")) {
                    end = k;
                    break;
                }
            }
            boolean started = false;
            char temp = ' ';
            for(int k = start + 1; k <= end; k++) {
                if(s.substring(k, k + 1).equals("?") && !s.substring(k - 1, k).equals("?")) {
                    started = true;
                    temp = s.charAt(k - 1);
                }
                if(s.substring(k - 1, k).equals("?") && !s.substring(k, k + 1).equals("?") && started) {
                    if(temp == 'C' && s.charAt(k) == 'J') {
                        cost += x;
                    } else if(temp == 'J' && s.charAt(k) == 'C'){
                        cost += y;
                    }
                    started = false;
                }
                if(!s.substring(k - 1, k).equals("?") && !s.substring(k, k + 1).equals("?") && !s.substring(k - 1, k).equals(s.substring(k, k + 1))) {
                    if(s.substring(k - 1, k).equals("C")) {
                        cost += x;
                    } else cost += y;
                }
            }
            System.out.println("Case #" + (i + 1) + ": " + cost);
        }
    }
}