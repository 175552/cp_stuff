import javax.print.attribute.IntegerSyntax;
import java.util.*;
import java.io.*;
import java.awt.*;

public class milkvisits {
    public static class query{
        int index;
        int to;
        int type;
        query(int index, int to, int type) {
            this.index = index;
            this.to = to;
            this.type = type;
        }
    }
    public static void dfs(int n, int source, int parent, ArrayList<Integer>[] edgeList, int[] types) {
        previous[types[source]].add(source);
        for(query q : queries[source]) {
            if(previous[q.type].size() == 0) {
                continue;
            }
            int last = previous[q.type].peek();
            int count = 0;
            if(isAncestor(last, source)) {
                count++;
            }
            if(isAncestor(last, q.to)) {
                count++;
            }
            if(count == 1) {
                results[q.index] = 1;
            } else if(count == 2) {
                int next = tour.get(in[last] + 1);
                if(isAncestor(next, source) && isAncestor(next, q.to)) {

                } else {
                    results[q.index] = 1;
                }
            }
        }
        for(Integer i : edgeList[source]) {
            if(i == parent) {
                continue;
            }
            dfs(n, i, source, edgeList, types);
        }
    }
    public static boolean isAncestor(int a, int b) {
        if(in[a] <= in[b] && end[b] <= end[a]) {
            return true;
        }
        return false;
    }
    static int store;
    static int cals = 0;
    public static void ancestor(int source, int parent, ArrayList<Integer>[] edgeList) {
        in[source] = store++;
        System.out.println(cals);
        cals++;
        for(Integer i : edgeList[source]) {
            if(i == parent) {
                continue;
            }
            ancestor(i, source, edgeList);
        }
        end[source] = store - 1;
    }
    static ArrayList<query>[] queries;
    static int[] results;
    static Stack<Integer>[] previous;
    static ArrayList<Integer> tour;
    static int[] in, end;
    public static void main(String[] args) throws IOException {
        //Scanner input = new Scanner(System.in);
        Scanner input = new Scanner(new File("milkvisits.txt"));
        PrintWriter out = new PrintWriter(new File("milkvisits.out"));
        int n = input.nextInt();
        int m = input.nextInt();
        int[] types = new int[n];
        for(int i = 0; i < n; i++) {
            types[i] = input.nextInt();
        }
        in = new int[n];
        end = new int[n];
        ArrayList<Integer>[] edgeList = new ArrayList[n];
        queries = new ArrayList[n];
        previous = new Stack[n + 1];
        results = new int[m];
        store = 0;
        tour = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            edgeList[i] = new ArrayList<>();
            queries[i] = new ArrayList<>();
            previous[i] = new Stack<>();
        }
        for(int i = 0; i < n - 1; i++) {
            int from = input.nextInt() - 1;
            int to = input.nextInt() - 1;
            edgeList[from].add(to);
            edgeList[to].add(from);
        }
        ancestor(0, -1, edgeList);
        for(int i = 0; i < m; i++) {
            int from = input.nextInt() - 1;
            int to = input.nextInt() - 1;
            int type = input.nextInt();
            queries[from].add(new query(i, to, type));
            queries[to].add(new query(i, from, type));
        }
        dfs(n, 0, -1, edgeList, types);
        for(int i = 0; i < m; i++) {
            System.out.print(results[i]);
        }
        System.out.println();
    }
}