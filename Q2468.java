import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q2468 {
    static int n, answer;
    static int arr[][];
    static boolean check[][];
    static int dx[] = {-1, 1, 0, 0};
    static int dy[] = {0, 0, -1, 1};
    static void go(int x, int y, int k){ // k 초과이면 방문.
        check[x][y] = true;
        for(int i=0; i<4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx>=0 && nx<n && ny>=0 && ny<n){
                if(arr[nx][ny] >k && !check[nx][ny]){
                    go(nx,ny,k);
                }
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n][n];
        answer=1;
        int min = 101;
        int max = 0;
        for(int i=0; i<n; i++){
            int cnt=0;
            StringTokenizer st = new StringTokenizer(br.readLine());
            while(st.hasMoreElements()){
                int a = Integer.parseInt(st.nextToken());
                arr[i][cnt++] = a;
                min = Math.min(min,a);
                max = Math.max(max,a);
            }
        }
        for(int k=min; k<=max; k++){
            check = new boolean[n][n];
            int cnt = 0;
            for(int i=0; i<n; i++){
                for(int j=0; j<n; j++){
                    if(arr[i][j] > k && !check[i][j]){
                        cnt+=1;
                        go(i,j,k);
                    }
                }
            }
            answer = Math.max(cnt, answer);
        }
        System.out.println(answer);
    }
}
