package Array;
import java.util.Scanner;

public class BJ_10157 {
    static int cnt, R, C, K;
    static int [][]map;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        C = sc.nextInt();
        R = sc.nextInt();
        K = sc.nextInt();

        map = new int [C+1][R+1];
        cnt = 0;

        int RS = 1;
        int CS = 1;
        int RE = C;
        int CE = R;
        if (K<=R*C){
            while(RS<=RE && CS<=CE){
                Rotate(RS, RE, CS, CE);
                if(cnt == K) break;
                RS++;
                RE--;
                CS++;
                CE--;
            }
            System.out.println(sb);
        } else System.out.println(0);
    }

    public static void Rotate(int rs, int re, int cs, int ce){
        if(rs == re){
            for(int i=cs; i<=ce; i++){
                map[rs][i] = ++cnt;
                if(cnt == K) {
                    sb.append(rs).append(" ").append(i);
                    return;
                }
            }
        }

        if(cs == ce){
            for(int i=rs; i<=re; i++){
                map[i][cs] = ++cnt;
                if(cnt == K) {
                    sb.append(i).append(" ").append(cs);
                    return;
                }
            }
        }

        for(int i = cs; i<ce; i++) {
            map[rs][i] = ++cnt;
            if(cnt == K) {
                sb.append(rs).append(" ").append(i);
                return;
            }
        }
        for(int i = rs; i<re; i++) {
            map[i][ce] = ++cnt;
            if(cnt == K) {
                sb.append(i).append(" ").append(ce);
                return;
            }
        }

        for(int i = ce; i>cs; i--) {
            map[re][i] = ++cnt;
            if(cnt == K) {
                sb.append(re).append(" ").append(i);
                return;
            }
        }

        for(int i = re; i>rs; i--) {
            map[i][cs] = ++cnt;
            if(cnt == K) {
                sb.append(i).append(" ").append(cs);
                return;
            }
        }
    }

}

