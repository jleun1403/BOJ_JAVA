import java.io.BufferedReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.io.InputStreamReader;


public class J2543{
    static int n, arr[][];
    static void go(int startx, int starty, int endx, int endy, int holex, int holey){
        if(startx == endx) return;
        int middlex = (startx + endx) /2;
        int middley = (starty + endy) /2;
        if ((holex >= startx) && (holex <= middlex) && (holey >= starty) && (holey <= middley)) {	 
            arr[middlex + 1][middley] = arr[middlex + 1][middley + 1] = arr[middlex][middley + 1] = 1;
            go(startx, starty, middlex, middley, holex, holey); 
            go(startx, middley + 1, middlex, endy, middlex, middley + 1); 
            go(middlex + 1, starty, endx, middley, middlex + 1, middley); 
            go(middlex + 1, middley + 1, endx, endy, middlex + 1, middley + 1); 
        }
    
        else if ((holex >= startx) && (holex <= middlex) && (holey >= middley + 1) && (holey <= endy)) { 
            arr[middlex][middley] = arr[middlex + 1][middley] = arr[middlex + 1][middley + 1] = 2;
            go(startx, starty, middlex, middley, middlex, middley); 
            go(startx, middley + 1, middlex, endy, holex, holey); 
            go(middlex + 1, starty, endx, middley, middlex + 1, middley); 
            go(middlex + 1, middley + 1, endx, endy, middlex + 1, middley + 1); 
        }
    
        else if ((holex >= middlex + 1) && (holex <= endx) && (holey >= starty) && (holey <= middley)) { 
            arr[middlex][middley] = arr[middlex][middley + 1] = arr[middlex + 1][middley + 1] = 3;
            go(startx, starty, middlex, middley, middlex, middley); 
            go(startx, middley + 1, middlex, endy, middlex, middley + 1); 
            go(middlex + 1, starty, endx, middley, holex, holey); 
            go(middlex + 1, middley + 1, endx, endy, middlex + 1, middley + 1); 
        }
    
        else if ((holex >= middlex + 1) && (holex <= endx) && (holey >= middley + 1) && (holey <= endy)) {
            arr[middlex][middley] = arr[middlex + 1][middley] = arr[middlex][middley + 1] = 4;
            go(startx, starty, middlex, middley, middlex, middley); 
            go(startx, middley + 1, middlex, endy, middlex, middley + 1); 
            go(middlex + 1, starty, endx, middley, middlex + 1, middley); 
            go(middlex + 1, middley + 1, endx, endy, holex, holey); 
        }

    }
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int hx = Integer.parseInt(st.nextToken());
        int hy = Integer.parseInt(st.nextToken());
        arr = new int[n][n];
        arr[hx][hy] =0;
        go(0,0,n-1,n-1,hx, hy);
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                System.out.printf(arr[i][j]+" ");
            }
            System.out.println();
        }

    }
}