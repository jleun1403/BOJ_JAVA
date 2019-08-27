import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S3234 {
    static int n, arr[], total,answer;
    static int fac[]= {0,1,2,6,24,120,720,5040,40320,382880};
    public static void go(int index, int left, int right){
        if(index == n){
            answer+=1;
            return ;
        }
        for(int i=index; i<n; i++){

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
            total =0;
            StringTokenizer st = new StringTokenizer(br.readLine());
            while(st.hasMoreElements()) {
                int temp =Integer.parseInt(st.nextToken());
                arr[cnt++]= temp;
                total+=temp;
            }
            //go(0,0,0, "");
            System.out.println("#"+time+" "+answer);
        }

    }
}
