import java.util.*;
import java.io.*;
public class square {
    public static class event implements Comparable<event>{
        int x;
        int y1, y2;
        boolean isLeft;
        event(int x, int y1, int y2, boolean isLeft) {
            this.x = x;
            this.y1 = y1;
            this.y2 = y2;
            this.isLeft = isLeft;
        }
        public int compareTo(event o) {
            if(x == o.x) {
                if(isLeft) {
                    return -1;
                }
                return 1;
            }
            return x - o.x;
        }
    }
    public static class store implements Comparable<store>{
        int y1;
        int y2;
        store(int y1, int y2) {
            this.y1 = y1;
            this.y2 = y2;
        }
        public int compareTo(store o) {
             if(y1 == o.y1) {
                 return y2 - o.y2;
             }
             return y1 - o.y1;
        }
    }
    public static int overlap(store one, store two) {
        return Math.max(0, one.y2 - two.y1);
    }
    public static void main(String[] args) throws IOException{
        Scanner input = new Scanner(new File("squares.in"));
        PrintWriter out = new PrintWriter(new FileWriter("squares.out"));
        int n = input.nextInt();
        int k = input.nextInt();
        event[] events = new event[2 * n];
        for(int i = 0; i < 2 * n; i += 2) {
            int x = input.nextInt();
            int y = input.nextInt();
            events[i] = new event(x - k/2, y - k/2, y + k/2, true);
            events[i + 1] = new event(x + k/2, y - k/2, y + k/2, false);
        }
        Arrays.sort(events);
        TreeSet<store> set = new TreeSet<>();
        set.add(new store(events[0].y1, events[0].y2));
        long height = 0;
        long result = 0;
        for(int i = 1; i < 2 * n; i++) {
            result += height * (events[i].x - events[i - 1].x);
            if(events[i].isLeft) {
                store next = set.higher(new store(events[i].y1, events[i].y2));
                store previous = set.lower(new store(events[i].y1, events[i].y2));
                store cur = new store(events[i].y1, events[i].y2);
                if(next != null) {
                    int temp = overlap(cur, next);
                    if(temp >= 0) {
                        store nextnext = set.higher(next);
                        if(nextnext != null && overlap(cur, nextnext) > 0) {
                            out.println(-1);
                            out.close();
                            return;
                        }
                    }
                    height += temp;
                }
                if(previous != null) {
                    int temp = overlap(previous, cur);
                    if(temp >= 0) {
                        store prevprev = set.lower(previous);
                        if(prevprev != null && overlap(prevprev, cur) > 0) {
                            out.println(-1);
                            out.close();
                            return;
                        }
                    }
                    height += temp;
                }
                set.add(cur);
            } else {
                store next = set.higher(new store(events[i].y1, events[i].y2));
                store previous = set.lower(new store(events[i].y1, events[i].y2));
                store cur = new store(events[i].y1, events[i].y2);
                if(next != null) {
                    int temp = overlap(cur, next);
                    height -= temp;
                }
                if(previous != null) {
                    int temp = overlap(previous, cur);
                    height -= temp;
                }
                set.remove(cur);
            }
        }
        out.println(result);
        out.close();
    }
}
