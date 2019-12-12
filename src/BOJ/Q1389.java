import java.util.*;
import java.io.*;

public class Q1389{
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        ArrayList <Integer> arr[] = new ArrayList[n+1];
        for(int i=1; i<=n; i++){
            arr[i]=new ArrayList<>();
        }
        int answer[] = new int[n+1];
        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int a= Integer.parseInt(st.nextToken());
            int b= Integer.parseInt(st.nextToken());
            arr[a].add(b);
            arr[b].add(a);
        }
        int min = Integer.MAX_VALUE;
        for(int i=1; i<=n; i++){
            Queue<Integer> q = new LinkedList();
            int d[] = new int[n+1];
            q.add(i);
            d[i] = 1;
            int cnt =0;
            while(!q.isEmpty()){
                int cur = q.poll();
                for(int j=0; j<arr[i].size(); j++){
                    int next = arr[i].get(j);
                    if(d[next]==0){
                        d[next] = d[cur]+1;
                        q.add(next);
                    }
                }
            }
            for(int j=1; j<=n; j++){
                if(j!=i){
                    cnt+=d[j];
                }
            }
            min = Math.min(min,cnt);
            answer[i] = cnt;
        }
        for(int i=1; i<=n; i++){
            if(answer[i] == min){
                System.out.println(i);
            }
            break;
        }
    }
}