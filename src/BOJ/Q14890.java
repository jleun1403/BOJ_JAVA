import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q14890 {
    static int n, len, arr[][];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        len = Integer.parseInt(st.nextToken());
        arr = new int[n][n];
        int answer = 0;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int cnt = 0;
            while (st.hasMoreElements()) {
                arr[i][cnt++] = Integer.parseInt(st.nextToken());
            }
        }
        int arr2[][] = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr2[i][j] = arr[j][i];
            }
        }
        for (int i = 0; i < n; i++) {
            int low = 0;
            boolean flag = false;
            for (int j = 0; j < n - 1; j++) {
                if (arr[i][j] == arr[i][j + 1]) {
                    continue;
                }
                else if (arr[i][j] == arr[i][j + 1] + 1) { // 감소하는 경우
                    boolean f = false;
                    if(j+len >=n){
                        flag= true;break;
                    }
                    for(int k=j+1; k<=j+len; k++){
                        if(arr[i][k] != arr[i][j+1]) {
                            f= true;
                            break;
                        }
                    }
                    if(f == true) {
                        flag = true;
                        break;
                    }
                    low = j +len+1; // low까지의 다리를 놓음.

                } else if (arr[i][j] == arr[i][j + 1] - 1) {// 증가하는 경우
                    if(j-len+1 <low || j-len+1 <0) {
                        flag = true; break;
                    }
                    boolean f = false;
                    for(int k = j; k>=j-len+1; k--){
                        if(arr[i][k] != arr[i][j]) {
                            f = true;
                            break;
                        }
                    }
                    if(f == true){
                        flag = true;
                        break;
                    }
                    low = j+1;
                } else {
                    flag = true;break;
                }
            }
            if (flag == false) {
//                System.out.println(i);
                answer += 1;
            }

        }
        for (int i = 0; i < n; i++) {
            int low = 0;
            boolean flag = false;
            for (int j = 0; j < n - 1; j++) {
                if (arr2[i][j] == arr2[i][j + 1]) {
                    continue;
                }
                else if (arr2[i][j] == arr2[i][j + 1] + 1) { // 감소하는 경우
                    boolean f = false;
                    if(j+len >=n){
                        flag= true;
                        break;
                    }
                    for(int k=j+1; k<=j+len; k++){
                        if(arr2[i][k] != arr2[i][j+1]) {
                            f= true;
                            break;
                        }
                    }
                    if(f == true){
                        flag = true;
                        break;
                    }
                    low = j +len+1; // low까지의 다리를 놓음.

                } else if (arr2[i][j] == arr2[i][j + 1] - 1) {// 증가하는 경우
                    if(j-len+1 <low || j-len+1 <0) {
                        flag = true;
                        break;
                    }
                    boolean f = false;
                    for(int k = j; k>=j-len+1; k--){
                        if(arr2[i][k] != arr2[i][j]) {
                            f = true;
                            break;
                        }
                    }
                    if(f == true){
                        flag = true;
                        break;
                    }
                    low = j+1;
                    // 1 1 2 3 3 3
                } else {
                    flag = true;
                    break;
                }

            }
            if (flag == false) {
//                System.out.println(i);
                answer += 1;
            }
        }
        System.out.println();
        System.out.println(answer);
    }

}
