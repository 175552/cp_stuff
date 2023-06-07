import java.io.*;
import java.util.*;
import java.awt.*;
public class grazingarea {
    public static class vertical implements Comparable<vertical>{
        boolean isStart;
        int x;
        int y;
        int num;
        vertical(int num, int x, int y, boolean isStart) {
            this.num = num;
            this.x = x;
            this.y = y;
            this.isStart = isStart;
        }
        public int compareTo(vertical o) {
            if(x == o.x) {
                return y - o.y;
            }
            return x - o.x;
        }
    }
    public static class horizontal implements Comparable<horizontal> {
        boolean isStart;
        int x;
        int y;
        int num;
        horizontal(int num, int x, int y, boolean isStart) {
            this.num = num;
            this.x = x;
            this.y = y;
            this.isStart = isStart;
        }
        public int compareTo(horizontal o) {
            if(y == o.y) {
                return x - o.x;
            }
            return y - o.y;
        }
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int m = input.nextInt();
        int k = input.nextInt();
        TreeSet<vertical> v = new TreeSet<>();
        TreeSet<horizontal> h = new TreeSet<>();
        ArrayList<Integer> xs = new ArrayList<>();
        ArrayList<Integer> ys = new ArrayList<>();
        xs.add(0);
        ys.add(0);
        xs.add(1);
        ys.add(1);
        xs.add(n);
        ys.add(m);
        for(int i = 0; i < k; i++) {
            Point start = new Point(input.nextInt(), input.nextInt());
            Point end = new Point(input.nextInt(), input.nextInt());
            xs.add(start.x);
            xs.add(end.x);
            ys.add(start.y);
            ys.add(end.y);
            if(start.x == end.x) {
                v.add(new vertical(i, start.x, start.y, true));
                v.add(new vertical(i, end.x, end.y, false));
            } else {
                h.add(new horizontal(i, start.x, start.y, true));
                h.add(new horizontal(i, end.x, end.y, false));
            }
        }
        Collections.sort(xs);
        Collections.sort(ys);
        HashMap<Integer, Integer> xre = new HashMap<>();
        HashMap<Integer, Integer> yre = new HashMap<>();
        for(int i = 0; i < xs.size(); i++) {
            xre.put(i, xs.get(i));
        }
        for(int i = 0; i < ys.size(); i++) {
            yre.put(i, ys.get(i));
        }
        boolean[][] visited = new boolean[xs.size()][ys.size()];
        int area = 0;
        Point start = new Point(1, 1);
        Queue<Point> queue = new LinkedList<>();
        queue.add(start);
        while(!queue.isEmpty()) {
            Point temp = queue.remove();
            if(!visited[temp.x][temp.y + 1]) {
                horizontal left = h.lower(new horizontal(-1, xre.get(temp.x), yre.get(temp.y + 1), false));
                horizontal right = h.higher(new horizontal(-1, temp.x, temp.y + 1, false));
                if((left != null & right != null) && (left.x == temp.x || right.x == temp.x || (left.isStart && !right.isStart))) {
                    area += (yre.get(temp.y + 1) - yre.get(temp.y) - 1) * (xre.get(temp.x) - xre.get(temp.x - 1));
                } else {
                    area += (yre.get(temp.y + 1) - yre.get(temp.y)) * (xre.get(temp.x) - xre.get(temp.x - 1));
                    queue.add(new Point(temp.x, temp.y + 1));
                    visited[temp.x][temp.y + 1] = true;
                }
            }
            if(!visited[temp.x + 1][temp.y]) {
                vertical left = v.lower(new vertical(-1, temp.x + 1, temp.y, false));
                vertical right = v.lower(new vertical(-1, temp.x + 1, temp.y, false));
                if((left != null && right != null) && (left.y == temp.y || right.y == temp.y || (left.isStart && !right.isStart))) {

                }
            }
        }
    }
}