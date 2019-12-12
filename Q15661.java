import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q15661 {
    static int n, arr[][], result1[], result2[], answer;
    static boolean check[];
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n= Integer.parseInt(br.readLine());
        arr= new int[n+1][n+1];
        check = new boolean[n+1];
        result1 = new int[n+1];
        result2 = new int[n+1];
        answer= Integer.MAX_VALUE;
        for(int i=1; i<=n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=1; j<=n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for(int i=1; i<=n/2; i++) {
            go(1,0,i);
        }
        System.out.println(answer);

    }
    private static void go(int before, int index, int len) {
        if(index == len) {
            int cnt=0;
            for(int i=1; i<=n; i++) {
                if(!check[i]) {
                    result2[cnt++] = i;
                }
            }
            int sum1=0;
            int sum2=0;
            for(int i=0; i<len-1; i++) {
                for(int j=i+1; j<len; j++) {
                    sum1+=arr[result1[i]][result1[j]];
                    sum1+=arr[result1[j]][result1[i]];
                }
            }
            for(int i=0; i<n-len-1; i++) {
                for(int j=i+1; j<n-len; j++) {
                    sum2+= arr[result2[i]][result2[j]];
                    sum2+=arr[result2[j]][result2[i]];
                }
            }
            answer= Math.min(answer, Math.abs(sum1-sum2));
            return;
        }
        for(int i=before; i<=n; i++) {
            if(!check[i]) {
                check[i] = true;
                result1[index] = i;
                go(i+1,index+1, len);
                check[i] = false;
            }
        }
    }

}
