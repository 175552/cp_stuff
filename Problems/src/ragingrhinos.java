import java.util.*;
import java.io.*;
import java.awt.*;

public class ragingrhinos {
    public static class rhino{
        int value;
        int direction;
        rhino(int value, int direction) {
            this.value = value;
            this.direction = direction;
        }
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int[] values = new int[n];
        int[] direction = new int[n];
        for(int i = 0; i < n; i++) {
            values[i] = input.nextInt();
            direction[i] = input.nextInt();
        }
        ArrayList<rhino> result = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            if(direction[i] == 0) {
                result.add(new rhino(values[i], direction[i]));
            } else break;
        }
        Deque<rhino> right = new LinkedList<>();
        Deque<rhino> left = new LinkedList<>();
        for(int i = 0; i < n; i++) {

        }
    }
}
