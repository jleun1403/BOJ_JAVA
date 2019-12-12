import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q6593 {
	static int dx[] = { 1, -1, 0, 0, 0, 0 }, dy[] = { 0, 0, 0, 0, 1, -1 }, dz[] = { 0, 0, 1, -1, 0, 0 };
	static class Position {
		int x, y, z;
		public Position(int x, int y, int z) {
			this.x = x;
			this.y = y;
			this.z = z;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int k = Integer.parseInt(st.nextToken());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			if (k == 0 && n == 0 && m == 0)
				break;
			int sx = 0, sy = 0, sz = 0;
			int ex = 0, ey = 0, ez = 0;
			char arr[][][] = new char[n][m][k];
			int d[][][] = new int[n][m][k];
			for (int l = 0; l < k; l++) {
				for (int i = 0; i < n; i++) {
					String s = br.readLine();
					for (int j = 0; j < m; j++) {
						arr[i][j][l] =s.charAt(j);
						if (arr[i][j][l] == 'S') {
							sx = i;
							sy = j;
							sz = l;
						} else if (arr[i][j][l] == 'E') {
							ex = i;
							ey = j;
							ez = l;
						}
					}
				}
				br.readLine();
			}
			Queue<Position> q = new LinkedList<>();
			q.add(new Position(sx,sy,sz));
			d[sx][sy][sz] = 1;
			while(!q.isEmpty()) {
				Position p = q.poll();
				int x = p.x;
				int y = p.y;
				int z = p.z;
				for(int i=0; i<6; i++) {
					int nx = x + dx[i];
					int ny = y + dy[i];
					int nz = z + dz[i];
					if(nx>=0 && nx<n && ny>=0 && ny<m && nz>=0 && nz<k &&d[nx][ny][nz] ==0) {
						if(arr[nx][ny][nz] !='#') {
							d[nx][ny][nz] = d[x][y][z] +1;
							q.add(new Position(nx,ny,nz));
						}
					}
				}
			}
			if(d[ex][ey][ez]==0) {
				System.out.println("Trapped!");
			}
			else {
				System.out.println("Escaped in "+(d[ex][ey][ez]-1)+" minute(s).");
			}

		}
	}

}
