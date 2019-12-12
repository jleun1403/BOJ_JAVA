import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Q4485 {
	static int dx[] = {-1, 1, 0, 0}, dy[] = {0,0,-1,1};
	static class Position{
		int x, y;
		public Position(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int count =1;
		while (true) {
			int n = Integer.parseInt(br.readLine());
			if(n==0) break;
			int arr[][] = new int[n][n];
			for (int i=0; i<n; i++) {
				StringTokenizer st= new StringTokenizer(br.readLine());
				for(int j=0; j<n; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			int d[][] = new int[n][n];
			for(int i=0; i<n; i++) {
				for(int j=0; j<n; j++) {
					d[i][j] = Integer.MAX_VALUE;
				}
			}
			d[0][0] = arr[0][0];
			LinkedList<Position> q = new LinkedList<>();
			q.add(new Position(0,0));
			while(!q.isEmpty()) {
				Position p = q.poll();
				int x = p.x;
				int y = p.y;
				for(int k=0; k<4; k++) {
					int nx = x + dx[k];
					int ny = y + dy[k];
					if(nx>=0 && nx<n && ny>=0 && ny<n) {
						if(d[nx][ny] > d[x][y] + arr[nx][ny]) {
							d[nx][ny] =d[x][y] + arr[nx][ny];
							q.add(new Position(nx,ny));
						}
					}
				}
			}

			System.out.println("Problem "+count+": "+ d[n-1][n-1]);
			count+=1;
		}

	}

}
