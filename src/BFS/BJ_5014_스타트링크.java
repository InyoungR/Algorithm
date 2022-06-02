package BFS;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BJ_5014_스타트링크 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int F = sc.nextInt();//총 층수
        int S = sc.nextInt();//시작 층수
        int G = sc.nextInt();//도착 층수
        int U = sc.nextInt();//올라가는 버틍
        int D = sc.nextInt();//내려가는 버튼

        Queue<Integer> que = new LinkedList<>();
        boolean [] V = new boolean [F+1];
        int [] updown = {U,-D};
        int btnCnt = 0;
        boolean reach = false;

        if(S == G) System.out.println(0);
        else {
            V[S] = true;
            que.add(S);
        }

        outer: while(!que.isEmpty()){
            int s = que.size();
            btnCnt++;

            for(int i=0; i<s; i++){
                int cur = que.poll();

                for(int dir=0; dir<2; dir++){
                    int nf = cur + updown[dir];

                    if(nf<=0 || nf>F || V[nf]) continue;

                    V[nf] = true;
                    if(nf == G) {
                        reach = true;
                        break outer;
                    }
                    que.add(nf);
                }
            }
        }
        if(reach) System.out.println(btnCnt);
        else if (S != G) System.out.println("use the stairs");
    }
}
