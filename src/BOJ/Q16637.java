import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Q16637 {
    static int n, num[], result[], sum[];
    static long answer;
    static String s;
    static char op[];
    static boolean check[];
    public static int calc(){
        int cur = 0;
        int start = 0;
        if(check[0]){ // 첫번째가 괄호인경우
            cur = sum[0];
            start = 1;
        }
        else{ // 괄호가 아닌 경우
            cur = num[0];
            start = 0;
        }
        for(int i=start; i<op.length; i++){
            if(i!= op.length-1 && check[i+1] == true) { // 다음이 괄호인경우
                if (op[i] == '+') {
                    cur += sum[i + 1];
                } else if (op[i] == '*') {
                    cur *= sum[i + 1];
                } else if (op[i] == '-') {
                    cur -= sum[i + 1];
                }
                i++; // 연산자 하나 건너뛰기
            }
            else{
                if (op[i] == '+') {
                    cur += num[i + 1];
                } else if (op[i] == '*') {
                    cur *= num[i + 1];
                } else if (op[i] == '-') {
                    cur -= num[i + 1];
                }
            }

        }
        return cur;
    }
    public static void go(int index,int before, int cnt){
        if(index == cnt){
            //System.out.println(Arrays.toString(result));
            answer= Math.max(answer,calc());
            return;
        }
        for(int i=before; i<op.length; i++){
            if(index ==0 || (index !=0 && result[index-1]+1 !=i)) { // 연속해서 괄호를 선택하지 않도록.
                result[index] = i;
                check[i] = true;
                go(index + 1, i + 1, cnt);
                check[i] = false;
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        s = br.readLine();
        num= new int[(n+1)/2];
        op= new char[(n-1)/2];
        check = new boolean[(n-1)/2];
        result= new int[(n-1)/2];
        sum = new int[(n-1)/2];
        answer = Long.MIN_VALUE;
        int numc =0, opc= 0;
        // 숫자 배열, 연산자 배열 나누기.
        if(n==1){
            System.out.println(s);
            System.exit(0);
        }
        for(int i=0; i<n; i++){
            char c = s.charAt(i);
            if(c-'0'>=0 && c-'0'<=9){
                num[numc++] = c-'0';
            }
            else op[opc++] = c;
        }
        for(int i=0; i<(n-1)/2; i++){
            if(op[i] == '+'){
                sum[i] = num[i]+num[i+1];
            }
            else if(op[i] == '*'){
                sum[i] = num[i]*num[i+1];
            }
            else if(op[i] == '-'){
                sum[i] = num[i]-num[i+1];
            }
        }
        // 괄호 가능한 경우 배열 만들기
        for(int i=0; i<=(n-1)/4; i++){ // i개의 괄호를 사용한 경우.
            go(0,0,i);
        }
        System.out.println(answer);
    }
}
