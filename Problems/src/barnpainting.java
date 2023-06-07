import java.util.*;
import java.io.*;
import java.awt.*;

public class barnpainting {
    public static class store{
        long one;
        long two;
        long three;
        store(long one, long two, long three) {
            this.one = one;
            this.two = two;
            this.three = three;
        }
    }
    static store[] barns;
    static long mod = 1000000007;
    public static store dfs(int source, int parent, int n, ArrayList<Integer>[] edgeList) {
        for(Integer k : edgeList[source]) {
            if(k == parent) {
             continue;
            }
            store temp = dfs(k, source, n, edgeList);
            barns[source].one *= (temp.two + temp.three) % mod;
            barns[source].two *= (temp.one + temp.three) % mod;
            barns[source].three *= (temp.one + temp.two) % mod;
            barns[source].one %= mod;
            barns[source].two %= mod;
            barns[source].three %= mod;
        }
        return barns[source];
    }
    public static void main(String[] args) throws IOException{
        Scanner input = new Scanner(new File("barnpainting.in"));
        PrintWriter out = new PrintWriter(new File("barnpainting.out"));
        int n = input.nextInt();
        int k = input.nextInt();
        ArrayList<Integer>[] edgeList = new ArrayList[n + 1];
        for(int i = 0; i <= n; i++) {
            edgeList[i] = new ArrayList<>();
        }
        for(int i = 0; i < n - 1; i++) {
            int from = input.nextInt();
            int to = input.nextInt();
            edgeList[from].add(to);
            edgeList[to].add(from);
        }
        barns = new store[n + 1];
        for(int i = 1; i <= n; i++) {
            barns[i] = new store(1, 1, 1);
        }
        for(int i = 0; i < k; i++) {
            int barn = input.nextInt();
            int color = input.nextInt() - 1;
            barns[barn] = new store((color == 0 ? 1 : 0), (color == 1 ? 1 : 0), (color == 2 ? 1 : 0));
        }
        store result = dfs(1, 0, n, edgeList);
        out.println((result.one + result.two + result.three) % mod);
        out.close();
    }
}