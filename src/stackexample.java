import java.util.*;
public class stackexample {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String line = input.nextLine();
        Stack<String> stack = new Stack<>();
        boolean works = true;
        for(int i = 0; i < line.length(); i++) {
            String temp = line.substring(i, i + 1);
            if(temp.equals("(") || temp.equals("{") || temp.equals("[")) {
                stack.add(temp);
            } else {
                if(stack.isEmpty()) {
                    works = false;
                    break;
                }
                else if((temp.equals(")") && !stack.peek().equals("(")) || (temp.equals("}") && !stack.peek().equals("{")) || (temp.equals("]") & !stack.peek().equals("["))) {
                    works = false;
                    break;
                } else {
                    stack.pop();
                }
            }
        }
        if(!stack.isEmpty()) {
            works = false;
        }
        if(works) {
            System.out.println("YES");
        } else System.out.println("NO");
    }
}
