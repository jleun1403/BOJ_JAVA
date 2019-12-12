import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P_network{
    static int n, computers[][];
    static boolean check[];
    public static void dfs(int start){
        check[start] = true;
        for(int i=0; i<n; i++){
            if(computers[start][i]==1 && !check[i]){
                dfs(i);
            }
        }
    }
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        computers = new int[n][n];
        for(int i=0; i<n; i++){
           StringTokenizer st = new StringTokenizer(br.readLine());
           for(int j=0; j<n; j++){
               computers[i][j] = Integer.parseInt(st.nextToken());
           }
        }
        int answer = 0;
        check = new boolean[n];
        for(int i=0; i<n; i++){
            if(!check[i]){
                answer+=1;
                dfs(i);
            }
        }
        System.out.println(answer);
    }
}