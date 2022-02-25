package Math;

import java.util.Scanner;

public class BJ_10158 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int W = sc.nextInt(), H = sc.nextInt(); //벽
        int x = sc.nextInt(), y = sc.nextInt(); //개미의 좌표
        int t = sc.nextInt();

        x = x + t;
        y = y + t;

        //몫
        int xShare = x/W;
        int yShare = y/H;
        //나머지
        int xleft = x%W;
        int yleft = y%H;

        switch(xShare%2){
            case 0:
                x = xleft;
                break;
            case 1:
                x = W-xleft;
                break;
        }

        switch(yShare%2){
            case 0:
                y = yleft;
                break;
            case 1:
                y = H-yleft;
                break;
        }

        System.out.printf("%d %d", x, y);
    }
}
