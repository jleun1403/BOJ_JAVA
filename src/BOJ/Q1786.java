import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Q1786 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] T = br.readLine().toCharArray();
        char[] P = br.readLine().toCharArray();
        int tLength = T.length;
        int pLength = P.length;
        int [] fail = new int[pLength];
        // 실패함수 만들기 : P에서 P찾는 형태로...
        // 해당 부분 문자열의 최대접미사의 길이
        for(int i=1,j=0; i<pLength; i++) { // i: 접미사포인터, j: 접두사포인터
            // j위치에 틀리면 j-1위치까지는 맞았다는 이야기.
            // fail[j-1] : j-1위치까지 일치하는 접미사의 길이 => 이동해야하는 다음 비교 j의 위치.
            while(j>0 && P[i]!=P[j]) j = fail[j-1];
            if(P[i] == P[j]) {
                fail[i]=++j;
            }
        }
        int cnt = 0;
        ArrayList<Integer> list = new ArrayList<>();
        // i : text pointer, j: pattern pointer
        // i는 계속 증가하는 형태.
        for(int i=0, j=0; i<tLength; i++) {
            while(j>0 && T[i]!=P[j]) {
                j = fail[j-1]; // 매칭에 실패했을때.
            }
            if(T[i] ==P[j]) {
                if(j == pLength-1) {
                    list.add(i+2-pLength);
                    cnt+=1;
                    //System.out.println(i);
                    j = fail[j]; // 끝까지 봤고, j위치까지는 맞은 상태니까.
                }
                else {
                    j++;
                }
            }
            //else i++;
        }
        System.out.println(cnt);
        for(int i=0; i<list.size(); i++) {
            System.out.printf(list.get(i)+ " ");
        }
    }

}
