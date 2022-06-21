package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class BJ_14226_이모티콘 {
    static class emoji{
        int display, clipboard,time;

        public emoji(int display, int clipboard, int time) {
            this.display = display;
            this.clipboard = clipboard;
            this.time = time;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());

        boolean [][] V = new boolean[1001][1001]; //display, clipboard
        int answer = 0;

        Queue<emoji> que = new LinkedList<>();
        V[1][0] = true;
        que.add(new emoji(1,0,0));

        while(!que.isEmpty()){
            emoji cur = que.poll();
            int disp = cur.display;
            int clip = cur.clipboard;
            int time = cur.time;

            if(disp == n) {
                answer = time;
                break;
            }


            if(disp>0 && disp<=1000){
                //클립보드에 복사
                if(!V[disp][disp]){
                    V[disp][disp] = true;
                    que.add(new emoji(disp,disp,time+1));
                }

                //붙여넣기
                if(clip>0 && disp+clip<=1000){
                    if(!V[clip+disp][clip]){
                        V[disp+clip][clip] = true;
                        que.add(new emoji(disp+clip,clip,time+1));
                    }
                }

                //삭제
                if(!V[disp-1][clip]){
                    V[disp-1][clip] = true;
                    que.add(new emoji(disp-1,clip,time+1));
                }
            }
        }

        System.out.println(answer);
    }
}
