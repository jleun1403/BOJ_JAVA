import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class number6 {
    static char map [][];
    static String order;
    static int max;
    static class Number{
        int len;
        int s;
        public Number(int len, int s){
            this.len = len;
            this.s = s;
        }
    }
    static void print0(int x, int y, int size) {
        if (order.equals("MIDDLE")) {
            x += (max - size*2 + 1) / 2;
        }
        else if (order.equals(("BOTTOM"))) {
            x += (max - size*2 + 1);
        }
        for (int i = 0 ; i < size*2 - 1 ; i++) {
            if (i == 0 || i == size*2 - 2) {
                for (int j = 0; j < size; j++) {
                    map[x][y + j] = '#';
                }
            }
            else {
                map[x][y] = '#';
                map[x][y+size-1] = '#';
            }
            x += 1;
        }
    }

    static void print1(int x, int y, int size) {
        if (order.equals("MIDDLE")) {
            x += (max - size*2 + 1) / 2;
        }
        else if (order.equals(("BOTTOM"))) {
            x += (max - size*2 + 1);
        }
        for (int i = 0 ; i < size*2 - 1 ; i++) {
            map[x][y+size-1] = '#';
            x += 1;
        }
    }

    static void print2(int x, int y, int size) {
        if (order.equals("MIDDLE")) {
            x += (max - size*2 + 1) / 2;
        }
        else if (order.equals(("BOTTOM"))) {
            x += (max - size*2 + 1);
        }
        for (int i = 0 ; i < size*2 - 1 ; i++) {
            if (i == 0 || i == size*2 - 2 || i == (size*2 - 2) / 2)  {
                for (int j = 0; j < size; j++) {
                    map[x][y + j] = '#';
                }
            }
            else if (0 < i && i < (size*2 - 2) / 2){
                map[x][y+size-1] = '#';
            }
            else {
                map[x][y] = '#';
            }
            x += 1;
        }
    }
    static void print3(int x, int y, int size) {
        if (order.equals("MIDDLE")) {
            x += (max - size*2 + 1) / 2;
        }
        else if (order.equals(("BOTTOM"))) {
            x += (max - size*2 + 1);
        }
        for (int i = 0 ; i < size*2 - 1 ; i++) {
            if (i == 0 || i == size*2 - 2 || i == (size*2 - 2) / 2)  {
                for (int j = 0; j < size; j++) {
                    map[x][y + j] = '#';
                }
            }
            else{
                map[x][y+size-1] = '#';
            }
            x += 1;
        }
    }
    static void print4(int x, int y, int size) {
        if (order.equals("MIDDLE")) {
            x += (max - size*2 + 1) / 2;
        }
        else if (order.equals(("BOTTOM"))) {
            x += (max - size*2 + 1);
        }
        for (int i = 0 ; i < size*2 - 1 ; i++) {
            if (i == (size*2 - 2) / 2)  {
                for (int j = 0; j < size; j++) {
                    map[x][y + j] = '#';
                }
            }
            else if (0 <= i && i < (size*2 - 2) / 2){
                map[x][y+size-1] = '#';
                map[x][y] = '#';
            }
            else {
                map[x][y+size-1] = '#';
            }
            x += 1;
        }
    }
    static void print5(int x, int y, int size) {
        if (order.equals("MIDDLE")) {
            x += (max - size*2 + 1) / 2;
        }
        else if (order.equals(("BOTTOM"))) {
            x += (max - size*2 + 1);
        }
        for (int i = 0 ; i < size*2 - 1 ; i++) {
            if (i == 0 || i == size*2 - 2 || i == (size*2 - 2) / 2)  {
                for (int j = 0; j < size; j++) {
                    map[x][y + j] = '#';
                }
            }
            else if (0 < i && i < (size*2 - 2) / 2){
                map[x][y] = '#';
            }
            else {
                map[x][y+size-1] = '#';
            }
            x += 1;
        }
    }
    static void print6(int x, int y, int size) {
        if (order.equals("MIDDLE")) {
            x += (max - size*2 + 1) / 2;
        }
        else if (order.equals(("BOTTOM"))) {
            x += (max - size*2 + 1);
        }
        for (int i = 0 ; i < size*2 - 1 ; i++) {
            if (i == size*2 - 2 || i == (size*2 - 2) / 2)  {
                for (int j = 0; j < size; j++) {
                    map[x][y + j] = '#';
                }
            }
            else if (0 <= i && i < (size*2 - 2) / 2){
                map[x][y] = '#';
            }
            else {
                map[x][y+size-1] = '#';
                map[x][y] = '#';
            }
            x += 1;
        }
    }
    static void print7(int x, int y, int size) {
        if (order.equals("MIDDLE")) {
            x += (max - size*2 + 1) / 2;
        }
        else if (order.equals(("BOTTOM"))) {
            x += (max - size*2 + 1);
        }
        for (int i = 0 ; i < size*2 - 1 ; i++) {
            if (i == 0)  {
                for (int j = 0; j < size; j++) {
                    map[x][y + j] = '#';
                }
            }
            else {
                map[x][y+size-1] = '#';
            }
            x += 1;
        }
    }
    static void print8(int x, int y, int size) {
        if (order.equals("MIDDLE")) {
            x += (max - size*2 + 1) / 2;
        }
        else if (order.equals(("BOTTOM"))) {
            x += (max - size*2 + 1);
        }
        for (int i = 0 ; i < size*2 - 1 ; i++) {
            if (i == 0 || i == size*2 - 2 || i == (size*2 - 2) / 2)  {
                for (int j = 0; j < size; j++) {
                    map[x][y + j] = '#';
                }
            }
            else {
                map[x][y+size-1] = '#';
                map[x][y] = '#';
            }
            x += 1;
        }
    }
    static void print9(int x, int y, int size) {
        if (order.equals("MIDDLE")) {
            x += (max - size*2 + 1) / 2;
        }
        else if (order.equals(("BOTTOM"))) {
            x += (max - size*2 + 1);
        }
        for (int i = 0 ; i < size*2 - 1 ; i++) {
            if (i == 0 || i == (size*2 - 2) / 2)  {
                for (int j = 0; j < size; j++) {
                    map[x][y + j] = '#';
                }
            }
            else if (0 < i && i < (size*2 - 2) / 2){
                map[x][y] = '#';
                map[x][y+size-1] = '#';
            }
            else {
                map[x][y+size-1] = '#';
            }
            x += 1;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int k = Integer.parseInt(st.nextToken());
        order = st.nextToken();
        Number arr[] = new Number[k];
        ArrayList <Number> list = new ArrayList<>();
        max =0;
        int wide = 0;
        for(int i=0; i<k; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            String b = st.nextToken();
            for(int j=0; j<b.length(); j++){
                list.add(new Number(a,b.charAt(j)-'0'));
                wide +=a;
                wide+=1;
            }
            max = Math.max(max,a);
        }

        max =max*2 -1;
        map = new char[max][wide];
        for (int i = 0 ; i < max ; i++) {
            for (int j =0 ; j < wide ; j++) {
                map[i][j] = '.';
            }
        }
        int size = list.size();
        int curx = 0;
        int cury = 0;

        for (int i = 0 ; i < size ; i++) {
            int s = list.get(i).len;
            int num = list.get(i).s;

            if (num == 0) {
                print0(curx, cury, s);
            }
            else if (num == 1) {
                print1(curx, cury, s);
            }
            else if (num == 2) {
                print2(curx, cury, s);
            }
            else if (num == 3) {
                print3(curx, cury, s);
            }
            else if (num == 4) {
                print4(curx, cury, s);
            }
            else if (num == 5) {
                print5(curx, cury, s);
            }
            else if (num == 6) {
                print6(curx, cury, s);
            }
            else if (num == 7) {
                print7(curx, cury, s);
            }
            else if (num == 8) {
                print8(curx, cury, s);
            }
            else if (num == 9) {
                print9(curx, cury, s);
            }
            cury += s;
            for (int j = 0 ; j < max ; j++) {
                map[j][cury] = ' ';
            }
            cury += 1;
        }

        for (int i = 0 ; i < max ; i++) {
            for (int j = 0 ; j < wide - 1 ; j++) {
                System.out.print(map[i][j]);
            }
            System.out.println();
        }
    }
}
