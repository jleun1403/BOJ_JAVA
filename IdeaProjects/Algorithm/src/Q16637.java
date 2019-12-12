import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Q16637 {
    static int n, result[], maxnum,num,arr[];
    static boolean check[];
    static long answer;
    static ArrayList<Integer> number, sum;
    static ArrayList<Character> operator;
    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        String s = br.readLine();
        result= new int[s.length()/2];
        num = (s.length()-1)/2;
        maxnum = (num)/2;
        number = new ArrayList<>();
        sum = new ArrayList<>();
        operator = new ArrayList<>();
        answer = Long.MIN_VALUE;
        for(int i=0; i<s.length(); i++){
            char c= s.charAt(i);
            if(c-'0'>=0 && c-'0'<=9) {
                number.add(c - '0');
            }
            else operator.add(c);
        }
        for(int i=0; i<s.length()-2; i+=2){
            int cur = s.charAt(i)-'0';
            int next = s.charAt(i+2)-'0';
            char c= s.charAt(i+1);
            if(c=='+'){
                sum.add(cur+next);
            }
            else if(c=='-'){
                sum.add(cur-next);
            }
            else sum.add(cur*next);
        }
        for(int i=0; i<=maxnum; i++){// 추가할 괄호갯수
            check = new boolean[s.length()/2];
            go(0,0,i);
        }
        if(s.length()==1) answer = number.get(0);
        System.out.println(answer);
    }

    private static void go(int before, int index, int cnt) {
        if(index == cnt){
            arr= new int[num];
            for(int i=0; i<cnt; i++){
                arr[result[i]] =1;
            }
            answer = Math.max(answer,calculate());
            return;
        }
        for(int i= before; i<num; i++){
            if(!check[i]){
                if(index==0 || (index!=0 && result[index-1]!=i-1)){
                    check[i] = true;
                    result[index] = i;
                    go(i+1, index+1, cnt);
                    check[i] = false;
                }
                else result[i]=0;
            }
        }

    }

    private static long calculate() {
        long num1 =0, num2=0;
        char c = '.';
        for(int i=0; i<num; i++){
            if(arr[i] == 0){
                c = operator.get(i);
                if(i==0) num1 = number.get(i);
                if(i+1<num && arr[i+1]==1){
                    num2 = sum.get(i+1);
                    i+=1;
//                    System.out.println(num1+" "+num2);
                }
                else num2= number.get(i+1);

                if(c=='+') {
                    num1+=num2;
                }
                else if(c=='-'){
                    num1-=num2;
                }
                else num1*=num2;
            }
            else{
                num1=sum.get(i);
            }
        }
        return num1;
    }
}
