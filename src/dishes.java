import java.util.*;
import java.io.*;
import java.awt.*;

public class dishes {
    public static void main(String[] args) throws IOException {
        //Scanner input = new Scanner(System.in);
        Scanner input = new Scanner(new File("dishes.in"));
        PrintWriter out = new PrintWriter(new File("dishes.out"));
        int n = input.nextInt();
        int[] base = new int[n + 1];
        Stack<Integer>[] stacks = new Stack[n + 1];
        for(int i = 1; i <= n; i++) {
            stacks[i] = new Stack<Integer>();
        }
        int removed = 0;
        int result = 0;
        for(int i = 0; i < n; i++) {
            int temp = input.nextInt();
            if(temp < removed) {
                result = i;
                break;
            }
            for(int k = temp; k >= 1; k--) {
                if(base[k] == 0) {
                    base[k] = temp;
                } else break;
            }
            while(!stacks[base[temp]].isEmpty() && stacks[base[temp]].peek() < temp) {
                removed = stacks[base[temp]].pop();
            }
            stacks[base[temp]].add(temp);
        }
        out.println(result);
        out.close();
    }
}