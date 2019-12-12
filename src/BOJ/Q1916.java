import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q1916 {
	static class Position {
		int to, cost;

		public Position(int to, int cost) {
			this.to = to;
			this.cost = cost;
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		ArrayList<Position> arr[] = new ArrayList[n + 1];
		for (int i = 0; i <= n; i++) {
			arr[i] = new ArrayList<>();
		}
		for (int i = 0; i < m; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			arr[from].add(new Position(to, cost));
			//arr[to].add(new Position(from, cost));
		}
		StringTokenizer st = new StringTokenizer(br.readLine());
		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());
		boolean check[] = new boolean[n + 1];
		int d[] = new int[n + 1];
		Arrays.fill(d, 987654321);
		d[start] = 0;
		for (int k = 0; k < n - 1; k++) {
			int max = 987654322;
			int index = -1;
			for (int i = 1; i <= n; i++) {
				if (!check[i] && d[i] < max) {
					max = d[i];
					index = i;
				}
			}
			check[index] = true;
			for (int i = 0; i < arr[index].size(); i++) {
				int y = arr[index].get(i).to;
				int c = arr[index].get(i).cost;
				if(d[y] > d[index] + c) {
					d[y] = d[index] +c;
				}
			}
			
		}
		System.out.println(d[end]);
	}

}
