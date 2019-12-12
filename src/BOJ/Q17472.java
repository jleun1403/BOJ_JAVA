import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q17472 {
	static int n, m, arr[][], island[][], dx[] = { -1, 1, 0, 0 }, dy[] = { 0, 0, -1, 1 }, islandnum, answer, parent[];
	static boolean check[][];
	static ArrayList<Mst> list;

	static class Position {
		int x, y;

		public Position(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	static class Mst implements Comparable<Mst> {
		int to, from, cost;

		public Mst(int to, int from, int cost) {
			this.to = to;
			this.from = from;
			this.cost = cost;
		}

		@Override
		public int compareTo(Mst o) {
			return this.cost - o.cost;
		}
	}

	static void go(int x, int y, int cnt) {
		island[x][y] = cnt;
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if (nx > n || nx <= 0 || ny > m || ny <= 0)
				continue;
			if (!check[nx][ny] && arr[nx][ny] == 1) {
				check[nx][ny] = true;
				go(nx, ny, cnt);
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		arr = new int[n + 1][m + 1];
		list = new ArrayList<>();
		answer = 0;
		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= m; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		check = new boolean[n + 1][m + 1];
		island = new int[n + 1][m + 1];
		int cnt = 1;
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m; j++) {
				if (arr[i][j] == 1 && !check[i][j]) {
					go(i, j, cnt++);
				}
			}
		}
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m; j++) {
				check[i][j] = false;
			}
		}
		islandnum = cnt - 1;
		makelength();

		boolean mstcheck[] = new boolean[islandnum + 1];
		boolean flag = false;
		parent = new int[islandnum + 1];
		for (int i = 1; i <= islandnum; i++)
			parent[i] = i;

		Collections.sort(list);
		for (int i = 0; i < list.size(); i++) {
			Mst m = list.get(i);
			int from = m.from;
			int to = m.to;
			int cost = m.cost;
			if (union(from, to)) {
				mstcheck[from] = true;
				mstcheck[to] = true;
				answer += cost;
			}
		}
		for (int i = 1; i <= islandnum - 1; i++) {
			if (find(i) != find(i + 1)) {
				answer = -1;
				break;
			}
		}
		System.out.println(answer);
	}

	private static int find(int a) {
		if (parent[a] == a)
			return a;
		return parent[a] = find(parent[a]);
	}

	static boolean union(int x, int y) {
		x = find(x);
		y = find(y);
		if (x == y)
			return false;
		
		else
			parent[x] = y;
		return true;
	}

	private static void makelength() {

		for (int k = 1; k <= islandnum; k++) {

			Queue<Position> q = new LinkedList<>();
			for (int i = 1; i <= n; i++) {
				for (int j = 1; j <= m; j++) {
					if (island[i][j] == k && !check[i][j]) {
						check[i][j] = true;
						q.add(new Position(i, j));
					}
				}
			}
			while (!q.isEmpty()) {
				Position p = q.poll();
				int x = p.x;
				int y = p.y;
				for (int op = 0; op < 4; op++) {
					int nx = x;
					int ny = y;
					int countlen = 0;
					while (nx + dx[op] >= 1 && nx + dx[op] <= n && ny + dy[op] >= 1 && ny + dy[op] <= m) {
						nx += dx[op];
						ny += dy[op];
						if (island[nx][ny] == 0) {
							countlen += 1;
						} else if (island[nx][ny] != k) {
							if (countlen < 2)
								break;
							list.add(new Mst(k, island[nx][ny], countlen));
							break;
						} else
							break;
					}
				}
			}
		}
	}

}
