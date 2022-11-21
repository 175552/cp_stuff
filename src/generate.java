import java.util.*;
import java.io.*;
public class generate {
    public static void main(String[] args) throws IOException{
        Scanner input = new Scanner(System.in);
        PrintWriter out = new PrintWriter(new FileWriter("case.txt"));
        int n = input.nextInt();
        int q = input.nextInt();
        out.println(n + " " + q);
        ArrayList<Integer> nums = new ArrayList<>();
        for(int i = 1; i <= 10000000; i++) {
            nums.add(i);
        }
        Collections.shuffle(nums);
        for(int i = 0; i < n; i++) {
            out.print(nums.get(i) + " ");
        }
        out.println();
        for(int i = n; i < n + q; i++) {
            out.print(nums.get(i) + " ");
        }
        out.close();
    }
}
