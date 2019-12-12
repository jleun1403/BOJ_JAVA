import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q17472 {
    static int n, m, temp[][], arr[][], islandnum, dx[] = {-1,1,0,0}, dy[] = {0,0,-1,1}, parent[];
    static boolean check[][];
    static ArrayList<Position> list;
    static class Position implements Comparable<Position>{
        int x, y, dis;
        public Position(int x, int y, int dis){
            this.x= x;
            this.y= y;
            this.dis = dis;
        }
        public Position(int x, int y){
            this.x= x;
            this.y= y;
        }

        @Override
        public int compareTo(Position o) {
            return this.dis - o.dis;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        temp= new int[n+1][m+1];
        arr= new int[n+1][m+1];
        int answer = 0;
        list= new ArrayList<>();
        for(int i=1; i<=n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=1; j<=m; j++){
                temp[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        check = new boolean[n+1][m+1];
        int cnt =1;
        for(int i=1; i<=n; i++){
            for(int j=1; j<=m; j++){
                if(temp[i][j] ==1 && !check[i][j]){
                    check[i][j] = true;
                    go(i,j,cnt);
                    cnt+=1;
                }
            }
        }
        islandnum = cnt-1;
        parent = new int[islandnum+1];
        for(int i=1; i<=islandnum; i++) parent[i] = i;

        make();

        Collections.sort(list);
        for(int i=0; i<list.size(); i++){
            Position p = list.get(i);
            int x= p.x;
            int y = p.y;
            int dis = p.dis;
            if(dis<2) continue;
            if(find(x)!=find(y)){
                union(find(x),find(y));
//                System.out.println(x+" "+y+" "+dis);
                answer+=dis;
            }
        }

        boolean flag= false;

        for(int i=1; i<=islandnum-1; i++){
            if(find(i)!=find(i+1)) {
                flag = true;
                break;
            }
        }
        if(flag == true) answer = -1;
        System.out.println(answer);
    }

    private static void  union(int x, int y) {
            parent[x] = y;
    }

    private static int find(int x) {
        if(parent[x] == x) return x;
        else return parent[x]  = find(parent[x]);
    }


    private static void make() {
        for(int k=1; k<=islandnum; k++){
            Queue<Position> q = new LinkedList<>();
            for(int i=1; i<=n; i++){
                for(int j=1; j<=m; j++){
                    if(arr[i][j] == k){
                        q.add(new Position(i,j));
                    }
                }
            }
            int size = q.size();
            for(int i=0; i<size; i++){
                Position p = q.poll();
                int x= p.x;
                int y= p.y;
                for(int t =0; t<4; t++) {
                    int d =0;
                    int nx = x + dx[t];
                    int ny = y + dy[t];
                    while (true) {
                        if (nx < 1 || nx > n || ny < 1 || ny > m || arr[nx][ny] == arr[x][y])  break;
                        if(arr[nx][ny] !=0) {
                            if(arr[nx][ny] > arr[x][y])
                            list.add(new Position(arr[x][y],arr[nx][ny],d));
                            break;
                        }
                        nx+=dx[t];
                        ny+=dy[t];
                        d+=1;
                    }
                }
            }
        }
    }

    private static void go(int x, int y, int cnt) {
        arr[x][y] = cnt;
        for(int i=0; i<4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx>=1 && nx<=n &&ny>=1 && ny<=m){
                if(!check[nx][ny] && temp[nx][ny] == 1){
                    check[nx][ny] = true;
                    go(nx,ny,cnt);
                }
            }
        }
    }
}
