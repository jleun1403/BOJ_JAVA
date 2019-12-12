import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class J1671{

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int arr[][] = new int[101][101];
        int dx[] = {-1, 1, 0, 0};
        int dy[] = {0, 0, -1,1};
        int answer=0;
        for(int i=0; i<n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a= Integer.parseInt(st.nextToken());
            int b= Integer.parseInt(st.nextToken());
            for(int p=b; p<b+10; p++) {
                for(int q =a; q<a+10; q++) {
                    arr[p][q] = 1;
                }
            }
        }
        for(int i=0; i<100; i++) {
            for(int j=0; j<100; j++) {
                if(arr[i][j] == 1) {
                    for(int k=0; k<4; k++) {
                        int nx = i + dx[k];
                        int ny = j + dy[k];
                        if(arr[nx][ny] ==0 && nx>=0 && nx<=100 && ny>=0 && ny<=100) {
                            answer+=1;
                        }
                    }
                }
            }
        }
        System.out.println(answer);
    }

}
/*
4
3 7
5 2
15 7
13 14
*/