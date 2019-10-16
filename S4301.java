import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S4301 {
    static int dx[] = {2,0} , dy[] = {0,2};
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t= Integer.parseInt(br.readLine());
        for(int time = 1; time<=t; time++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());
            int answer= 0;
            int arr[][] = new int[n][m];
            for(int i=0; i<n; i++) {
                for(int j=0 ;j<m; j++) {
                    if(arr[i][j] == 0) {
                        arr[i][j] = 1; // 콩심기
                        for(int k=0; k<2; k++) {
                            int nx = i + dx[k];
                            int ny = j + dy[k];
                            if(nx>=0 && nx<n && ny>=0 && ny<m) {
                                arr[nx][ny] = 2; // 콩불가능
                            }
                        }
                    }
                }
            }
            for(int i=0; i<n; i++) {
                for(int j=0; j<m; j++) {
                    if(arr[i][j] == 1) answer+=1;
                }
            }
            System.out.println("#"+time+ " "+answer);
        }
    }

}
