import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.StringTokenizer;
import java.util.*;
public class ErnestBluepring
{
    public static ArrayList<HashSet<Integer>> map;
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer line = new StringTokenizer(in.readLine());
        int n = Integer.parseInt(line.nextToken());
        int m = Integer.parseInt(line.nextToken());

        map = new ArrayList<>(n+1);
        for (int i = 0; i < n+1; i++){
            HashSet<Integer> set = new HashSet<>();
            set.add(i);
            map.add(set);
        }

        for (int i = 0; i < m; i++) {
            line = new StringTokenizer(in.readLine());
            int u = Integer.parseInt(line.nextToken()), v = Integer.parseInt(line.nextToken());
            HashSet<Integer> one = map.get(u), two = map.get(v);
            if (one.size() < two.size()) {
                two.addAll(one);
                if (two.contains(1) && two.contains(n)) {
                    System.out.println(i+1);
                    return;
                }
                for (int item : one)
                    map.set(item, two);
            }
            else {
                one.addAll(two);
                if (one.contains(1) && one.contains(n)) {
                    System.out.println(i+1);
                    return;
                }
                for (int item : two)
                    map.set(item, one);
            }
        }

        System.out.println(-1);
    }
}