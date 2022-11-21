import java.util.*;
import java.awt.*;
public class E {
    public static int modInverse(int a, int m) {
        return power(a, m - 2, m);
    }

    public static int power(int x, int y, int m) {
        if (y == 0) {
            return 1;
        }
        int p = power(x, y / 2, m) % m;
        p = (int)((p * (long)p) % m);
        if (y % 2 == 0) {
            return p;
        } else {
            return (int) ((x * (long) p) % m);
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int m = input.nextInt();
        int l = input.nextInt();
        int r = input.nextInt();
        int[] store = new int[n + r + 1];
        Arrays.fill(store, 1);
        long mod = 1000000007;
        for(int i = 0; i < m; i++) {
            int temp = input.nextInt() - 1;
            store[temp] = 0;
        }
        Queue<Integer> window = new LinkedList<>();
        int total = 0;
        for(int i = l; i <= r; i++) {
            window.add(store[i]);
            total += store[i];
        }
        int[] dp = new int[n + r + 1];
        for(int i = 0; i < n; i++) {
            dp[i] = total;
            total -= window.remove();
            total += dp[r + i];
            window.add(store[r + i]);
        }
        for(int i = 0; i < n; i++) {
            System.out.println(dp[i]);
        }
    }
}
