import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q14502 {
    static int n, m, arr[][], copy[][], result[], dx[] = {-1,1,0,0}, dy[] = {0,0,-1,1}, answer;
    static boolean check[][] ;
    static Position zero[];
    static class Position{
        int x,y;
        public Position(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    public static void dfs(int x, int y){
        check[x][y] = true;
        for(int k=0;k<4; k++){
            int nx = x+ dx[k];
            int ny = y + dy[k];
            if(nx>=0 && nx<n && ny>=0 && ny<m) {
                if (copy[nx][ny] != 1 && !check[nx][ny]) {
                    copy[nx][ny] = 3;
                    dfs(nx, ny);
                }
            }
        }
    }
    public static void go(int index, int visited){
        if(index == 3){
            int cnt=0;
            for(int i=0; i<n; i++){
                for(int j=0; j<m; j++){
                    copy[i][j] = arr[i][j];
                }
            }
            check = new boolean[n][m];
            for(int i=0; i<3;i++){
                copy[zero[result[i]].x][zero[result[i]].y] = 1; // 벽으로 세움
            }
            for(int i=0; i<n; i++){
                for(int j=0; j<m; j++){
                    if(copy[i][j] ==2 && !check[i][j]){
                        dfs(i,j);
                    }
                }
            }
            for(int i=0; i<n; i++){
                for(int j=0; j<m; j++){
                    if(copy[i][j]==0) cnt+=1;
                }
            }
            answer = Math.max(answer,cnt);
            return;
        }
        for(int i=0; i<zero.length; i++){
            if((visited & (1<<i)) == 0) {
                if (index == 0 || (index != 0 && result[index - 1] < i)) {
                    result[index] = i;
                    go(index + 1, visited | (1<<i));
                }
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        result = new int[3];
        arr = new int[n][m];
        copy = new int[n][m];
        check = new boolean[n][m];
        LinkedList<Position> list= new LinkedList<>();
        for(int i=0; i<n; i++){
            int cnt =0;
            st = new StringTokenizer(br.readLine());
            while(st.hasMoreElements()){
                int a = Integer.parseInt(st.nextToken());
                arr[i][cnt] = a;
                if(a ==0) list.add(new Position(i,cnt));
                cnt++;
            }
        }
        zero = new Position[list.size()];
        int size= list.size();
        for(int i=0; i<size; i++){
            zero[i] = list.poll();
        }

        go(0,0);
        System.out.println(answer);
    }
}
