import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q1541 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        String temp= "";
        int firstnum =0;
        boolean check = false;
        for(int i=0; i<s.length(); i++){
            int c = s.charAt(i);
            if(c=='-' || c=='+'){
                check = true;
                firstnum = Integer.parseInt(temp);
                break;

            }
            else{
                temp+=String.valueOf(c-'0');
            }
        }

        int len = String.valueOf(temp).length();
        if(!check) System.out.println(Integer.parseInt(temp));
       // System.out.println(firstnum);
       else {
           temp = "";
            boolean found = false;
            if (s.charAt(len) == '-') found = true;
            else temp = "0";
            for (int i = len + 1; i < s.length(); i++) {
                int c = s.charAt(i);
                if (c == '-') {
                    found = true;
                    firstnum -= Integer.parseInt(temp);
                     System.out.println("- : " + temp);
                    temp = "";
                } else if (c == '+') {
                    if (!found) {
                        //System.out.println(temp);
                        firstnum += Integer.parseInt(temp);
                    } else {
                        // System.out.println(temp);
                        firstnum -= Integer.parseInt(temp);
                    }
                    //list.add(Integer.parseInt(temp));
                    //System.out.println("+:" + temp);
                    temp = "";
                } else {
                    temp += String.valueOf(c - '0');
                }
            }
            if (!found) firstnum += Integer.parseInt(temp);
            else firstnum -= Integer.parseInt(temp);
            //System.out.println(sum);
            System.out.println(firstnum);
        }
    }
}
//35-20-30+40+50