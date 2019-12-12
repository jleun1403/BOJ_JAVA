import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class Q14500 {
    static int N,M;
    static int ans=0;
    static int dir[][] = {{1,0}, {-1,0}, {0,-1}, {0,1}};
    static int map [][];
    static boolean visit[][];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());

        map = new int[N][M];
        visit = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j]=Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                dfs(i,j,0,0);
                check(i,j,0,0);
            }
        }
        System.out.println(ans);
    }
    private static void check(int x, int y, int cnt, int sum) {
        int flag=0;
        for(int i=0;i<4;i++) {
            int nx=x+dir[i][0];
            int ny=y+dir[i][1];
            if(nx<0 || nx>=N || ny<0 || ny>=M) continue;
            flag++;
        }
        if(flag<3) {
            return;
        }
        else if(flag==3) {
            sum+=map[x][y];
            for(int i=0;i<4;i++) {
                int nx=x+dir[i][0];
                int ny=y+dir[i][1];
                if(nx<0 || nx>=N || ny<0 || ny>=M) continue;
                sum+=map[nx][ny];
            }
            ans=Math.max(sum,ans);
            return;
        }
        else if(flag==4) {
            sum+=map[x][y];
            sum+=map[x+1][y];
            sum+=map[x-1][y];
            sum+=map[x][y+1];
            sum+=map[x][y-1];
            for(int i=0;i<4;i++) {
                int temp = sum;
                int nx=x+dir[i][0];
                int ny=y+dir[i][1];
                temp-=map[nx][ny];
                ans=Math.max(temp,ans);
            }
            return;
        }
    }
    private static void dfs(int x, int y, int cnt, int sum) {
        if(cnt==4) {
            ans=Math.max(sum,ans);
            return;
        }
        visit[x][y]=true;
        for(int i=0;i<4;i++) {
            int nx=x+dir[i][0];
            int ny=y+dir[i][1];
            if(nx<0 || nx>=N || ny<0 || ny>=M) continue;
            if(!visit[nx][ny]) {

                dfs(nx,ny,cnt+1,sum+map[x][y]);
            }
        }
        visit[x][y]=false;
    }
}