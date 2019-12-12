import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q1520 {
    static int dx[] = {0, 0, -1 ,1 }, dy[] = {1, -1, 0, 0}, n, m, arr[][], d[][];
    static int go(int x, int y) {
        if(x == n-1 && y == m-1) return 1;
        if(d[x][y] >=0) return d[x][y];
        d[x][y] = 0;
        for(int k=0; k<4; k++) {
            int nx = x + dx[k];
            int ny = y + dy[k];
            if(nx>=0 && nx<n && ny>=0 && ny<m) {
                if(arr[nx][ny] < arr[x][y]) {
                    d[x][y] += go(nx,ny);
                }
            }
        }
        return d[x][y];
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n][m];
        d = new int[n][m];
        for(int i=0; i<n; i++) {
            Arrays.fill(d[i], -1);
        }
        int answer=0;
        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        System.out.println(go(0,0));
    }

}
