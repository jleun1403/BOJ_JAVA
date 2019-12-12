import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q17471 {
    static int n, person[],result1[], result2[], answer;
    static ArrayList<Integer> arr[];
    static boolean check[], check1[],check2[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        person = new int[n+1];
        result1= new int[n+1];
        result2 = new int[n+1];
        answer = Integer.MAX_VALUE;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=1; i<=n; i++){
            person[i] = Integer.parseInt(st.nextToken());
        }
        check = new boolean[n+1];
        arr = new ArrayList[n+1];
        for(int i=1 ;i<=n; i++ ){
            arr[i] = new ArrayList<>();
            st= new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            for(int k=0; k<num; k++) arr[i].add(Integer.parseInt(st.nextToken()));
        }
        for(int i=1; i<=n/2; i++){
            check = new boolean[n+1];
            go(1,0,i);
        }
        if(answer== Integer.MAX_VALUE) answer = -1;
        System.out.println(answer);
    }

    private static void go(int before , int index, int len) {
        if(index == len){
            int cnt=0;
            for(int i=1; i<=n; i++){
                if(!check[i]){
                    result2[cnt++] = i;
                }
            }
//            System.out.println(Arrays.toString(result1));
//            System.out.println(Arrays.toString(result2));
            check1 = new boolean[n+1];
            check2 = new boolean[n+1];
            dfs1(result1[0]);
            dfs2(result2[0]);

            int sum1= 0;
            int sum2= 0;
            if(isok1(len) &&isok2(len)){
                for(int i=0; i<len; i++){
                    sum1+=person[result1[i]];
                }
                for(int i=0; i<n-len; i++){
                    sum2+=person[result2[i]];
                }
                answer= Math.min(Math.abs(sum1-sum2), answer);
            }

            return;
        }
        for(int i= before; i<=n; i++){
            if(!check[i]){
                check[i] = true;
                result1[index] = i;
                go(i+1, index+1, len);
                check[i] = false;
            }
        }
    }

    private static boolean isok2(int len) {
        for(int i=0; i<n-len; i++){
            if(!check2[result2[i]]) return false;
        }
        return true;
    }

    private static boolean isok1(int len) {
        for(int i=0; i<len; i++){
            if(!check1[result1[i]]) return false;

        }
        return true;
    }

    private static void dfs2(int x) {
        check2[x] = true;
        for(int i=0; i<arr[x].size(); i++){
            int n = arr[x].get(i);
            if(!check2[n] && !check[n]){
                dfs2(n);
            }
        }
    }

    private static void dfs1(int x) {
        check1[x] = true;
        for(int i=0; i<arr[x].size(); i++){
            int n = arr[x].get(i);
            if(!check1[n] && check[n]){
                dfs1(n);
            }
        }
    }
}
