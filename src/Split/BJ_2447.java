package Split;

import java.util.Scanner;

public class BJ_2447 {
    static char [][] star;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int n = sc.nextInt();
        star = new char [n+1][n+1];

        stars(0,0,n);

        for(int i =0; i<n; i++){
            for(int j =0 ; j<n; j++){
                sb.append(star[i][j]);
            }
            sb.append("\n");
        }

        System.out.println(sb);

    }

    static void stars(int r, int c, int s){
        if(s==3){
            for(int i=0; i<3; i++){
                star[r][c+i] = '*';
                star[r+2][c+i] = '*';
            }
            star[r+1][c] = '*';
            star[r+1][c+2] = '*';
            star[r+1][c+1] = ' ';
            return;
        }
        int s2 = s/3;
        stars(r,c,s2);
        stars(r,c+s2, s2);
        stars(r,c+2*s2,s2);

        stars(r+s2,c,s2);
        for(int i=0; i<s/2; i++){
            for(int j=0; j<s/2; j++){
                star[r+s2+i][c+s2+j] = ' ';
            }
        }
        stars(r+s2,c+2*s2,s2);

        stars(r+2*s2,c,s2);
        stars(r+2*s2,c+s2,s2);
        stars(r+2*s2,c+2*s2,s2);

    }
}
