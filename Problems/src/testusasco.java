import java.util.*;
import java.io.*;
import java.awt.*;

public class testusasco {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        Point[] points = new Point[n];
        for(int i = 0; i < n; i++) {
            points[i] = new Point(input.nextInt(), input.nextInt());
        }
        Arrays.sort(points);

    }
}
