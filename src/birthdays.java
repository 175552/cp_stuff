import java.util.*;
import java.io.*;
import java.awt.*;

public class birthdays {
    public static void main(String[] args) throws IOException {
        Scanner input = new Scanner(System.in);
        //Scanner input = new Scanner(new File("birthdays.in"));
        PrintWriter out = new PrintWriter(new File("birthdays.out"));
        int n = input.nextInt();
        int[] nums = new int[n];
        for(int i = 0; i < n; i++) {
            nums[i] = input.nextInt();
        }
        double prob = 0;
        int tot = n;
        for(int i = 0; i < n; i++) {
            int temp = nums[i];
            double tempprob = Math.log10((365 - i)/365.0);
            boolean over = false;
            for(int k = 1; k < temp; k++) {
                tempprob += Math.log10(tot/365.0);
                over = true;
            }
            if(over) {
                tot--;
            }
            prob += tempprob;
        }
        if(tot != n) {
            prob++;
        }
        System.out.println(prob);
    }
}