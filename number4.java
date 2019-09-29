import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class number4 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int arr[] = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        int cnt =0;
        ArrayList<Integer > list = new ArrayList<>();
        while(st.hasMoreElements()){
            arr[cnt] = Integer.parseInt(st.nextToken());
            if(arr[cnt] == 1) list.add(cnt);
            cnt++;
        }
        int answer = 0;
        if(list.size() ==1){
            answer = Math.max(cnt,n-cnt-1 );
        }
        else {
            for (int i = 0; i < list.size() - 1; i++) {
                int a = list.get(i);
                int b = list.get(i + 1);
                answer = Math.max(answer, (a + b) / 2 - a);
            }
        }
        System.out.println(answer);
    }
}
