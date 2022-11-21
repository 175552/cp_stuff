import java.util.*;
public class bookshlef {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int r = input.nextInt();
        int b = input.nextInt();
        int s = input.nextInt();
        int[] reds = new int[r];
        int[] blues = new int[b];
        for(int i = 0; i < r; i++) {
            reds[i] = input.nextInt();
        }
        for(int i = 0; i < b; i++) {
            blues[i] = input.nextInt();
        }

    }
}
