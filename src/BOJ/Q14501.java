import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q14501 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int time [] =new int[n+1];
		int price [] =new int[n+1];
		int d [] =new int[n+1];
		for(int i=0; i<n ; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			time[i+1] = Integer.parseInt(st.nextToken());
			price[i+1] = Integer.parseInt(st.nextToken());
		}
		int max = 0;
		for(int i=1; i<=n; i++) {
			for(int j=1; j<=i; j++) {
				if(i+time[i]-1 <=n) d[i] = Math.max(d[i],price[i]);
				if(j+time[j]<=i && i+time[i]-1<=n) {
					d[i] = Math.max(d[i], d[j]+price[i]);
					
				}
			}
		}
		for(int i=1; i<=n ;i++) max = Math.max(max, d[i]);
		//System.out.println(Arrays.toString(d));
		System.out.println(max);
	}

}

