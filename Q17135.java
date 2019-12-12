import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q17135 {
    static class Position{
        int x, y;
        public Position(int x, int y){
            this.x = x;
            this. y = y;
        }
    }
    static int n, m , d, arr[][], result[], copy[][], answer;
    static boolean check[];
    public static boolean all_zero(){
        boolean flag = false;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(copy[i][j] ==1) {
                    flag = true;
                    break;
                }
            }
            if(flag == true){
                break;
            }
        }
        if(flag == true) return false;
        else return true;
    }
    public static int attack(){
        Position list []= new Position[3];
        int cnt = 0;
        while(true){
            if(all_zero()) break;
            for(int k=0; k<3; k++) {
                int num =0;
                int min = Integer.MAX_VALUE;
                Position p = new Position(-1,-1);
                for (int j = 0; j < m; j++) {
                    for (int i = 0; i <n; i++) {
                        if (copy[i][j] ==1 && Math.abs(n-i)+Math.abs(result[k]-j)<=d){
                            if(min > Math.abs(n-i)+Math.abs(result[k]-j)){
                                min = Math.abs(n-i)+ Math.abs(result[k]-j);
                                p.x = i; p.y = j;
                            }
                        }
                    }
                }
                list[k] = p;
            }
            for(int i=0; i<3; i++){
                int curx = list[i].x;
                int cury = list[i].y;
                if(curx==-1 || cury == -1) continue;
                if(copy[curx][cury] == 1) {
                    copy[curx][cury] = 0;
                    cnt+=1;
                }
            }
            for(int i=n-2; i>=0; i--){
                for(int j=0; j<m; j++){
                    copy[i+1][j] = copy[i][j];
                }
            }
            for(int j=0; j<m; j++){
                copy[0][j] = 0;
            }

        }
        return cnt;
    }
    public static void go(int index, int before){
        if(index == 3){
            for(int i=0; i<n; i++) {
                for (int j = 0; j < m; j++) {
                    copy[i][j] = arr[i][j];
                }
            }
            answer = Math.max(answer, attack());
            return;
        }
        for(int i=before; i<m; i++){
            result[index] = i;
            go(index+1, i+1);
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());
        arr = new int[n][m];
        copy = new int [n][m];
        result = new int[3];
        check = new boolean[m];
        answer =0;
        for(int i=0; i<n; i++){
            int cnt =0;
            st = new StringTokenizer(br.readLine());
            while(st.hasMoreElements()){
                arr[i][cnt++] = Integer.parseInt(st.nextToken());
            }
        }
        go(0,0);
        System.out.println(answer);
    }
}
