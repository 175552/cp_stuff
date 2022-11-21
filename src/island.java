import java.util.*;
import java.io.*;
import java.awt.*;

public class island {
    public static class store{
        int from;
        int to;
        store(int from, int to) {
            this.from = from;
            this.to = to;
        }
    }
    static ArrayList<store>[] depth;
    public static void dfs(int prev, int cur, int num, ArrayList<Integer>[] edgeList) {
        depth[num].add(new store(prev, cur));
        for(Integer i : edgeList[cur]) {
            if(i == prev) {
                continue;
            }
            dfs(cur, i, num + 1, edgeList);
        }
    }
    public static void main(String[] args) throws IOException {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        ArrayList<Integer>[] edgeList = new ArrayList[n + 1];
        depth = new ArrayList[n + 1];
        for(int i = 0; i <= n; i++) {
            edgeList[i] = new ArrayList<>();
            depth[i] = new ArrayList<>();
        }
        for(int i = 0; i < n - 1; i++) {
            int from = input.nextInt();
            int to = input.nextInt();
            edgeList[from].add(to);
            edgeList[to].add(from);
        }
        dfs(0, 1, 0, edgeList);
        ArrayList<store> stuff = new ArrayList<>();
        for(int i = depth.length - 1; i > 0; i--) {
            for(store s : depth[i]) {
                System.out.println(s.from + " " + s.to);
            }
        }
        for(int i = 1; i < depth.length; i++) {
            for(store s : depth[i]) {
                System.out.println(s.to + " " + s.from);
            }
        }
    }
}