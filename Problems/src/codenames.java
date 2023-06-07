import java.util.*;
import java.io.*;
import java.awt.*;

public class codenames {
    public static void main(String[] args) throws IOException {
        Scanner input = new Scanner(System.in);
        //Scanner input = new Scanner(new File("codenames.in"));
        PrintWriter out = new PrintWriter(new File("codenames.out"));
        int n = input.nextInt();
        input.nextLine();
        String[] words = new String[n];
        for(int i = 0; i < n; i++) {
            words[i] = input.nextLine();
        }
        ArrayList<Integer>[] dp = new ArrayList[n];
        dp[0] = new ArrayList<>(Arrays.asList(0));
        for(int i = 1; i < n; i++) {
            for(int k = i - 1; k >= 0; k--) {

            }
        }
    }
}