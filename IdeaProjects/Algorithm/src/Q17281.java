import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q17281 {
    static int n, arr[], result[], score[][], answer,count, r[];
    static boolean check[], home[];

    public static void go(int index) {
        if (index == 8) {
            for(int i=0; i<9; i++) {
                r[i] = result[i];
            }
            r[8] = r[3];
            r[3] = 0;
            answer = Math.max(answer, solve()); // 각 이닝별로 결과 계산하기.
            return;
        }
        for (int i = 0; i < 8; i++) {
            if(!check[i]) {
                check[i] = true;
                result[index] = arr[i];
                go(index+1);
                check[i] = false;
            }
        }

    }
    public static int solve() { // 각 이닝별 결과 계산하기.
        int sum = 0;
        int cur = 0;
        for (int i = 0; i < n; i++) {
            int outcount = 0;
            int count = 0;
            Arrays.fill(home, false);
            while (true) {
                if (cur == 9)
                    cur = 0;
                int num = score[i][r[cur]]; // 현재 타자의 결과
                if (num == 0)
                    outcount += 1;
                else if (num == 4) {
                    for(int k=3; k>=1; k--) {
                        if(home[k]) count+=1;
                    }
                    count+=1;
//					home = new boolean[4];
                    Arrays.fill(home, false);
                } else {
                    for (int k = 3; k >= 1; k--) {
                        if (home[k]) {
                            if (k+num>= 4) {
                                count += 1;
                                home[k] =false;
                            } else {
                                home[k] = false;
                                home[k + num] = true;
                            }
                        }
                    }
                    home[num] = true;
                }
                cur++;
                if (outcount == 3)
                    break;
            }
            sum += count;
        }
        return sum;
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        result = new int[9];
        score = new int[n][9];
        arr = new int[8];
        check = new boolean[8];
        r = new int[9];
        home = new boolean[4];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int cnt = 0;
            while (st.hasMoreElements()) {
                score[i][cnt++] = Integer.parseInt(st.nextToken());
            }
        }
        for (int i = 0; i < 8; i++) {
            arr[i] = i + 1;
        }
        go(0); // result[] 에 타순 정하기.
        System.out.println(answer);
    }

}
