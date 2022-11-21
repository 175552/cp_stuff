import java.util.*;
import java.io.*;
import java.awt.*;

public class cowmbat {
    public static void main(String[] args) throws IOException {
        //Scanner input = new Scanner(System.in);
        Scanner input = new Scanner(new File("cowmbat.in"));
        PrintWriter out = new PrintWriter(new File("cowmbat.out"));
        int n = input.nextInt();
        int m = input.nextInt();
        int k = input.nextInt();
        input.nextLine();
        String line = input.nextLine();
        int[] real = new int[line.length()];
        for(int i = 0; i < line.length(); i++) {
            real[i] = (int)line.charAt(i) - 97;
        }
        int[][] transform = new int[m][m];
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < m; j++) {
                transform[i][j] = input.nextInt();
            }
        }
        for(int x = 0; x < m; x++) {
            for(int y = 0; y < m; y++) {
                for(int z = 0; z < m; z++) {
                    if(transform[y][x] + transform[x][z] < transform[y][z]) {
                        transform[y][z] = transform[y][x] + transform[x][z];
                    }
                }
            }
        }
        int[][] prefix = new int[n + 1][m];
        for(int i = 1; i <= n; i++) {
            for(int j = 0; j < m; j++) {
                prefix[i][j] = prefix[i - 1][j] + transform[real[i - 1]][j];
            }
        }
        int[][] dp = new int[n + 1][m];
        for(int i = 0; i <= n; i++) {
            for(int j = 0; j < m; j++) {
                dp[i][j] = 1000000000;
            }
        }
        int[] min = new int[n + 1];
        Arrays.fill(min, Integer.MAX_VALUE);
        min[0] = 0;
        for(int i = 1; i <= n; i++) {
            for(int j = 0; j < m; j++) {
                dp[i][j] = Math.min(dp[i][j], dp[i - 1][j] + transform[real[i - 1]][j]);
                if(i >= k) {
                    dp[i][j] = Math.min(dp[i][j], min[i - k] + prefix[i][j] - prefix[i - k][j]);
                }
                min[i] = Math.min(min[i], dp[i][j]);
            }
        }
        out.println(min[n]);
        out.close();
    }
}