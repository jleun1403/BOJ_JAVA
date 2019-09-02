import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Q2651 {
    static int n, maxlength, arr[], time[], total[], mintime, mincnt;
    static LinkedList<Integer> list;
    static boolean check[];

    static void go(int index, int t) {
        if (t >= mintime)
            return;
        if (index == n + 1) {
            if (mintime > t) {
                mintime = t;
                list = new LinkedList<>();
                for (int i = 1; i <= n; i++) {
                    if (check[i])
                        list.add(i);
                }
            }

            return;
        }
        for (int i = index; i <= n + 1; i++) {
            if (!check[i]) {
                if (total[i] - total[index] <= maxlength) {
                    check[i] = true;
                    go(i, t + time[i]);
                    check[i] = false;
                }
            }
        }
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        maxlength = Integer.parseInt(br.readLine());
        n = Integer.parseInt(br.readLine());
        arr = new int[n + 2];
        total = new int[n + 2];
        time = new int[n + 2];
        check = new boolean[n + 2];
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
        mintime = Integer.MAX_VALUE;
        go(0, 0);
        System.out.println(mintime);
        int size = list.size();
        System.out.println(list.size());
        for (int i = 0; i < size; i++) {
            System.out.printf(list.poll() + " ");
        }
        System.out.println();
    }

}
