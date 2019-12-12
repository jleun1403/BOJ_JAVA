
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S1873 {
    static int n, m, dx[] = { -1, 1, 0, 0 }, dy[] = { 0, 0, -1, 1 };
    static char arr[][];

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int time = Integer.parseInt(br.readLine());
        for (int t = 1; t <= time; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            arr = new char[n][m];
            for (int i = 0; i < n; i++) {
                char[] temp = br.readLine().toCharArray();
                for (int j = 0; j < m; j++) {
                    arr[i][j] = temp[j];
                }
            }
            int k = Integer.parseInt(br.readLine());
            char op[] = new char[k];
            op = br.readLine().toCharArray();
            for (int kk = 0; kk < k; kk++) {
                char curop = op[kk];
                switch (curop) {
                    case 'S':
                        for (int i = 0; i < n; i++) {
                            for (int j = 0; j < m; j++) {
                                if (arr[i][j] == '^') {
                                    int x = i;
                                    int y = j;
                                    while (x-1 >= 0) {
                                        x -= 1;
                                        if (arr[x][y] == '#')
                                            break;
                                        else if (arr[x][y] == '*') {
                                            arr[x][y] = '.';
                                            break;
                                        }
                                    }
                                } else if (arr[i][j] == 'v') {
                                    int x = i;
                                    int y = j;
                                    while (x+1 < n) {
                                        x += 1;
                                        if (arr[x][y] == '#')
                                            break;
                                        else if (arr[x][y] == '*') {
                                            arr[x][y] = '.';
                                            break;
                                        }
                                    }
                                } else if (arr[i][j] == '<') {
                                    int x = i;
                                    int y = j;
                                    while (y-1 >= 0) {
                                        y -= 1;
                                        if (arr[x][y] == '#')
                                            break;
                                        else if (arr[x][y] == '*') {
                                            arr[x][y] = '.';
                                            break;
                                        }
                                    }

                                }
                                else if(arr[i][j] == '>') {
                                    int x = i;
                                    int y = j;
                                    while (y+1 <m) {
                                        y += 1;
                                        if (arr[x][y] == '#')
                                            break;
                                        else if (arr[x][y] == '*') {
                                            arr[x][y] = '.';
                                            break;
                                        }
                                    }
                                }
                            }
                        }
                        break;
                    case 'U':
                        first:
                        for(int i=0; i<n; i++) {
                            for(int j=0; j<m; j++) {
                                if(arr[i][j] =='^' || arr[i][j] == 'v' || arr[i][j] == '<'|| arr[i][j] == '>') {
                                    if(i-1>=0 && arr[i-1][j] =='.') {
                                        arr[i-1][j] ='^';
                                        arr[i][j]='.';
                                        break first;
                                    }
                                    else arr[i][j]='^';
                                }
                            }
                        }
                        break;
                    case 'D':
                        first:
                        for(int i=0; i<n; i++) {
                            for(int j=0; j<m; j++) {
                                if(arr[i][j] =='^' || arr[i][j] == 'v' || arr[i][j] == '<'|| arr[i][j] == '>') {
                                    if(i+1<n && arr[i+1][j] == '.') {
                                        arr[i+1][j] ='v';
                                        arr[i][j] ='.';
                                        break first;
                                    }
                                    else arr[i][j]='v';
                                }
                            }
                        }
                        break;
                    case 'L':
                        first:
                        for(int i=0; i<n; i++) {
                            for(int j=0; j<m; j++) {
                                if(arr[i][j] =='^' || arr[i][j] == 'v' || arr[i][j] == '<'|| arr[i][j] == '>') {
                                    if(j-1>=0 && arr[i][j-1] == '.') {
                                        arr[i][j] ='.';
                                        arr[i][j-1] ='<';
                                        break first;
                                    }
                                    else
                                        arr[i][j]='<';
                                }
                            }
                        }
                        break;
                    case 'R':
                        first:
                        for(int i=0; i<n; i++) {
                            for(int j=0; j<m; j++) {
                                if(arr[i][j] =='^' || arr[i][j] == 'v' || arr[i][j] == '<'|| arr[i][j] == '>') {
                                    if(j+1<m && arr[i][j+1]=='.') {
                                        arr[i][j] ='.';
                                        arr[i][j+1] ='>';
                                        break first;
                                    }
                                    else {
                                        arr[i][j]='>';
                                    }
                                }
                            }
                        }
                        break;
                }
            }
            System.out.printf("#"+ t+" ");
            for(int i=0; i<n; i++) {
                for(int j=0; j<m; j++) {
                    System.out.printf(arr[i][j]+"");
                }
                System.out.println();
            }


        }
    }

}
