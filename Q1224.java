import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

public class Q1224 {
    public static int small(String s) {
        //String copy = s;
        Deque<String> stack = new LinkedList<String>();
        Stack<String> op = new Stack<String>();
        String temp = "";
        int sum = 0;
        int poly = 1;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c - '0' >= 0 && c - '0' <= 9) {
                temp += String.valueOf(c - '0');
            } else {
                stack.add(temp);
                temp = "";
                op.add(String.valueOf(c));
            }
        }
        stack.add(temp);
        op.add("#");
        for (int i = 0; i < op.size(); i++) {
            String c = op.get(i);
            if (c.equals("#")) {
                if (poly != 1) {
                    {
                        sum += Integer.valueOf(poly) * Integer.valueOf(stack.getFirst());
                        poly = 1;
                        stack.pop();
                    }
                } else {
                    {
                        sum += Integer.valueOf(stack.getFirst());
                        stack.pop();
                    }
                }
            } else if (c.equals("+")) {
                if (poly != 1) {
                    sum += Integer.valueOf(poly) * Integer.valueOf(stack.getFirst());
                    poly = 1;
                    stack.pop();
                } else {
                    sum += Integer.valueOf(stack.getFirst());
                    stack.pop();
                }
            } else {
                poly *= Integer.valueOf(stack.getFirst());
                stack.pop();
            }

        }
        return sum;
    }
    public int calculate(String s) {
        int n = s.length();
        boolean found = false;
        int first = 0;
        for (int i = 0 ; i < n ; i++) {
            if (s.charAt(i) == '(') {
                found = true;
                first = i;
            }
        }
        if (!found) {
            return small(s);
        }
        String ret = "";
        for (int i = 0 ; i < n ; i++) {
            ret += String.valueOf(s.charAt(i));
        }

        return 0;
    }
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int t = 1 ; t <= 10 ; t++)  {
            int n = Integer.parseInt(br.readLine());
            String s = br.readLine();
            System.out.println(small(s));
        }
    }
}
