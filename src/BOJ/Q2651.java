import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Q2651 {
    static int n, maxlength, arr[], time[], total[], mintime, parent[], mincnt;
    static LinkedList<Integer> list;
    static boolean check[];
    static void print(int x){
        if(x <=0) {
            mincnt+=1;
            System.out.println(mincnt);
            return;
        }
        mincnt+=1;
        print(parent[x]);
        System.out.printf(x+" ");

    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        maxlength = Integer.parseInt(br.readLine());
        n = Integer.parseInt(br.readLine());
        arr = new int[n + 2];
        total = new int[n + 2];
        time = new int[n + 2];
        check = new boolean[n + 2];
        int d[] = new int[n+2];
        StringTokenizer st = new StringTokenizer(br.readLine());
        int cnt = 1;
        while (st.hasMoreElements()) {
            arr[cnt++] = Integer.parseInt(st.nextToken());
        }
        total[1] = arr[1];
        for (int i = 2; i <= n + 1; i++) {
            total[i] = total[i - 1] + arr[i];
        }
        st = new StringTokenizer(br.readLine());
        cnt = 1;
        while (st.hasMoreElements()) {
            time[cnt++] = Integer.parseInt(st.nextToken());
        }
        time[n + 1] = 0;
        int parent[] = new int[n+2];
        mintime = Integer.MAX_VALUE;
//        go(0, 0);
        for(int i=1; i<=n+1; i++) d[i] = Integer.MAX_VALUE;
        parent= new int[n+2];
        for(int i=1; i<=n+1; i++){
            int index=0;
            for(int j=i-1; j>=0;j--){
                if(total[i]-total[j]<maxlength){
                    if(d[i]<d[j]+time[j]){
                        d[i] = d[j]+time[j];
                        index = j;
                    }
                }
            }
            parent[i] = index;
        }
        System.out.println(d[n+1]);
        if(d[n+1]!=0){
            print(n+1);
        }
    }

}
