import java.util.*;
import java.io.*;
import java.awt.*;

public class B {
    public static void main(String[] args) throws IOException{
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        ArrayList<Point> points = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            int x = input.nextInt();
            int y = input.nextInt();
            points.add(new Point(x, y));
        }
        int max = 0;
        for(int i = 0; i < n; i++) {
            HashMap<Double, Integer> map = new HashMap<>();
            for(int k = 0; k < n; k++) {
                if(k == i) {
                    continue;
                }
                double slope = ((double)(points.get(k).x - points.get(i).x)/(points.get(k).y - points.get(i).y));
                if(!map.containsKey(slope)) {
                    map.put(slope, 1);
                } else map.put(slope, map.get(slope) + 1);
            }
            for(Double d : map.keySet()) {
                max = Math.max(map.get(d), max);
            }
        }
        System.out.println(max + 1);
    }
}