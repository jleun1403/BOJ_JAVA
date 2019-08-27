import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q1963 {
    static boolean prime[], check[];
    static int d[];

    public static void goprime() {
        for (int i = 2; i < 10000; i++) {
            if (!prime[i]) {
                for (int j = i * 2; j < 10000; j += i) {
                    prime[j] = true;
                }
            }
        }
    }

    public static void go(String a, String b) {
        Queue<String> q = new LinkedList<String>();
        q.add(a);
        d[Integer.valueOf(a)] = 1;
        while (!q.isEmpty()) {
            String cur = q.poll();
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 10; j++) {
                    if (i == 0 && j == 0)
                        continue;
                    char ch[] = cur.toCharArray();
                    if ((ch[i] - '0') == j)
                        continue;
                    ch[i] = (char) ('0' + j);
                    String temp = new String(ch);
                    int in_temp = Integer.valueOf(temp);
//					System.out.println(temp);
                    if (!prime[in_temp] && d[in_temp] == 0) {
                        d[in_temp] = d[Integer.valueOf(cur)] + 1;
                        q.add(temp);
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        prime = new boolean[10000];
        goprime();
        for (int i = 0; i < t; i++) {
            d = new int[10000];
            check = new boolean[10000];
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            d[a] = 1;

            go(String.valueOf(a), String.valueOf(b));

            if (d[b] == 0)
                System.out.println("-1");
            else
                System.out.println(d[b]-1);
        }

    }

}
