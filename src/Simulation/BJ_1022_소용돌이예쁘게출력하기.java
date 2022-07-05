package Simulation;

import java.util.Scanner;

public class BJ_1022_소용돌이예쁘게출력하기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int r1 = sc.nextInt();
        int c1 = sc.nextInt();
        int r2 = sc.nextInt();
        int c2 = sc.nextInt();

        int nr2 = r2-r1;
        int nc2 = c2-c1;

        int max = Math.max(Math.max(Math.max(Math.abs(r1), Math.abs(c1)), Math.abs(r2)), Math.abs(c2));

        int [][] paper = new int [(r2-r1)+1][(c2-c1)+1];

        int r = 0 - r1;
        int c = 0 - c1;
        int idx = 1;
        int cnt = 2;

        if(r>=0 && c>=0 && r<=nr2 && c<=nc2) paper[r][c] = idx++;
        else idx++;

        while(true){
            //우선 column하나 오른쪽 이동
            c++;
            if(c>2*max) break;
            for(int i=0; i<cnt; i++){
                if(r>=0 && c>=0 && r<=nr2 && c<=nc2) paper[r--][c] = idx++;
                else {idx++; r--;}
            }
            r++;

            for(int i=0; i<cnt; i++){
                if(r>=0 && c>0 && r<=nr2 && c<=nc2+1) paper[r][--c] = idx++;
                else {idx++; --c;}
            }
            for(int i=0; i<cnt; i++){
                if(r>=-1 && c>=0 && r<nr2 && c<=nc2) paper[++r][c] = idx++;
                else {idx++; ++r;}
            }
            for(int i=0; i<cnt; i++){
                if(r>=0 && c>=-1 && r<=nr2 && c<nc2) paper[r][++c] = idx++;
                else {idx++; ++c;}
            }

            cnt +=2;
        }


        String [][] result = new String [(r2-r1)+1][(c2-c1)+1];
        int maxL = 0;
        for(int i=0; i<=nr2; i++){
            for(int j=0; j<=nc2; j++){
                result[i][j] = String.valueOf(paper[i][j]);
                maxL = Math.max(maxL, result[i][j].length());
            }
        }

        StringBuilder sb = new StringBuilder();

        for(int i=0; i<=nr2; i++){
            for(int j=0; j<=nc2; j++){

                for(int k=0; k<maxL - result[i][j].length(); k++){
                    sb.append(" ");
                }
                sb.append(result[i][j]);

                if(j != nc2) sb.append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }


}
