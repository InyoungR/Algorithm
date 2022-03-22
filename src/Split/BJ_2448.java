package Split;

import java.util.Scanner;

public class BJ_2448 {
    static StringBuilder [] sb;
    static int N, pibo;
    static int [] last;
    static char[][] arr = new char [3072][6144];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        N = sc.nextInt();
        last = new int [N];

        for(int i=0; i<N; i++){
            for(int j=0; j<2*N; j++){
                if(j == 2*N -1){
                    arr[i][j] = '\0';
                } else {
                    arr[i][j] = ' ';
                }
            }
        }

        DFS(N, N-1, 0  );

        for(int i=0; i<N; i++){
            for(int j=0; j<2*N-1; j++){
                sb.append(arr[i][j]);
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }
    static void DFS(int height, int x, int y){
        if(height == 3){
            arr[y][x] = '*';
            arr[y+1][x-1] = '*';
            arr[y+1][x+1] = '*';
            arr[y+2][x] = '*';
            arr[y+2][x-1] = '*';
            arr[y+2][x+1] = '*';
            arr[y+2][x+2] = '*';
            arr[y+2][x-2] = '*';
            return;
        }

        DFS(height/2, x, y);
        DFS(height/2, x-(height/2), y+(height/2));
        DFS(height/2, x+(height/2), y+(height/2));
    }
}
