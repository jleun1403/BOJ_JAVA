import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Q2628{
    static int n,m, arr[][];
    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        arr = new int[n][m];
        int k = Integer.parseInt(br.readLine());
        ArrayList<Integer> a = new ArrayList<Integer> ();
        ArrayList<Integer> b = new ArrayList<Integer> ();
        for(int i=0; i<k; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            if(x ==0) a.add(y);
            else b.add(y);
        }
        a.add(0);
        b.add(0);
        a.add(n);
        b.add(m);
        Collections.sort(a);
        Collections.sort(b);
        int max1 = 0, max2 = 0;
        for(int i=0; i<a.size()-1; i++) {
            int t1 = a.get(i);
            int t2 = a.get(i+1);
            max1 = Math.max(t2-t1, max1);
        }
        for(int i=0; i<b.size()-1; i++) {
            int t1 = b.get(i);
            int t2 = b.get(i+1);
            max2 = Math.max(t2-t1, max2);
        }
        int answer= max1 * max2;
        System.out.println(answer);
    }
/*
 *
10 8
3
0 3
1 4
0 2

50 50
4
0 45
0 30
0 29
0 48
 */
}
