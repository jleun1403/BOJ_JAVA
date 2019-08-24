import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q2617{
static class count {
    int left, right;

    public count(int left, int right) {
        this.left = this.right;
    }
}

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        count arr[] = new count[n + 1];
        boolean check[][] = new boolean[n + 1][n + 1];
        boolean checkleft[][] = new boolean[n + 1][n + 1];

        count s[] = new count[m];
        boolean left[][] = new boolean[n + 1][n + 1];
        boolean right[][] = new boolean[n + 1][n + 1];

        int answer = 0;
        for (int i = 1; i <= n; i++) {
            arr[i] = new count(0, 0);

        }
        for (int i = 0; i < m; i++)
            s[i] = new count(0, 0);
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()); // b < a
            int b = Integer.parseInt(st.nextToken());
            arr[b].left += 1;
            arr[a].right += 1;
            check[b][a] = true;
            checkleft[a][b] = true;
            s[i].left = b;
            s[i].right = a;
        }
        for(int t=0; t<2; t++) {
            for (int k = 0; k < m; k++) {
                int find = s[k].left;
                int p = s[k].right;
                for (int i = 1; i <= n; i++) {
                    if (check[i][find]) {
                        //	arr[i].right += 1;
                        check[i][p] = true;
                    }
                }
            }
        }
        for(int t=0; t<2; t++) {
            for (int k = 0; k < m; k++) {
                int p = s[k].left;
                int find = s[k].right;
                for (int i = 1; i <= n; i++) {
                    if (checkleft[i][find]) {
                        //	arr[i].right += 1;
                        checkleft[i][p] = true;
                    }
                }
            }
        }

        for (int i = 1; i <= n; i++) {
            int sum =0;
            int sum2 = 0;
            for(int j=1; j<=n; j++) {
                if(checkleft[i][j]== true) sum+=1;
                if(check[i][j]== true) sum2+=1;

            }
            if(sum>=n/2 +1) answer+=1;
            if(sum2 >=n/2 +1) answer+=1;
            //System.out.println(sum);
        }
        System.out.println(answer);
    }
	/*
5 4
2 1
4 3
5 1
4 2
	 *
7 5
2 3
4 5
1 6
3 4
5 6
	 *
	 *
7 5
3 2
5 4
6 1
4 3
6 5
	 *
	 */

}
