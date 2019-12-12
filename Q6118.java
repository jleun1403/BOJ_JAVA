import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q6118 {
	public static void main(String[] args) throws IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int max = 0;
		 ArrayList<Integer>[] arr= new ArrayList[n+1];
		for(int i=1; i<=n; i++) {
			arr[i] = new ArrayList<>();
		}
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			arr[a].add(b);
			arr[b].add(a);
		}
		Queue<Integer>q = new LinkedList<Integer>();
		int d[] = new int[n+1];
		q.add(1);
		d[1] = 1;
		while(!q.isEmpty()) {
			int cur = q.poll();
			for(int i=0; i<arr[cur].size(); i++) {
				int c = arr[cur].get(i);
				if(d[c]==0) {
					d[c] = d[cur]+1;
					max = Math.max(max, d[c]);
					q.add(c);
				}
			}
		}
		int count =0;
		int index = Integer.MAX_VALUE;
		for(int i=1; i<=n; i++) {
			if(d[i]== max) {
				count+=1;
				index = Math.min(index, i);
			}
		}
		System.out.println(index+" "+(d[index]-1)+" "+count);
	}

}
