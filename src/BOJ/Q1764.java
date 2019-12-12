import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;

public class Q1764 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String first[] = br.readLine().split(" ");
        int n = Integer.parseInt(first[0]);
        int m = Integer.parseInt(first[1]);
        HashSet<String> map = new HashSet<>();
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            map.add(br.readLine());
        }
        for (int i = 0; i < m; i++) {
            String s = br.readLine();
            if (map.contains(s)) {
                list.add(s);
            }
        }
        Collections.sort(list);
        System.out.println(list.size());
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }
}
