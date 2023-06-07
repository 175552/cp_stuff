import java.util.*;
public class prob1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n= input.nextInt(), max = 0, times = 0;
        for(int i = 0; i < n; i++) {
            int temp = input.nextInt();
            if(temp > max) { max = temp; times = 1;}
            else if(temp == max) {times++;}
        }
        System.out.println(max + " " + times);
    }
}
