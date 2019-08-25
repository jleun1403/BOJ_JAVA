import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q16234 {
    static int n, low, high, arr[][], d[][], sum, number, change[];
    static boolean found;
    static int dx[] = {-1, 1, 0, 0};
    static int dy[] = {0, 0, -1 ,1};

    public static void go(int x, int y, int mark){
        d[x][y] = mark;
        number+=1;
        sum+= arr[x][y];
        for(int k=0; k<4; k++){
            int nx = x + dx[k];
            int ny = y + dy[k];

            if(nx>=0 && nx<n && ny>=0 && ny<n && d[nx][ny] ==0){
                if(Math.abs(arr[nx][ny] - arr[x][y])>=low && Math.abs(arr[nx][ny]-arr[x][y])<=high){
                    found = true;
                    d[nx][ny] = mark;
                    go(nx,ny,mark);
                }

            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        low = Integer.parseInt(st.nextToken());
        high = Integer.parseInt(st.nextToken());
        arr = new int[n][n];
        d = new int[n][n];
        found = false;
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            int cnt =0;
            while(st.hasMoreElements()){
                arr[i][cnt++] = Integer.parseInt(st.nextToken());
            }
        }
        int answer = 0;
        while(true){
            for(int i=0; i<n; i++){
                for(int j=0; j<n; j++){
                    d[i][j] = 0;
                }
            }
            found = false;
            change = new int[n*n+1];
            int mark =1;
            for(int i=0; i<n; i++){
                for(int j=0; j<n; j++){
                    if(d[i][j] ==0){
                        sum =0;
                        number =0;
                        go(i,j, mark);
                        change[mark] = sum / number;
                        mark++;
                    }
                }
            }
            if(!found) break;
            answer+=1;
            for(int i=0; i<n; i++){
                for(int j=0; j<n; j++){
                    arr[i][j] = change[d[i][j]];
                }
            }
        }
        System.out.println(answer);

    }
}
