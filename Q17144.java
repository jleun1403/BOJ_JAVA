import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q17144 {
    static int n, m, arr[][], dx[] = {-1, 1, 0, 0}, dy[] = {0, 0, -1, 1};
    public static void goup(int x){
            
    }
    public static void godown(int x){

    }
    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        int time = Integer.parseInt(st.nextToken());
        int curx = 0;
        arr= new int[n][m];
        for(int i=0; i<n ;i++){
            int cnt =0;
            st = new StringTokenizer(br.readLine());
            while(st.hasMoreElements()){
                int a = Integer.parseInt(st.nextToken());
                arr[i][cnt] = a;
                if(a==-1) curx  = i;
                cnt++;
            }
        }
        int copy[][] = new int[n][n];
        for(int t=0; t<time ; t++) {
            copy = new int[n][n];
            for(int i=0; i<n; i++){
                for(int j=0; j<n; j++){
                    int amount = arr[i][j];
                    int cnt =0;
                    for(int k=0; k<4; k++){
                        int nx = i + dx[k];
                        int ny = j + dy[k];
                        if(nx>=0 && nx<n && ny>=0 && ny<n && arr[nx][ny] !=-1){
                            copy[nx][ny] += arr[i][j]/5;
                            cnt+=1;
                        }
                    }
                    copy[i][j] = arr[i][j] - (arr[i][j]/5 * cnt);
                }
            }
            for(int i=0; i<n; i++){
                for(int j=0; j<n; j++){
                    arr[i][j] = copy[i][j];
                }
            }
            goup(curx - 1);
            godown(curx);
        }

    }
}
