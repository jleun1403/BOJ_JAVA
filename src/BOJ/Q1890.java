import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q1890 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int arr[] = new int[n+1];
		int d[] = new int[n+1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=1; i<=n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			d[i] = arr[i];
		}
		for(int i=1; i<=n; i++) {
			for(int j=1; j<i; j++) {
				d[i]=Math.max(d[i], d[j]+d[i-j]);
			}
		}
		System.out.println(d[n]);
	}

}
