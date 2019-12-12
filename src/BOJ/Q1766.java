import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q1766 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        ArrayList<Integer> arr[] = new ArrayList[n+1];
        for(int i=1; i<=n; i++) arr[i] = new ArrayList<>();
        int in[] = new int[n+1];
        for(int i=0; i<m; i++){
            st  = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            in[b]+=1;
            arr[a].add(b);
        }
        PriorityQueue<Integer>  q = new PriorityQueue<Integer>();
        for(int i=1; i<=n; i++){
            if(in[i] == 0){
                q.add(i);
            }
        }
        while(!q.isEmpty()){
            int cur = q.poll();
//             cur *=1;
            System.out.printf(cur+" ");
            for(int i=0; i<arr[cur].size(); i++){
                int next = arr[cur].get(i);
                in[next]-=1;
                if(in[next] ==0){
                    q.add(next);
                }
            }
        }
    }
}
