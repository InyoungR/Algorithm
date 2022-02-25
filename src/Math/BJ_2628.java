package Math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_2628 {

    static class Square{
        int Xs,Xe,Ys,Ye;

        public Square(int xs, int xe, int ys, int ye) {
            Xs = xs;
            Xe = xe;
            Ys = ys;
            Ye = ye;
        }
    }
    static Queue<Square> que;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int X = Integer.parseInt(st.nextToken());
        int Y = Integer.parseInt(st.nextToken());

        que = new LinkedList<>();
        que.offer(new Square(0,X,0,Y));

        int c = Integer.parseInt(bf.readLine());
        for(int i=0; i<c; i++){
            st = new StringTokenizer(bf.readLine());
            int type = Integer.parseInt(st.nextToken());
            int axis = Integer.parseInt(st.nextToken());

            switch(type){
                case 0 : cutX(axis); break;
                case 1 : cutY(axis); break;
            }
        }

        int max = 0;

        while(!que.isEmpty()){
            Square sq = que.poll();
            max = Math.max(max, (sq.Xe-sq.Xs)*(sq.Ye-sq.Ys));
        }

        System.out.println(max);
    }

    static void cutX(int axis){
        int s = que.size();

        for(int i=0; i<s; i++){
            Square old = que.poll();

            if(axis>old.Ys && axis<old.Ye){
                que.offer(new Square(old.Xs,old.Xe,old.Ys, axis));
                que.offer(new Square(old.Xs,old.Xe,axis,old.Ye));
            } else {
                que.offer(old);
            }
        }
    }

    static void cutY(int axis){
        int s = que.size();

        for(int i=0; i<s; i++){
            Square old = que.poll();

            if(axis>old.Xs && axis<old.Xe){
                que.offer(new Square(old.Xs,axis,old.Ys, old.Ye));
                que.offer(new Square(axis,old.Xe,old.Ys,old.Ye));
            } else {
                que.offer(old);
            }
        }
    }
}
