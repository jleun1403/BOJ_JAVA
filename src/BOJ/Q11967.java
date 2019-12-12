import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q11967 {
	static int dx[] = { -1, 1, 0, 0 }, dy[] = { 0, 0, -1, 1 };

	static class Position {
		int sx, sy;

		public Position(int sx, int sy) {
			this.sx = sx;
			this.sy = sy;
		}
	}

	static class Pos {
		int x, y;

		public Pos(int x, int y) {
			this.x = x;
			this.y = y;

		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int arr[][] = new int[n + 1][n + 1];
		boolean check[][] = new boolean[n + 1][n + 1];

		int answer = 0;
		ArrayList<Pos> list[][] = new ArrayList[n + 1][n + 1];
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				list[i][j] = new ArrayList<>();
			}
		}
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int sx = Integer.parseInt(st.nextToken());
			int sy = Integer.parseInt(st.nextToken());
			int ex = Integer.parseInt(st.nextToken());
			int ey = Integer.parseInt(st.nextToken());
			list[sx][sy].add(new Pos(ex, ey));

		}
		boolean ano[] = new boolean[m];
		arr[1][1] = 1;
		// 후보군정하기
		while (true) {
			boolean flag = false;
			for (int i = 1; i <= n; i++) {
				for (int j = 1; j <= n; j++) {
					if (arr[i][j] == 1) {
						for (int k = 0; k < list[i][j].size(); k++) {
							Pos p = list[i][j].get(k);
							int ex = p.x;
							int ey = p.y;
							if (arr[ex][ey] == 0) {
								flag = true;
								arr[ex][ey] = 2; // 켜질 수도 있는곳.
							}

						}
					}

				}

			}
			check = new boolean[n + 1][n + 1];
			check[1][1] = true;
			Queue<Pos> q = new LinkedList<>();
			q.add(new Pos(1, 1));
			while (!q.isEmpty()) {
				Pos p = q.poll();
				int x = p.x;
				int y = p.y;
				for (int k = 0; k < 4; k++) {
					int nx = x + dx[k];
					int ny = y + dy[k];
					if (nx >= 1 && nx <= n && ny >= 1 && ny <= n) {
						if ((arr[nx][ny] == 2 || arr[nx][ny] == 1) && !check[nx][ny]) {
							arr[nx][ny] = 1;
							check[nx][ny] = true;
							q.add(new Pos(nx, ny));
						}
					}
				}
			}
			if (flag == false)
				break;
		}

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
//				System.out.print(arr[i][j] + " ");
				if (arr[i][j] == 1 || arr[i][j] == 2)
					answer += 1;
			}
//			System.out.println();
		}

		System.out.println(answer);
	}

}
/*
5 25 
5 3 4 3 
1 1 1 3 
1 3 2 2 
4 2 4 3 
1 1 1 2 
1 4 3 5 
5 1 3 1 
5 3 5 2 
4 3 4 5 
5 4 3 1 
5 4 3 4 
3 4 5 4 
3 3 4 3 
3 3 1 5 
1 2 2 1 
4 5 3 1 
1 4 3 3 
4 5 1 3 
2 1 5 1 
3 5 5 1 
2 1 1 4 
4 3 5 4 
1 3 2 3 
3 3 5 2 
1 2 3 1

 */