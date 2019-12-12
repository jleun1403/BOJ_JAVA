import java.util.*;
import java.io.*;

public class Q1926 {
    static int dx[] = {-1, 1, 0, 0};
    static int dy[] = {0, 0, -1, 1};
    static int arr[][];
    static boolean check[][];
    static int n, m, cnt;
    static int maxnum;

    public static void dfs(int x, int y){
        check[x][y] = true;
        for(int i=0; i<4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];
            
            if(nx >= 0 && nx < n && ny >= 0 && ny < m){
                if(arr[nx][ny] == 1 && check[nx][ny] == false){
                    cnt+=1;
                    dfs(nx,ny);
                }
            }
        }
    }
    public static void main (String [] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s[] = br.readLine().split(" ");
        n = Integer.parseInt(s[0]);
        m = Integer.parseInt(s[1]);
        arr= new int[500][500];
        check = new boolean[500][500];
        for(int i=0; i<n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            for(int j=0; j<m; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int count = 0; // 그림 전체 개수
        cnt = 0;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(arr[i][j] == 1 && check[i][j] == false){
                    count+=1;
                    cnt =1;
                    dfs(i,j);
                }
                if(maxnum < cnt) maxnum =cnt;
            }
        }
        System.out.println(count);
        System.out.println(maxnum);
    }
    
}