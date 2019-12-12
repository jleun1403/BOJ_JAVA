import java.util.*;
import java.io.*;

public class Q15650 {
    static int n, m;
    static int temp[];
    static boolean check[];
    static HashSet<String> set;
    
    public static void go(int cnt) {
        if (cnt == m) {
            Arrays.sort(temp);
            StringBuilder ss = new StringBuilder();
            for(int i=0; i<m; i++) {
                ss.append(String.valueOf(temp[i]+" "));
            }
            if (!set.contains(ss.toString())) {
                set.add(ss.toString());
                for (int i = 0; i < m; i++) {
                    System.out.printf(temp[i] + " ");
                }
                System.out.println();
            }
            return;

        }
        for (int i = 0; i < n; i++) {
            if (check[i] == false) {
                check[i] = true;
                temp[cnt] = i + 1;
                go(cnt + 1);
                check[i] = false;
                temp[cnt] =0;
            }
        }
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        check = new boolean[n];
        temp = new int[m];
        set = new HashSet<String>();

        go(0);
    }
}