import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Q11725 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        ArrayList<Integer>[] a = (ArrayList<Integer>[]) new ArrayList[n+1];
        for(int i=1; i<=n; i++){
            a[i] = new ArrayList<Integer>();
        }
        int d[] = new int [n+1];
        boolean check[] = new boolean[n+1];
        int parent[]  = new int[n+1];
        for(int i=0; i<n-1; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x= Integer.parseInt(st.nextToken());
            int y= Integer.parseInt(st.nextToken());
            a[x].add(y);
            a[y].add(x);
        }
        Queue<Integer> q = new LinkedList<Integer>();
        q.add(1);
        check[1] = true;
        while(!q.isEmpty()){
            int x = q.poll();
            for(int element : a[x]){
                if(!check[element]){
                    check[element] = true;
                    parent[element] = x;
                    q.add(element);
                }
            }
        }
        for(int i=2; i<=n; i++){
            System.out.println(parent[i]);
        }
    }
}
