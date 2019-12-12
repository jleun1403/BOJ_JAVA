import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q15684 {
    static int n, m,k, arr[][], answer, result[],copy[][];
    static boolean check[];
    public static boolean check(){ // 현재의 사다리에서 조건이 성립하는지 확인.
        for(int j=1; j<=n; j++){
            int i = 1; // 행은 1부터 확인
            int curj = j;
            while(true){
                if(i == m+1) break;
                if(copy[i][curj]==1){
                    i++;
                    curj++;
                }
                else if(curj!=1 && copy[i][curj-1] == 1){
                    i++;
                    curj--;
                }
                else i++;

            }
            if(curj != j) return false;
        }
        return true;
    }
    public static void go(int index, int before,int len){
        if(index == len){
            for(int i=1; i<=m; i++){
                for(int j=1; j<=n; j++){
                    copy[i][j] = arr[i][j];
                }
            }
            for(int i=0; i<len; i++){
                int y = result[i] %(n-1)==0 ? n-1: result[i]%(n-1);
                int x = result[i]%(n-1) ==0? result[i]/(n-1) : result[i]/(n-1)+1;
                copy[x][y] = 1;
            }
            if(check()){
                if(answer  > len){
                    answer = len;
                }

            }
            return;
        }
        for(int i=before; i<=(n-1)*m; i++){
            int y = i %(n-1)==0 ? n-1: i%(n-1);
            int x = i%(n-1) ==0? i/(n-1) : i/(n-1)+1;

            if(!check[i] && arr[x][y]==0){
                if(y!=1 && arr[x][y-1] ==1) continue;
                if(y!=n-1 && arr[x][y+1] ==1) continue;
                else{
                    check[i] = true;
                    result[index] = i;
                    go(index + 1, i + 1, len);
                    check[i] = false;
                }
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());

        k = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[m+2][n+1];
        copy = new int[m+2][n+1];
        check = new boolean[(m+1)*(n+1)];
        result = new int[3];
        answer = 4;
        for(int i=0; i<k; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arr[a][b] = 1;
            copy[a][b] = 1;
        }
        // 현재상태에서 가능한지 확인
        if(check()) answer = 0;
        else {
            for(int k=1; k<=3; k++){ //1~3개의 사다리를 놓아봄.
                go(0, 1,k);
                if(answer!=4) break;
            }
        }
        if(answer!=4){
            System.out.println(answer);
        }
        else System.out.println("-1");

    }
}
