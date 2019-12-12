import java.util.*;
import java.io.*;

public class Q1260 {
    static ArrayList<ArrayList<Integer>> arr =new <ArrayList<Integer>> ArrayList ();;
    static int n;
    static boolean ok[]; 
    public static void dfs(int start){
        ok[start] = true;
        System.out.printf(start+" ");
        Iterator <Integer> it = arr.get(start).iterator();
        while(it.hasNext()){
            int n =it.next();
            if(!ok[n]){
                dfs(n);
            }
        }
    }
    public static void bfs(int start){
        LinkedList<Integer> q = new LinkedList<Integer>();
        boolean check[] = new boolean [n+1];
        q.add(start);
        check[start] = true;
        while(!q.isEmpty()){
            int x = q.getFirst();
            System.out.printf(x+" ");
            q.pop();
            Iterator <Integer >it = arr.get(x).listIterator();
            while(it.hasNext()){
                int n =it.next();
                if(!check[n]){
                    check[n] = true;
                    q.add(n);
                }
            }
        }
    }
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader (System.in));
        Scanner sc = new Scanner(System.in);
        String first []= br.readLine().split(" ");
        n = Integer.parseInt(first[0]);
        int m = Integer.parseInt(first[1]);
        int start = Integer.parseInt(first[2]);
        ok = new boolean[n+1];
        for(int i=0;i<n+1;i++) {
            arr.add(new<Integer> ArrayList());
        }

        for(int i=0; i<m; i++){
            String temp [] =br.readLine().split(" ");
            int a= Integer.parseInt(temp[0]);
            int b= Integer.parseInt(temp[1]);
            arr.get(a).add(b);
            arr.get(b).add(a);
        }
        for(int i=1; i<=n; i++){
            Collections.sort(arr.get(i));
        }
        dfs(start);
        System.out.println();
        bfs(start);
        System.out.println();
    }
}
