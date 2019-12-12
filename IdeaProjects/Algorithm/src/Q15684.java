import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q15684 {
    static int n, m, arr[][],copy[][], result[], answer;
    static boolean check[];
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        arr= new int[n+1][m+1];
        copy= new int[n+1][m+1];
        check = new boolean[(n+1)*(m+1)];
        answer = Integer.MAX_VALUE;
        for(int i=0; i<k; i++){
            st= new StringTokenizer(br.readLine());
            int a= Integer.parseInt(st.nextToken());
            int b= Integer.parseInt(st.nextToken());
            arr[a][b] = 1;
        }
        for(int i=0; i<=3; i++){
            result = new int[i];
            go(1,0,i);

        }
        if(answer == Integer.MAX_VALUE) answer = -1;
        System.out.println(answer);
    }

    private static void go(int before, int index, int cnt) {
        if(index == cnt){
            for(int i=1; i<=n; i++){
                for(int j=1; j<=m; j++){
                    copy[i][j] = arr[i][j];
                }
            }
            for(int i=0; i<cnt; i++){
                int x= result[i]%(m-1)==0?(result[i]/(m-1)):(result[i]/(m-1))+1;
                int y= result[i]%(m-1) ==0? m-1:result[i]%(m-1);
                copy[x][y] = 1;
            }
           if(isok()){
                if(checking()){
                    answer = Math.min(answer,cnt);
                }
           }
            return;
        }
        for(int i=before; i<=n*(m-1); i++){
            int x= i%(m-1)==0?(i/(m-1)):(i/(m-1))+1;
            int y = i%(m-1)==0?m-1:i%(m-1) ;
            if(!check[i] && arr[x][y] ==0 ){
                result[index] = i;
                check[i] = true;
                go(i+1,index+1, cnt);
                check[i] = false;
            }
        }
    }

    private static boolean checking() {
        for(int i=1; i<=m; i++){
            int curx = 1;
            int cury = i;
            while(true) {
                if(curx >n) break;
                if (copy[curx][cury] == 1) {
                    cury += 1;
                    curx+=1;
                }
                else if(cury-1 >=1 && copy[curx][cury-1] == 1){
                    cury -=1;
                    curx +=1;
                }
                else {
                    curx+=1;
                }
            }
            if(cury != i) return false;
        }
        return true;
    }

    private static boolean isok() {
        for(int i=1; i<=n; i++){
            for(int j=1; j<=m-2; j++){
                if(copy[i][j]==1 && copy[i][j+1] == 1) return false;
            }
        }
        return true;
    }
}
