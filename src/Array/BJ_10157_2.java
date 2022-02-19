package Array;
import java.util.Scanner;

public class BJ_10157_2 {
    static int cnt, R, C, K;
    static int [][]map;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        R = sc.nextInt();
        C = sc.nextInt();
        K = sc.nextInt();

        map = new int[R + 1][C + 1];
        cnt = 1;
        int r = 1;
        int c = 1;
        int rr = 0;
        int cc = 0;
        int dir = 0;

        int[] dr = {0, 1, 0, -1};
        int[] dc = {1, 0, -1, 0};

        if(R*C<K){
            System.out.println(0);
        } else {
            while (cnt != K) {
                map[r][c] = cnt;

                rr = r + dr[dir];
                cc = c + dc[dir];

                if (rr < 1 || cc < 1 || rr > R || cc > C || map[rr][cc] != 0) {
                    dir++;
                    if (dir == 4) dir = 0;
                    rr = r + dr[dir];
                    cc = c + dc[dir];
                }
                r = rr;
                c = cc;
                cnt++;
            }
            sb.append(r).append(" ").append(c);
            System.out.println(sb);
        }

    }
}

