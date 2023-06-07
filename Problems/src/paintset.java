import java.util.*;
import java.io.*;
import java.awt.*;

public class paintset {
    public static void main(String[] args) throws IOException {
        Scanner input = new Scanner(System.in);
        //Scanner input = new Scanner(new File("paintset.in"));
        PrintWriter out = new PrintWriter(new File("paintset.out"));
        int n = input.nextInt();
        int q = input.nextInt();
        int[] set = new int[n];
        input.nextLine();
        String line = input.nextLine();
        for(int i = 0; i < n; i++) {
            set[i] = (int)line.charAt(i) - 65;
        }
        int[] prefix = new int[n];
        int[] suffix = new int[n];
        int[] lastseen = new int[26];
        Arrays.fill(lastseen, -1);
        prefix[0] = 1;
        lastseen[set[0]] = 0;
        for(int i = 1; i < n; i++) {
            int temp = set[i];
            prefix[i] = prefix[i - 1];
            if(lastseen[temp] == -1) {
                 prefix[i]++;
            } else {
                int cur = lastseen[temp];
                boolean need = false;
                for(int k = 0; k < temp; k++) {
                    if(lastseen[k] == -1) {
                        continue;
                    }
                    if(lastseen[k] > cur) {
                        need = true;
                        break;
                    }
                }
                if(need) {
                    prefix[i]++;
                }
            }
            lastseen[temp] = i;
        }
        Arrays.fill(lastseen, -1);
        suffix[n - 1] = 1;
        lastseen[set[n - 1]] = n - 1;
        for(int i = n - 2; i >= 0; i--) {
            int temp = set[i];
            suffix[i] = suffix[i + 1];
            if(lastseen[temp] == -1) {
                suffix[i]++;
            } else {
                int cur = lastseen[temp];
                boolean need = false;
                for(int k = 0; k < temp; k++) {
                    if(lastseen[k] == -1) {
                        continue;
                    }
                    if(lastseen[k] < cur) {
                        need = true;
                        break;
                    }
                }
                if(need) {
                    suffix[i]++;
                }
            }
            lastseen[temp] = i;
        }
        for(int i = 0; i < q; i++) {
            int a = input.nextInt() - 1;
            int b = input.nextInt() - 1;
            int sum = 0;
            if(a != 0) {
                sum += prefix[a - 1];
            }
            if(b != n - 1) {
                sum += suffix[b + 1];
            }
            System.out.println(sum);
        }
        for(Integer i : prefix) {
            System.out.print(i);
        }
        System.out.println();
        for(Integer i : suffix) {
            System.out.print(i);
        }
        System.out.println();
    }
}