import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q2138 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		String s1 = br.readLine();
		char c1[] = s1.toCharArray();
		String s2 = br.readLine();
		char c2[] = s2.toCharArray();
		int answer = 0;
		if (s1.equals(s2)) {
			answer = 0;
		} else {
			char temp[] = s1.toCharArray();
			temp[0] = temp[0] == '0' ? '1' : '0';
			temp[1] = temp[1] == '0' ? '1' : '0';
			answer += 1;
			for (int i = 1; i < n; i++) { // 첫번째 누르는 경우
				if (i == n - 1) {
					if (c2[i - 1] != temp[i - 1]) {
						answer += 1;
						temp[i - 1] = temp[i - 1] == '0' ? '1' : '0';
						temp[i] = temp[i] == '0' ? '1' : '0';
					}
					if (temp[i] != c2[i])
						answer = -1;
				} else if (c2[i - 1] != temp[i - 1]) {
					answer += 1;
					temp[i - 1] = temp[i - 1] == '0' ? '1' : '0';
					temp[i] = temp[i] == '0' ? '1' : '0';
					temp[i + 1] = temp[i + 1] == '0' ? '1' : '0';
				}
			}
			int ans = 0;
			for (int i = 1; i < n; i++) {
				if (i == n - 1) {
					if (c1[i - 1] != c2[i - 1]) {
						ans += 1;
						c1[i - 1] = c1[i - 1] == '0' ? '1' : '0';
						c1[i] = c1[i] == '0' ? '1' : '0';
					}
						if (c1[i] != c2[i])
							ans = -1;
				} else if (c1[i - 1] != c2[i - 1]) {
					ans += 1;
					c1[i - 1] = c1[i - 1] == '0' ? '1' : '0';
					c1[i] = c1[i] == '0' ? '1' : '0';
					c1[i + 1] = c1[i + 1] == '0' ? '1' : '0';
				}
			}
			if (ans == -1 && answer == -1)
				answer = -1;
			else {
				if (ans==-1)
					ans = Integer.MAX_VALUE;
				if (answer==-1)
					answer = Integer.MAX_VALUE;
				answer = Math.min(answer, ans);
			}

		}
		System.out.println(answer);
	}

}
