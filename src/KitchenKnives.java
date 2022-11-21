import java.awt.*;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class KitchenKnives
{
    public static Point[] knives;
    public static int k;
    public static long[] memo;

    public static void main(String[] args) throws FileNotFoundException
    {
        Scanner file = new Scanner(System.in);
//        Scanner file = new Scanner(new File("KitchenKnives.in"));
//        System.setOut(new PrintStream(new File("KitchenKnives.out")));
        int n = file.nextInt();
        k = file.nextInt();
        knives = new Point[n];
        for (int i = 0; i < n; i++)
        {
            knives[i] = new Point(file.nextInt(), file.nextInt());
        }
        Arrays.sort(knives, Comparator.comparing(Point::getY));
        memo = new long[n];
        Arrays.fill(memo, -1);
        System.out.println(dp(0));
    }

    public static int binarySearch(int size)
    {
        if (knives[knives.length - 1].y < size)
        {
            return knives.length;
        }
        int low = 0;
        int high = knives.length - 1;
        while (low < high)
        {
            int middle = (low + high) / 2;
            if (knives[middle].y >= size && knives[middle - 1].y < size)
            {
                return middle;
            }
            else if (knives[middle].y < size)
            {
                low = middle + 1;
            }
            else
            {
                high = middle - 1;
            }
        }
        return low;
    }

    public static long dp(int index)
    {
        if (index >= knives.length)
        {
            return 0;
        }
        if (memo[index] != -1)
        {
            return memo[index];
        }
        long result = Math.max(dp(index + 1), dp(Math.max(index + 1,
                binarySearch(knives[index].y + k + 1))) + knives[index].x);
        memo[index] = result;
        return result;
    }
}
