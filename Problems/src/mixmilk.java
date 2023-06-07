import java.util.*;
import java.io.*;
public class mixmilk{
    public static void main(String[] args) throws IOException{
        Scanner input = new Scanner(new File("mixmilk.in"));
        PrintWriter out = new PrintWriter(new FileWriter("mixmilk.out"));
        int[] capacities = new int[3];
        int[] amounts = new int[3];
        for(int i = 0; i < 3; i++) {
            capacities[i] = input.nextInt();
            amounts[i] = input.nextInt();
        }
        for(int i = 0; i < 100; i++) {
            int cur = i % 3;
            int next = (i + 1) % 3;
            amounts[next] += amounts[cur];
            amounts[cur] = 0;
            if(amounts[next] > capacities[next]) {
                amounts[cur] = amounts[next] - capacities[next];
                amounts[next] = capacities[next];
            }
        }
        out.println(amounts[0]);
        out.println(amounts[1]);
        out.println(amounts[2]);
        out.close();
    }
}