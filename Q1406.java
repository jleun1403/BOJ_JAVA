kimport java.util.*;
import java.io.*;

public class Q1406{
    public static void main(String args[])throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
		int n = Integer.parseInt(br.readLine());
        Stack left = new Stack <>();
        Stack right = new Stack <>();
        for(int i=0; i<s.length(); i++){
            left.push(s.charAt(i));
        }
        for(int i=0; i<n; i++){
            String temp []= br.readLine().split(" ");
            if(temp[0].equals("L")){
                if(!left.empty()){
                    right.push(left.pop());
                   // left.pop();
                }
            }
            else if(temp[0].equals("D")){
                if(!right.empty()){
                    left.push(right.pop());
                    //right.pop();
                }

            }
            else if(temp[0].equals("B")){
                if(!left.empty()){
                    left.pop();
                }
            }
            else if(temp[0].equals("P")){
                left.push(temp[1]);
            }
        }
        String leftanswer = "";
        String rightanswer = "";
        while(!left.empty()){
            right.push(left.peek());
            left.pop();
        }
        while(!right.empty()){
            System.out.printf("%s",right.pop());
        }
        System.out.println(leftanswer+rightanswer);
       // System.out.println(rightanswer);
    }
}