import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Q1541_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        String temp = "";
        int answer = 0;
        ArrayList<Integer> list= new ArrayList<>();
        ArrayList<Character> op = new ArrayList<>();
        op.add('+');
        for (int i = 0 ; i < s.length(); i++) {
            int c = s.charAt(i);
            if (c == '-' || c=='+') {
                list.add(Integer.parseInt(temp));
                if (c=='-') op.add('-');
                else if(c=='+') op.add('+');
                temp = "";
            }  else {
                temp += String.valueOf(c-'0');
            }
        }
        list.add(Integer.parseInt(temp)); // 마지막 수
        boolean found = false;
        for(int i=0; i<list.size(); i++){
            if(op.get(i)=='-'){
                found = true;
            }
            if(found){
                answer-=list.get(i);
            }
            else{
                answer+=list.get(i);
            }
        }
        System.out.println(answer);
    }
}
