import java.util.*;
import java.awt.*;
import java.io.*;
public class G {
    public static void main(String[] args) throws IOException{
        Scanner input = new Scanner(System.in);
        HashMap<String, String> dic = new HashMap<>();
        while(input.hasNextLine()) {
            String[] line = input.nextLine().split(" ");
            if(line[0].equals("")) {
                break;
            }
            dic.put(line[1], line[0]);
        }
        while(input.hasNextLine()) {
            String line = input.nextLine();
            if(dic.containsKey(line)) {
                System.out.println(dic.get(line));
            } else System.out.println("eh");
        }
    }
}
