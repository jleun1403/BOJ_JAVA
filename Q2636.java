import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q2636 {
    static int n, m, dx[] = {-1, 1, 0, 0}, dy[] = {0, 0, -1, 1}, arr[][], check[][];

    static void dfs(int x, int y, int cnt) {
        check[x][y] = cnt;
        for(int k=0; k<4; k++) {
            int nx = x + dx[k];
            int ny = y + dy[k];
            if(nx>=0 && nx<n && ny>=0 && ny<m) {
                if(check[nx][ny] == -1 && arr[nx][ny]==0) {
                    dfs(nx,ny,cnt);
                }
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr= new int[n][m];
        int copy[][] = new int[n][m];
        int d[] = new int[10001];
        for(int i=0; i<n; i++) {
            int cnt =0;
            st = new StringTokenizer(br.readLine());
            while(st.hasMoreElements()) {
                int a= Integer.parseInt(st.nextToken());
                arr[i][cnt] = a;
                copy[i][cnt] =a;
                cnt++;
            }
        }
        int time = 0;
        int nsum =0;
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(arr[i][j] ==1) nsum+=1;
            }
        }
        d[0] =nsum;
        while(true) {
            int sum =0;
            time+=1;
            check = new int[n][m];
            for(int i=0; i<n; i++) {
                for(int j=0; j<m; j++) {
                    check[i][j] = -1;
                }
            }
            int cnt = 1;
            for(int i=0; i<n; i++) {
                for(int j=0; j<m; j++) {
                    if(check[i][j]==-1) {
                        if(i==0 && j==0) dfs(i,j,0);
                        else dfs(i,j,cnt++);
                    }

                }
            }
            for(int i=0; i<n; i++) {
                for(int j=0; j<m; j++) {
                    copy[i][j] = arr[i][j];
                }
            }
            for(int i=0; i<n; i++) {
                for(int j=0; j<m; j++) {
                    if(arr[i][j] == 1) {
                        first:
                        for(int k=0; k<4; k++) {
                            int nx= i +dx[k];
                            int ny= j + dy[k];
                            if(nx>=0 && nx<n && ny>=0 && ny<m && check[nx][ny]==0) {
                                copy[i][j] = 0;
                                break first;
                            }
                        }
                    }
                }
            }
            for(int i=0; i<n; i++) {
                for(int j=0; j<m; j++) {
                    arr[i][j] = copy[i][j];
                }
            }
            for(int i=0; i<n; i++) {
                for(int j=0; j<m; j++) {
                    if(copy[i][j] == 1) sum+=1;
                }
            }
            d[time] = sum;
            if(sum ==0) break;

        }
        System.out.println(time);
        System.out.println(d[time-1]);


    }

}
