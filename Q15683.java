import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Q15683 {
    static int n, m, arr[][], answer, result[], copy[][];
    static ArrayList<Position>list;
    static int dx[] = {-1, 0, 1, 0}, dy[] = {0, 1, 0, -1};
    static class Position{
        int x, y, num;
        public Position(int x, int y, int num){
            this.x = x;
            this.y = y;
            this.num = num;
        }
    }
    public static void solve(){
        for(int i=0; i<list.size(); i++){

        }
    }
    public static void go(int index){
        if(index == list.size()){
            for(int i=0; i<n; i++){
                for(int j=0; j<m; j++){
                    copy[i][j] = arr[i][j];
                }
            }
            for(int i=0 ; i<list.size(); i++){
                if(result[i] == 1){

                }
            }
            return;
        }
        for(int i=0; i<list.size(); i++){
            if(list.get(index).num!=5){
                for(int k=0; k<4; k++){
                    result[index] = k;
                }
            }
            else result[index] = 5;
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
        answer=0;
        int cnum = 0;
        list = new ArrayList<>();
        for(int i=0; i<n; i++){
            int cnt =0;
            String s[] = br.readLine().split(" ");
            for(int j=0; j<m; j++){
                arr[i][j] = Integer.parseInt(s[j]);
                if(arr[i][j]>=1 && arr[i][j]<=5) list.add(new Position(i,j, arr[i][j]));
            }
        }
        result = new int[list.size()];
        go(0);
    }
}
