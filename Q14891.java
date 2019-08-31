import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q14891 {
    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        int arr[][] = new int[4][8];
        for(int i=0; i<4; i++){
            int cnt=0;
            StringTokenizer st = new StringTokenizer(br.readLine());
            while(st.hasMoreElements()){
                arr[i][cnt++] = Integer.parseInt(st.nextToken());
            }
        }
    }
}
