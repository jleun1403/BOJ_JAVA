import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class J1863{
    static int parent[];
    static int find(int x) {
        if(parent[x] == x) return x;
        else return parent[x] = find(parent[x]);
    }
    static void union(int x , int y) {
        x = find(x);
        y = find(y);
        parent[y] = x;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        parent = new int[n+1];
        boolean check[]= new boolean[n+1];
        for(int i=1; i<=n; i++) {
            parent[i] = i;
        }
        for(int i=0; i<m; i++) {
            st= new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if(find(a)!=find(b)) {
                union(a,b);
//                union(b,a);
            }

        }
        int answer =0;
        for(int i=1; i<=n; i++) {
            if(parent[i] == i) {

                answer+=1;
            }
        }

        System.out.println(answer);
    }

}