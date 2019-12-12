import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class Q12100 {
    static int answer, arr[][], n, op[], dx[] = { -1, 1, 0, 0 }, dy[] = { 0, 0, -1, 1 }, real[][];
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n + 1][n + 1];
        real = new int[n + 1][n + 1];
        op = new int[5];
        for (int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                real[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        go(0);
//		for (int i = 1; i <= n; i++) {
//			for (int j = 1; j <= n; j++) {
//				System.out.printf(arr[i][j] + " ");
//			}
//			System.out.println();
//		}
        System.out.println(answer);
    }
    private static void go(int index) {
        if (index == 5) {
            solve();
            return;
        }
        for (int i = 0; i < 4; i++) {

            op[index] = i;
            go(index + 1);

        }
    }
    private static void solve() {
        for(int i=1; i<=n; i++) {
            for(int j=1; j<=n; j++) {
                arr[i][j] = real[i][j];
            }
        }
        for (int t = 0; t < 5; t++) {
            int dir = op[t];
            if (dir == 0) { // 상
                for (int j = 1; j <= n; j++) { // 빈공간 있으면 빈공간 당겨서 채우기
                    int it = 1;
                    for (int i = 1; i <= n; i++) {
                        if (arr[i][j] == 0) {

                        } else {
                            arr[it][j] = arr[i][j];
                            if (it != i) {
                                arr[i][j] =0;
                            }
                            it++;
                        }
                    }
                }
                for (int j = 1; j <= n; j++) { // 같은 숫자가 있는경우 합치고 밀기
                    int it = 1;
                    for (int i = 1; i <= n - 1; i++) {
                        if (arr[i][j] != 0) {
                            if (arr[i][j] == arr[i + 1][j]) {
                                arr[i][j] = arr[i][j]*2;
                                arr[i+1][j]=0;
                            }
                            it++;
                        }
                    }
                }
                for (int j = 1; j <= n; j++) { // 빈공간 있으면 빈공간 당겨서 채우기
                    int it = 1;
                    for (int i = 1; i <= n; i++) {
                        if (arr[i][j] == 0) {

                        } else {
                            arr[it][j] = arr[i][j];
                            if (it != i) {
                                arr[i][j] =0;
                            }
                            it++;
                        }
                    }
                }
            } else if (dir == 1) { // 하
                for (int j = 1; j <= n; j++) { // 빈공간 있으면 빈공간 당겨서 채우기
                    int it = n;
                    for (int i = n; i >=1; i--) {
                        if (arr[i][j] == 0) {

                        } else {
                            arr[it][j] = arr[i][j];
                            if (it != i) {
                                arr[i][j] =0;
                            }
                            it--;
                        }
                    }
                }
                for (int j = 1; j <= n; j++) { // 같은 숫자가 있는경우 합치고 밀기
                    int it = n;
                    for (int i = n; i >=2; i--) {
                        if (arr[i][j] != 0) {
                            if (arr[i][j] == arr[i - 1][j]) {
                                arr[i][j] = arr[i][j]*2;
                                arr[i-1][j]=0;
                            }
                            it--;
                        }
                    }
                }
                for (int j = 1; j <= n; j++) { // 빈공간 있으면 빈공간 당겨서 채우기
                    int it = n;
                    for (int i = n; i >=1; i--) {
                        if (arr[i][j] == 0) {

                        } else {
                            arr[it][j] = arr[i][j];
                            if (it != i) {
                                arr[i][j] =0;
                            }
                            it--;
                        }
                    }
                }
            } else if (dir == 2) { // 좌
                for (int i = 1; i <= n; i++) { // 빈공간 있으면 빈공간 당겨서 채우기
                    int it = 1;
                    for (int j = 1; j <= n; j++) {
                        if (arr[i][j] == 0) {

                        } else {
                            arr[i][it] = arr[i][j];
                            if (it != j) {
                                arr[i][j] =0;
                            }
                            it++;
                        }
                    }
                }
                for (int i = 1; i <= n; i++) { // 같은 숫자가 있는경우 합치고 밀기
                    int it = 1;
                    for (int j = 1; j <= n - 1; j++) {
                        if (arr[i][j] != 0) {
                            if (arr[i][j] == arr[i][j+1]) {
                                arr[i][j] = arr[i][j]*2;
                                arr[i][j+1]=0;
                            }
                            it++;
                        }
                    }
                }
                for (int i = 1; i <= n; i++) { // 빈공간 있으면 빈공간 당겨서 채우기
                    int it = 1;
                    for (int j = 1; j <= n; j++) {
                        if (arr[i][j] == 0) {

                        } else {
                            arr[i][it] = arr[i][j];
                            if (it != j) {
                                arr[i][j] =0;
                            }
                            it++;
                        }
                    }
                }
            } else if (dir == 3) { // 우
                for (int i = 1; i <=n; i++) { // 빈공간 있으면 빈공간 당겨서 채우기
                    int it = n;
                    for (int j = n; j >=1; j--) {
                        if (arr[i][j] == 0) {

                        } else {
                            arr[i][it] = arr[i][j];
                            if (it != j) {
                                arr[i][j] =0;
                            }
                            it--;
                        }
                    }
                }
                for (int i = 1; i <= n; i++) { // 같은 숫자가 있는경우 합치고 밀기
                    int it = n;
                    for (int j = n; j >=2; j--) {
                        if (arr[i][j] != 0) {
                            if (arr[i][j] == arr[i][j-1]) {
                                arr[i][j] = arr[i][j]*2;
                                arr[i][j-1]=0;
                            }
                            it--;
                        }
                    }
                }
                for (int i = 1; i <= n; i++) { // 빈공간 있으면 빈공간 당겨서 채우기
                    int it = n;
                    for (int j = n; j >=1; j--) {
                        if (arr[i][j] == 0) {

                        } else {
                            arr[i][it] = arr[i][j];
                            if (it != j) {
                                arr[i][j] =0;
                            }
                            it--;
                        }
                    }
                }
            }
        }
        for(int i=1; i<=n; i++) {
            for(int j=1; j<=n; j++) {
                answer = Math.max(arr[i][j], answer);
            }
        }
//		for (int i = 1; i <= n; i++) {
//			for (int j = 1; j <= n; j++) {
//				System.out.printf(arr[i][j] + " ");
//			}
//			System.out.println();
//		}
//		System.out.println();
    }

}
