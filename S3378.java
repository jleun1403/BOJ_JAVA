import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class S3378 {
    static String master[], me[];
    static int n, m, R, C, B;
    static boolean one, two, three;
    static int ans[];

    static boolean test(int a, int b, int c) {
        boolean flag = false;
        int one_1 = 0, one_2 = 0;
        int two_1 = 0, two_2 = 0;
        int three_1 = 0, three_2 = 0;
        int dotcount = 0;
        for (int i = 0; i < n - 1; i++) {
            dotcount = 0;
            String temp = master[i];
            for (int j = 0; j < temp.length(); j++) {
                if (temp.charAt(j) == '(')
                    one_1 += 1;
                else if (temp.charAt(j) == ')')
                    one_2 += 1;
                else if (temp.charAt(j) == '{')
                    two_1 += 1;
                else if (temp.charAt(j) == '}')
                    two_2 += 1;
                else if (temp.charAt(j) == '[')
                    three_1 += 1;
                else if (temp.charAt(j) == ']')
                    three_2 += 1;
            }
            temp = master[i + 1];
            for (int j = 0; j < temp.length(); j++) {
                char ch = temp.charAt(j);
                if (ch == '.')
                    dotcount += 1;
                else
                    break;
            }
            if (a * (one_1 - one_2) + b * (two_1 - two_2) + c * (three_1 - three_2) != dotcount) {
                return false;
            }

        }
        if (one_1 == 0 && one_2 == 0)
            one = true;
        if (two_1 == 0 && two_2 == 0)
            two = true;
        if (three_1 == 0 && three_2 == 0)
            three = true;
        return true;
    }

    public static void go(int a, int b, int c, int cnt) {
        ArrayList<Integer> list = new ArrayList<>();
        int dotcount = 0;
        int one_1 = 0, one_2 = 0;
        int two_1 = 0, two_2 = 0;
        int three_1 = 0, three_2 = 0;
        for (int i = 0; i < m - 1; i++) {
            dotcount = 0;
            String temp = me[i];
            for (int j = 0; j < temp.length(); j++) {
                if (temp.charAt(j) == '(')
                    one_1 += 1;
                else if (temp.charAt(j) == ')')
                    one_2 += 1;
                else if (temp.charAt(j) == '{')
                    two_1 += 1;
                else if (temp.charAt(j) == '}')
                    two_2 += 1;
                else if (temp.charAt(j) == '[')
                    three_1 += 1;
                else if (temp.charAt(j) == ']')
                    three_2 += 1;
            }
            int num = (a * (one_1 - one_2) + b * (two_1 - two_2) + c * (three_1 - three_2));
            if (cnt == 0)
                ans[i] = num;
            else {
                if (ans[i] != num)
                    ans[i] = -1;
                else
                    continue;
            }
        }
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int time = Integer.parseInt(br.readLine());
        for (int t = 1; t <= time; t++) {

            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            master = new String[n];
            me = new String[m];
            for (int i = 0; i < n; i++) {
                master[i] = br.readLine();
            }
            for (int i = 0; i < m; i++) {
                me[i] = br.readLine();
            }
            boolean flag = false;
            int cnt = 0;
            ans = new int[m];
            first: for (int i = 1; i <= 20; i++) {
                for (int j = 1; j <= 20; j++) {
                    for (int k = 1; k <= 20; k++) {
                        if (test(i, j, k)) {
                            R = i;
                            C = j;
                            B = k;
                            go(i, j, k, cnt);
                            //System.out.println(i + " " + j + " " + k);
                            cnt+=1;
                        }
                    }
                }
            }
            System.out.print("#" + t + " 0 ");
            for (int i = 0; i < m-1; i++) {
                System.out.print(ans[i] + " ");
            }
            System.out.println();

        }
    }

}
