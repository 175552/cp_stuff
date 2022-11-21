import java.util.*;
import java.io.*;
import java.awt.*;

public class matrix {
    public static boolean valid(int r, int c, int[][] grid) {
        for(int i = 0; i < r; i++) {
            for(int k = 0; k < c; k++) {
                boolean hor = false;
                boolean ver = false;
                for(int h = 0; h < c; h++) {
                    if(grid[i][h] == 1) {
                        hor = true;
                    }
                }
                for(int h = 0; h < r; h++) {
                    if(grid[h][k] == 1) {
                        ver = true;
                    }
                }
                if(grid[i][k] == 0 && hor && ver) {
                    return false;
                }
            }
        }
        return true;
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int t = input.nextInt();
        for(int i = 0; i < t; i++) {
            int r = input.nextInt();
            int c = input.nextInt();
            input.nextLine();
            int[][] grid = new int[r][c];
            for(int k = 0; k < r; k++) {
                String line = input.nextLine();
                for(int h = 0; h < c; h++) {
                    grid[k][h] = Integer.parseInt(line.substring(h, h + 1));
                }
            }
            if(valid(r, c, grid)) {
                for(int x = 0; x < r; x++) {
                    for(int y = 0; y < c; y++) {
                        if(grid[x][y] != 1) {
                            System.out.print("N");
                            continue;
                        }
                        boolean vert = false;
                        boolean hor = false;
                        for(int h = 0; h < r; h++) {
                            if(h == x) {
                                continue;
                            }
                            if(grid[h][y] == 1) {
                                vert = true;
                            }
                        }
                        for(int h = 0; h < c; h++) {
                            if(h == y) {
                                continue;
                            }
                            if(grid[x][h] == 1) {
                                hor = true;
                            }
                        }
                        if(vert && hor) {
                            System.out.print("I");
                        } else System.out.print("P");
                    }
                    System.out.println();
                }
                System.out.println("----------");
            } else {
                System.out.println("impossible");
                System.out.println("----------");
            }
        }
    }
}
