package Math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_2527 {


    static class Square{
        int x,y,p,q;
        public Square(int x, int y, int p, int q){
            this.x = x;
            this.y = y;
            this.p = p;
            this.q = q;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<4; i++){
            StringTokenizer st = new StringTokenizer(bf.readLine());
            Square sq1 = new Square(
                    Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken())
            );

            Square sq2 = new Square(
                    Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken())
            );

            int x = Math.max(sq1.x,sq2.x);
            int y = Math.max(sq1.y,sq2.y);
            int p = Math.min(sq1.p,sq2.p);
            int q = Math.min(sq1.q,sq2.q);

            if(x<p && y<q) sb.append("a").append("\n");
            else if( (x==p && y<q) || (y==q && x<p)) sb.append("b").append("\n");
            else if(x==p && y==q) sb.append("c").append("\n");
            else sb.append("d").append("\n");
        }

        System.out.println(sb);
    }
}
