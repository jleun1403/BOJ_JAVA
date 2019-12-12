import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q17135 {
    static int n, m, dis, arr[][], copy[][], result[],answer;
    static boolean check[];
    static class Position{
        int x, y;
        public Position(int x, int y){
            this.x= x;
            this.y =y;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        dis = Integer.parseInt(st.nextToken());
        arr = new int[n+2][m+1];
        copy = new int[n+2][m+1]; // n+1 번째 줄에는 궁수들.
        check = new boolean[m+1];
        answer=0;
        for(int i=1; i<=n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=1; j<=m; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        result = new int[3];
        go(1,0);
        System.out.println(answer);
    }

    private static void go(int before, int index) {
        if(index ==3){
            if(answer <solve()){
                answer= solve();
            }
            return;
        }
        for(int i= before; i<=m; i++){
            if(!check[i]){
                check[i] = true;
                result[index] = i;
                go(i+1, index+1);
                check[i] =false;
            }
        }
    }

    private static int solve() {
        int sum =0;
        for(int i=1; i<=n; i++){
            for(int j=1; j<=m; j++){
                copy[i][j] = arr[i][j];
            }
        }
        while(true) {
            ArrayList<Position> list = new ArrayList<>();
            for (int k = 0; k < 3; k++) {
                int x = n + 1;
                int y = result[k];
                int minx = -1;
                int miny = -1;
                int mind = Integer.MAX_VALUE;
                for (int j = 1; j <= m; j++) {
                    for (int i = 1; i <= n; i++) {
                        if (copy[i][j] == 1) {
                            int d = Math.abs(i - x) + Math.abs(j - y);
                            if (d <= dis) {
                                if (d < mind) {
                                    mind = d;
                                    minx = i;
                                    miny = j;
                                }
                            }
                        }
                    }
                }
                if (minx != -1 && miny != -1) {
                    list.add(new Position(minx, miny));
                }
            }
            for(int i=0; i<list.size(); i++){
                Position p = list.get(i);
                int x= p.x;
                int y= p.y;
                if(copy[x][y] == 1){
                    copy[x][y] = 0;
                    sum+=1;
                }
            }
            for(int i=n; i>=2; i--){
                for(int j=1; j<=m; j++){
                    copy[i][j] = copy[i-1][j];
                }
            }
            for(int j=1; j<=m; j++){
                copy[1][j] = 0;
            }
            if(isall()) break;
        }
        return sum;
    }
    private static boolean isall() {
        for(int i=1; i<=n; i++){
            for(int j=1; j<=m; j++){
                if(copy[i][j] ==1) return false;
            }
        }
        return true;
    }
}
