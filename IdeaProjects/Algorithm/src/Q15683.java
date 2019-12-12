import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Q15683 {
    static int n, m, cnum, arr[][], answer, result[], copy[][];
    static Position list[];
    static int dx[] = {-1, 0, 1, 0}, dy[] = {0, 1, 0, -1};
    static class Position{
        int x, y, num;
        public Position(int x, int y, int num){
            this.x = x;
            this.y = y;
            this.num = num;
        }
    }
    public static void move(int x, int y, int d){
        int temp = copy[x][y];
        while(true){
            x+= dx[d];
            y+= dy[d];
            if(x>=0 && x<n && y>=0 && y<m && copy[x][y]!=6) copy[x][y] = temp;
            else break;
        }
    }
    public static void solve(){
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                copy[i][j] = arr[i][j];
            }
        }
        for(int i=0; i<cnum; i++){
            int num = list[i].num;
            int x = list[i].x;
            int y = list[i].y;
            if(num ==1){
                move(x,y,result[i]);
            }
            else if(num==2){
                move(x,y,result[i]);
                move(x,y,(result[i]+2)%4);
            }
            else if(num ==3){
                move(x,y,result[i]);
                move(x,y,(result[i]+1)%4);
            }
            else if(num ==4){
                move(x,y,result[i]);
                move(x,y,(result[i]+1)%4);
                move(x,y,(result[i]+3)%4);
            }
            else if(num ==5){
                move(x,y,result[i]);
                move(x,y,(result[i]+1)%4);
                move(x,y,(result[i]+2)%4);
                move(x,y,(result[i]+3)%4);
            }
        }
        int sum =0;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(copy[i][j] == 0) sum+=1;
            }
        }
        answer= Math.min(answer, sum);
    }
    public static void go(int index){
        if(index == cnum){
            solve();
            return;
        }
        for(int i=0; i<4; i++){
            result[index] = i;
            go(index+1);
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n][m];
        copy = new int [n][m];
        answer=Integer.MAX_VALUE;
        cnum = 0;
        list = new Position[8];
        for(int i=0; i<n; i++){
            int cnt =0;
            String s[] = br.readLine().split(" ");
            for(int j=0; j<m; j++){
                arr[i][j] = Integer.parseInt(s[j]);
                if(arr[i][j]>=1 && arr[i][j]<=5) {
                    list[cnum++] = new Position(i,j, arr[i][j]);
                }
            }
        }
        result = new int[cnum];
        go(0);
        System.out.println(answer);
    }
}
