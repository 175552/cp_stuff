import java.util.*;
import java.io.*;
import java.awt.*;

public class checkerboard {
    public static void main(String[] args) throws IOException {
        Scanner input = new Scanner(System.in);
        //Scanner input = new Scanner(new File("checkerboard.in"));
        PrintWriter out = new PrintWriter(new File("checkerboard.out"));
        int n = input.nextInt();
        input.nextLine();
        char[][] board = new char[n][n];
        for(int i = 0; i < n; i++) {
            String line = input.nextLine();
            for(int k = 0; k < n; k++) {
                board[i][k] = line.charAt(k);
            }
        }
        boolean correct = true;
        for(int i = 0; i < n; i++) {
            int black = 0;
            int white = 0;
            int tempblack = 0;
            int tempwhite = 0;
            for(int k = 0; k < n; k++) {
                if(board[i][k] == 'B') {
                    tempblack++;
                    if(tempblack == 3) {
                        correct = false;
                    }
                    tempwhite = 0;
                    black++;
                } else {
                    white++;
                    tempwhite++;
                    if(tempwhite == 3) {
                        correct = false;
                    }
                    tempblack = 0;
                }
            }
            if(black != white) {
                correct = false;
            }
        }
        for(int i = 0; i < n; i++) {
            int black = 0;
            int white = 0;
            int tempblack = 0;
            int tempwhite = 0;
            for(int k = 0; k < n; k++) {
                if(board[k][i] == 'B') {
                    tempblack++;
                    if(tempblack == 3) {
                        correct = false;
                    }
                    tempwhite = 0;
                    black++;
                } else {
                    white++;
                    tempwhite++;
                    if(tempwhite == 3) {
                        correct = false;
                    }
                    tempblack = 0;
                }
            }
            if(black != white) {
                correct = false;
            }
        }
        if(correct) {
            System.out.println(1);
        } else System.out.println(0);
    }
}