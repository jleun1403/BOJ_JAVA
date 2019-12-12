import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Q3190 {
    static class turn{
        int t;
        String c;
        public turn(int t, String c){
            this.t = t;
            this.c = c;
        }
    }
    static class Position{
        int x, y;
        public Position(int x, int y){
            this.x =x;
            this.y = y;
        }
    }
    static int dx[] = {-1,0,1,0};
    static int dy[] = {0,1,0,-1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int applenum = Integer.parseInt(br.readLine());
        boolean apple[][]= new boolean [n+1][n+1];
        for(int i=0; i<applenum; i++){
            StringTokenizer st= new StringTokenizer(br.readLine());
            int a= Integer.parseInt(st.nextToken());
            int b =Integer.parseInt(st.nextToken());
            apple[a][b] = true;
        }
        boolean check[][] = new boolean[n+1][n+1];
        int answer=0;
        int l = Integer.parseInt(br.readLine());
        turn T[] = new turn[l+1];
        for(int i=0; i<l; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken());
            String c = st.nextToken();
            T[i] = new turn(t,c);
        }
        int curd = 1;
        int curx= 1;
        int cury = 1;
        LinkedList<Position> list= new LinkedList<>();
        T[l] = new turn(100001,"D");
        boolean flag =false;
        list.add(new Position(1,1));
        int time = 0;
        for(int i=0; i<l+1; i++){
            int t = T[i].t;
            String direction = T[i].c;
            while(time<t){
                curx+=dx[curd];
                cury+=dy[curd];
                time+=1;
                if(curx <1 || curx >n || cury<1|| cury>n || check[curx][cury]) { // 자신의 몸 혹은 벽에 부딪히는 경우
                    flag = true;
                    break;
                }
                else if(apple[curx][cury]) {// 사과를 먹는 경우
                    apple[curx][cury] = false; // 사과 먹고
                    list.add(new Position(curx,cury));
                    check[curx][cury] = true;
                }
                else{ // 사과가 없는 경우.
                    list.add(new Position(curx, cury));
                    check[curx][cury ] = true;
                    Position p = list.poll();
                    check[p.x][p.y] = false; // 꼬리 제거
                }
            }
            if(flag == true){
                break;
            }
            if(direction.equals("L")){
                if(curd==0) curd = 3;
                else  curd-=1;

            }
            else{
                if(curd==3) curd =0;
                else curd+=1;
            }
        }
        System.out.println(time);
    }
}
