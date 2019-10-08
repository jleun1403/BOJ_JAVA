import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Q11657 {
	static class Position {
		int to, from, cost;

		public Position(int from, int to, int cost) {
			this.to = to;
			this.cost = cost;
			this.from = from;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		ArrayList<Position> list = new ArrayList<>();
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			list.add(new Position(a, b, c));
		}
		boolean flag = false;
		int d[] = new int[n + 1];
		for (int i = 1; i <= n; i++)
			d[i] = Integer.MAX_VALUE;
		d[1] = 0;
		for (int i = 1; i <= n; i++) {
			for (int j = 0; j < m; j++) {
				Position p = list.get(j);
				int from = p.from;
				int to = p.to;
				int cost = p.cost;
				if (d[from] != Integer.MAX_VALUE && d[to] > d[from] + cost) {
					d[to] = d[from] + cost;
					if (i == n) {
						flag = true;
					}
				}

			}
		}
		if (flag == true)
			System.out.println(-1);
		else {
			for (int i = 2; i <= n; i++) {
				if(d[i] == Integer.MAX_VALUE) d[i] =-1;
				System.out.println(d[i]);
			}
		}

	}

}
