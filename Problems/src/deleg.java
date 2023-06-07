import java.util.*;
import java.io.*;
import java.awt.*;

public class deleg {
    public static void insert(int pos, int value) {
        if(parts[pos].containsKey(value)) {
            parts[pos].put(value, parts[pos].get(value) + 1);
        } else {
            parts[pos].put(value, 1);
        }
    }
    public static int dfs(int cur, int parent, ArrayList<Integer>[] edgeList) {
        int sum = 0;
        for(Integer i : edgeList[cur]) {
            if(i == parent) {
                continue;
            }
            int temp = dfs(i, cur, edgeList);
            insert(cur, temp);
            sum += temp;
        }
        insert(cur, n - 1 - sum);
        return sum + 1;
    }
    public static boolean check(int divisor) {
        for(int i = 1; i <= n; i++) {
            HashMap<Integer, Integer> temp = new HashMap<>();
            for(Integer k : parts[i].keySet()) {
                int pls = k % divisor;
                if(pls == 0) {
                    continue;
                }
                if(temp.containsKey(pls)) {
                    temp.put(pls, temp.get(pls) + parts[i].get(k));
                } else {
                    temp.put(pls, parts[i].get(k));
                }
            }
            for(Integer k : temp.keySet()) {
                if(divisor - k == k) {
                    if(temp.get(k) % 2 != 0) {
                        return false;
                    }
                } else {
                    if(!temp.containsKey(divisor - k) || (temp.get(k) + temp.get(divisor - k)) % 2 != 0) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
    static int n;
    static HashMap<Integer, Integer>[] parts;
    public static void main(String[] args) throws IOException {
        //Scanner input = new Scanner(new File("deleg.txt.txt"));
        Scanner input = new Scanner(new File("deleg.in"));
        PrintWriter out = new PrintWriter(new File("deleg.out"));
        n = input.nextInt();
        parts = new HashMap[n + 1];
        for(int i = 1; i <= n; i++) {
            parts[i] = new HashMap<>();
        }
        ArrayList<Integer>[] edgeList = new ArrayList[n + 1];
        for(int i = 1; i <= n; i++) {
            edgeList[i] = new ArrayList<>();
        }
        for(int i = 0; i < n - 1; i++) {
            int from = input.nextInt();
            int to = input.nextInt();
            edgeList[from].add(to);
            edgeList[to].add(from);
        }
        dfs(1, 0, edgeList);
        boolean[] divisors = new boolean[n];
        divisors[1] = true;
        for(int i = 2; i <= Math.sqrt(n); i++) {
            if((n - 1) % i == 0) {
                divisors[i] = true;
            } else divisors[i] = false;
        }
        out.print(1);
        for(int i = 2; i <= n/2; i++) {
            if (divisors[i] && check(i)) {
                out.print(1);
            } else out.print(0);
        }
        for(int i = n/2 + 1; i < n; i++) {
            out.print(0);
        }
        out.println();
        out.close();
    }
}