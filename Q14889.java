import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q14889 {
    static int n, arr[][], result[], answer;
    public static int solve(){
        int sum1 =0, sum2=0;
        int result2[] = new int[n/2];
        boolean check[] = new boolean[n];
        int cnt=0;
        for(int i=0; i<n/2; i++) check[result[i]] = true;
        for(int i=0; i<n; i++) {
            if(!check[i]) result2[cnt++] = i;
        }
        for(int i=0; i<n/2-1; i++){
            for(int j=i+1; j<n/2; j++){
                sum1+=arr[result[i]][result[j]] + arr[result[j]][result[i]];
            }
        }
        for(int i=0; i<n/2-1; i++){
            for(int j=i+1; j<n/2; j++){
                sum2+=arr[result2[i]][result2[j]] + arr[result2[j]][result2[i]];
            }
        }
        return Math.abs(sum1-sum2);
    }
    public static void go(int index, int visited){
        if(index== n/2) {
            answer = Math.min(answer,solve());
            return;
        }
        for(int i=0; i<n; i++){
            if((visited & (1<<i))==0){
                if(index==0 || (index!=0 && result[index-1] < i)){
                    result[index] = i;
                    go(index+1, visited | (1<<i));
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n =Integer.parseInt(br.readLine());
        arr = new int[n][n];
        result = new int[n/2];
        answer =Integer.MAX_VALUE;
        for(int i=0; i<n; i++){
            int cnt =0;
            StringTokenizer st = new StringTokenizer(br.readLine());
            while(st.hasMoreElements()){
                arr[i][cnt++] = Integer.parseInt(st.nextToken());
            }
        }
        go(0,0);
        System.out.println(answer);

    }
}
