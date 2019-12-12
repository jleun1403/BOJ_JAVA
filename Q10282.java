import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Q10282 {
	static class Position{
		int to, sec;
		public Position(int to, int sec) {
			this.to = to;
			this.sec = sec;
		}
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		int time= Integer.parseInt(br.readLine());
		for(int t=0; t<time; t++) {
			StringTokenizer st =new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			ArrayList<Position> arr[] = new ArrayList[n+1];
			for(int i=1; i<=n; i++) {
				arr[i] = new ArrayList<>();
			}
			for(int i=0; i<m; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				int s = Integer.parseInt(st.nextToken());
				arr[b].add(new Position(a,s));
			}
			int d[] = new int[n+1];
			boolean check[] = new boolean[n+1];
			for(int i=0; i<=n; i++) d[i] = 987654321;
			d[c] = 0;
			for(int k=0; k<n-1; k++) {
				int max = 987654322;
				int index = -1;
				for(int i=1; i<=n; i++) {
					if(!check[i] && d[i] < max) {
						index = i;
						max = d[i];
					}
				}
			check[index] = true;
				for(int i=0; i<arr[index].size(); i++) {
					int y = arr[index].get(i).to;
					int sec = arr[index].get(i).sec;
					if(d[y] > d[index]+ sec) {
						d[y] = d[index] + sec;
					}
					
				}
				
			}
			int max = 0;
			int count=0;
			for(int i=1; i<=n; i++) {
				if(d[i]!=987654321) {
					count+=1;
					max = Math.max(max, d[i]);
				}
			}
			System.out.println(count + " " + max);
			
		}
	}

}
