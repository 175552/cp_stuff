import java.util.*;
import java.io.*;
import java.awt.*;

public class fcolor {
    public static void merge(int a, int b) {
        a = parent[a];
        b = parent[b];
        if(group[a].size() < group[b].size()) {
            int temp = a;
            a = b;
            b = temp;
        }
        for(Integer i : group[b]) {
            parent[i] = a;
            group[a].add(i);
        }
        for(Integer i : admire[b]) {
            admire[a].add(i);
        }
        admire[b].clear();
        if(admire[a].size() >= 2) {
            queue.add(a);
        }
    }
    static int[] parent;
    static ArrayList<Integer>[] group;
    static Queue<Integer> queue;
    static ArrayList<Integer>[] admire;
    public static void main(String[] args) throws IOException {
        Scanner input = new Scanner(System.in);
        //Scanner input = new Scanner(new File("fcolor.in"));
        PrintWriter out = new PrintWriter(new File("fcolor.out"));
        int n = input.nextInt();
        int m = input.nextInt();
        parent = new int[n];
        queue = new LinkedList<>();
        group = new ArrayList[n];
        admire = new ArrayList[n];
        for(int i = 0; i < n; i++) {
            admire[i] = new ArrayList<>();
            group[i] = new ArrayList<>();
        }
        for(int i = 0; i < m; i++) {
            int to = input.nextInt() - 1;
            int from = input.nextInt() - 1;
            admire[to].add(from);
        }
        for(int i = 0; i < n; i++) {
            parent[i] = i;
            group[i].add(i);
            if(admire[i].size() >= 2) {
                queue.add(i);
            }
        }
        while(!queue.isEmpty()) {
            int temp = queue.remove();
            if(admire[temp].size() < 2) {
                continue;
            }
            int cur = admire[temp].get(admire[temp].size() - 1);
            admire[temp].remove(admire[temp].get(admire[temp].size() - 1));
            if(parent[cur] == parent[admire[temp].get(admire[temp].size() - 1)]) {
                continue;
            }
            merge(cur, admire[temp].get(admire[temp].size() - 1));
        }
        int[] counted = new int[n];
        int total = 0;
        for(int i = 0; i < n; i++) {
            if(counted[parent[i]] == 0) {
                total++;
                counted[parent[i]] = total;
            }
            System.out.println(counted[parent[i]]);
        }
        out.close();
    }
}