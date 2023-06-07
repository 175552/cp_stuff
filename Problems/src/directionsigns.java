import java.util.*;
import java.io.*;
import java.awt.*;

public class directionsigns {
    public static class sign implements Comparable<sign>{
        int i;
        int type;
        public int compareTo(sign o) {
            return i - o.i;
        }
    }
    static int r, c, n, m;
    static HashMap<Integer, ArrayList<sign>> rowMap, colMap;
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        r = input.nextInt();
        c = input.nextInt();
        n = input.nextInt();
        m = input.nextInt();
    }
}