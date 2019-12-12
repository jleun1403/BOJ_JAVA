import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q17471 {
	static int n, num[], arr[][], result1[],result2[],answer;
	static boolean check[],vis1[],vis2[];
	public static void dfs1(int start) {
		for(int i=1; i<=n; i++) {
			if(check[i] && !vis1[i] && arr[start][i] == 1) {
				vis1[i] = true;
				dfs1(i);
			}
		}
	}
	public static void dfs2(int start) {
		for(int i=1; i<=n; i++) {
			if(!check[i] && !vis2[i] && arr[start][i] == 1) {
				vis2[i] = true;
				dfs2(i);
			}
		}
	}
	public static boolean isok1() {
		for(int i=1; i<=n; i++) {
			if(vis1[i]== true && check[i]==false) return false;
			if(vis1[i] == false && check[i] == true) return false;
		}
		return true;
	}
	public static boolean isok2() {
		for(int i=1; i<=n; i++) {
			if(vis2[i]== true && check[i]==true) return false;
			if(vis2[i] == false && check[i] == false) return false;
		}
		return true;
	}
	public static void go(int before, int index, int cnt) {
		if (index == cnt) {
			int c =0;
			Arrays.fill(result2, 0);
			for(int i=1; i<=n; i++) {
				if(!check[i]) {
					result2[c++] = i;
				}
			}
			vis1 = new boolean[n+1];
			vis2 = new boolean[n+1];
			vis1[result1[0]]= true;
			vis2[result2[0]]= true;
			dfs1(result1[0]);
			dfs2(result2[0]);
			
			if(isok1() && isok2()) {
				int sum1 =0;
				int sum2=0;
				for(int i=1; i<=n; i++) {
					if(vis1[i]) {
						sum1+=num[i];
					}
					else sum2+=num[i];
				}
				answer = Math.min(answer, Math.abs(sum1-sum2));
			}
			return;
		}
		for (int i = before; i <= n; i++) {
			if (!check[i]) {
				check[i] = true;
				result1[index] = i;
				go(i+1,index + 1, cnt);
				check[i] = false;
			}
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		num = new int[n + 1];
		for (int i = 1; i <= n; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}
		arr = new int[11][11];
		answer = Integer.MAX_VALUE;
		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			for (int j = 0; j < a; j++) {
				int b = Integer.parseInt(st.nextToken());
				arr[i][b] = 1;
				arr[b][i] = 1;
			}
		}
		check = new boolean[n + 1];
		result1 = new int[n+1];
		result2 = new int[n+1];
		for (int i = 1; i <= n / 2; i++) {
			check = new boolean[n+1];
			go(1,0, i);
		}
		if(answer == Integer.MAX_VALUE) answer = -1;
		System.out.println(answer);
	}

}
