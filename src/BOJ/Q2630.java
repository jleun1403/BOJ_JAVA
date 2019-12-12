import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q2630 {
	static int arr[][], white, blue,n;
	static boolean iswhite(int x, int y , int len) {
		for(int i=0; i<len; i++) {
			for(int j=0; j<len; j++) {
				if(arr[x+i][y+j]==0) continue;
				else return false;
			}
		}
		return true;
	}
	static boolean isblue(int x, int y , int len) {
		for(int i=0; i<len; i++) {
			for(int j=0; j<len; j++) {
				if(arr[x+i][y+j]==1) continue;
				else return false;
			}
		}
		return true;
	}
	static void go(int x, int y, int len) {
		if(iswhite(x,y,len)) {
			white+=1; 
			return;
		}
		if(isblue(x,y,len)) {
			blue+=1;
			return;
		}
		go(x,y,len/2);
		go(x,y+len/2,len/2);
		go(x+len/2,y,len/2);
		go(x+len/2,y+len/2,len/2);
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		arr= new int[n][n];
		for(int i=0; i<n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<n; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		go(0,0,n);
		System.out.println(white);
		System.out.println(blue);
	}

}
