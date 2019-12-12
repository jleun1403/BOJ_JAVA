import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Q2617_2 {
    public static ArrayList <Integer> [] low, high;
    public static int n, m;
    public static boolean [] lowcheck, highcheck;
    public static int high_dfs(int index){
        int res= 1;
        for(int i=0; i<high[index].size(); i++){
            int x = high[index].get(i);
            if(!highcheck[x]){
                highcheck[x] = true;
                res += high_dfs(x);
            }
        }
        return res;
    }
    public static int low_dfs(int index){
        int res= 1;
        for(int i=0; i<low[index].size(); i++){
            int x = low[index].get(i);
            if(!lowcheck[x]){
                lowcheck[x] = true;
                res += low_dfs(x);
            }
        }
        return res;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        high= new ArrayList [n+1];
        low= (ArrayList<Integer>[] ) new ArrayList[n+1];
        for(int i=1; i<=n; i++){
            high[i] = new ArrayList<Integer>();
            low[i] = new ArrayList<Integer>();
        }
        int answer = 0;
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()); // b < a
            int b = Integer.parseInt(st.nextToken());
            high[a].add(b);
            low[b].add(a);
        }
        for(int i=1 ; i<=n; i++){
            lowcheck = new boolean[n+1];
            highcheck = new boolean[n+1];
            highcheck[i] = true;
            lowcheck[i] = true;
            if(high_dfs(i)>(n+1)/2 || low_dfs(i)>(n+1)/2)  answer+=1;
        }
        System.out.println(answer);
    }
}
