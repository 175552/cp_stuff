import java.util.*;
import java.io.*;
import java.awt.*;

public class uddered {
    public static class state{
        int answer;
        boolean[][] usedbefore;
        boolean[][] usedafter;
        ArrayList<Integer>[] before;
        ArrayList<Integer>[] after;
        state(int answer, boolean[][] usedbefore, boolean[][] usedafter, ArrayList<Integer>[] before, ArrayList<Integer>[] after) {
            this.answer = answer;
            this.usedbefore = usedbefore;
            this.usedafter = usedafter;
            this.before = before;
            this.after = after;
        }
    }
    public static void main(String[] args) throws IOException {
        Scanner input = new Scanner(System.in);
        //Scanner input = new Scanner(new File("uddered.in"));
        PrintWriter out = new PrintWriter(new File("uddered.out"));
        String line = input.nextLine();
        int[] real = new int[line.length()];
        for(int i = 0; i < real.length; i++) {
            real[i] = (int)line.charAt(i) - 97;
        }
        int n = line.length();
        state[] dp = new state[n + 1];
        dp[0] = new state(0, new boolean[26][26], new boolean[26][26], new ArrayList[26], new ArrayList[26]);
        for(int i = 1; i <= n; i++) {
            boolean[] seen = new boolean[26];
            int min = dp[i - 1].answer + 1;
            ArrayList<Integer>[] before = new ArrayList[26];
            ArrayList<Integer>[] after = new ArrayList[26];
            for(int k = 0; k < 26; k++) {
                before[k] = new ArrayList<>();
                after[k] = new ArrayList<>();
            }
            boolean[][] usedbefore = new boolean[26][26];
            boolean[][] usedafter = new boolean[26][26];
            state best = new state(min, usedbefore, usedafter, before, after);
            for(int k = i - 1; k >= 1; k--) {
                int temp = real[k];
                for(int h = k + 1; h <= i; h++) {
                    before[real[h]].add(real[k]);
                    after[real[k]].add(real[h]);
                    if(true) {

                    }
                    usedbefore[real[h]][real[k]] = true;
                    usedafter[real[k]][real[h]] = true;
                }
                if(!seen[temp]) {
                    seen[temp] = true;
                    if(true) {

                    }
                    //min = Math.min(min, dp[k - 1] + 1);
                } else break;
            }
            //dp[i] = min;
        }
        System.out.println(dp[n]);
    }
}