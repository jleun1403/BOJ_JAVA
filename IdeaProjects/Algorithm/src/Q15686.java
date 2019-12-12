import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q15686 {
    static int n, max, arr[][],chicken,result[],answer,dx[] = {-1,1,0,0}, dy[] ={0,0,-1,1};
    static boolean check[];
    static ArrayList<Position>list;
    static class Position{
        int x, y;
        public Position(int x, int y){
            this.x= x;
            this.y= y;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        max = Integer.parseInt(st.nextToken());
        arr= new int[n+1][n+1];

        list = new ArrayList<>();
        result = new int[max];
        for(int i=1; i<=n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=1; j<=n; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
                if(arr[i][j] == 2) {
                    list.add(new Position(i,j));
                }
            }
        }
        answer = Integer.MAX_VALUE;
        chicken = list.size();
        check = new boolean[chicken];
        go(0,0);
        System.out.println(answer);
    }

    private static void go(int before, int index) {
        if(index == max){
            answer = Math.min(answer,solve());
            return;
        }
        for(int i=before; i<chicken; i++){
            if(!check[i]){
                check[i] = true;
                result[index] =i;
                go(i+1,index+1);
                check[i] = false;
            }
        }
    }

    private static int solve() {
        int distance = 0;
        Queue<Position> q = new LinkedList<>();
        int d[][] = new int[n+1][n+1];
        for(int i=0; i<max; i++){
            Position p = list.get(result[i]);
            q.add(new Position(p.x,p.y));
            d[p.x][p.y] = 1;
        }
        while(!q.isEmpty()){
            Position p = q.poll();
            int x= p.x;
            int y = p.y;
            for(int i=0; i<4; i++){
                int nx = x+dx[i];
                int ny = y +dy[i];
                if(nx<1 || nx>n ||ny<1|| ny>n) continue;
                if(d[nx][ny] ==0){
                    d[nx][ny] = d[x][y]+1;
                    q.add(new Position(nx,ny));
                }
            }
        }
        for(int i=1; i<=n; i++){
            for(int j=1; j<=n; j++){
                if(arr[i][j]==1) distance +=d[i][j]-1;
            }
        }
        return distance;
    }
}
