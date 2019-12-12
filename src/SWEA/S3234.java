import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S3234 {
    static int answer, n, arr[],total;
    static int exponential[] = {1,2,4,8,16,32,64,128,256,512};
    static int factorial [] = {0,1,2,6,24,120,720,5040,40320,362880};

    public static void go (int index, int left, int right, int visited){

        if(index == n){
            answer+=1;
            return ;
        }
        if(left>=total-left){
            answer+=exponential[n-index] * factorial[n-index];
            return;
        }
        for(int i=0; i<n; i++){
            if((visited & (1<<i)) ==0){
                if(left + arr[i] >= right){
                    go(index+1, left+arr[i], right,visited | (1<<i));
                }
                if (left >= right +arr[i]){
                    go(index+1, left, right+arr[i],visited | (1<<i));
                }
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t= Integer.parseInt(br.readLine());

        for(int time =1 ;time<=t; time++){
            n =Integer.parseInt(br.readLine());
            arr= new int[n];

            int cnt =0;
            answer=0;
            total = 0;
            StringTokenizer st = new StringTokenizer(br.readLine());
            while(st.hasMoreElements()) {
                int temp =Integer.parseInt(st.nextToken());
                total +=temp;
                arr[cnt++]= temp;
            }
            go(0,0,0,0);
            System.out.println("#"+time+" "+answer);
        }

    }
}
