import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class S4366 {
    static long bin_to_dec(String s) {
        long n = 0;
        for (int i = s.length() - 1; i >= 0; i--)
        {
            n += (s.charAt(s.length()-1-i) - '0') * Math.pow(2, i);
        }
        return n;
    }
    static String to_dec(String s) {
        long n =0;
        for(int i=s.length()-1; i>=0; i--){
            n+=(s.charAt(s.length()-1-i)-'0') * Math.pow(3, i);
        }
        return Long.toString(n);
    }
    static Long dec_to_3(long n) {
        ArrayList<Long> v = new ArrayList<>();
        while(n!=0){
            v.add(n%3);
            n/=3;
        }
        String str = "";
        for(int i=v.size()-1; i>=0 ; i--){
            str+= Long.toString((v.get(i)));
        }
        return Long.parseLong(str);
    }
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int time = Integer.parseInt(br.readLine());
        for(int t=1; t<=time; t++) {
            String s1 = br.readLine();
            String s2 = br.readLine();
            char arr[] =s1.toCharArray();
            String answer = "";
            ArrayList<Long> list = new ArrayList<>();
            for(int i=0; i<s1.length(); i++) {
                char temp[] = s1.toCharArray();
                if(arr[i]=='0') {
                    temp[i] = '1';
                }
                else {
                    temp[i] = '0';
                }
                String s = "";
                for(int j=0; j<temp.length; j++) {
                    s+=Character.toString(temp[j]);
                }
                list.add(dec_to_3((bin_to_dec(s))));
            }
            for(int i=0; i<list.size(); i++) {
                if(Long.toString(list.get(i)).length()!= s2.length()) continue;
                String t1 = Long.toString(list.get(i));
                int wrong_count=0;
                for(int j=0; j<s2.length(); j++) {
                    if(t1.charAt(j) != s2.charAt(j)) wrong_count+=1;
                }
                if(wrong_count ==1) {
                    answer = t1;
                    break;
                }
            }
            System.out.println("#"+t+" "+to_dec(answer));
        }
    }

}
