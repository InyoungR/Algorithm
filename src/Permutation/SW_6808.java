package Permutation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class SW_6808 {
    static List<Integer> cardsG;
    static int [] cardsI;
    static boolean [] isSelected;
    static int loose, win;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(bf.readLine());

        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            cardsG = new ArrayList<>();
            cardsI = new int[9];
            isSelected = new boolean[9];

            for (int j = 0; j < 9; j++) cardsG.add(Integer.parseInt(st.nextToken()));

            int cnt = 0;
            for (int j = 1; j <= 18; j++) {
                if (!cardsG.contains(j)) cardsI[cnt++] = j;
            }
            loose = 0;
            win=0;

            permu(0, 0, 0);

            sb.append("#").append(i+1).append(" ").append(win).append(" ").append(loose).append("\n");

        }
        System.out.println(sb);
    }

    static void permu(int r, int pointG, int pointI){
        if(r==9){
            if(pointG>pointI) win += 1;
            else if(pointI>pointG) loose += 1;
            return;
        }

        for(int i=0; i<9; i++){
            if(!isSelected[i]){
                isSelected[i] = true;

                int cardG = cardsG.get(r);
                int cardI = cardsI[i];
                if(cardG>cardI){
                    permu(r+1, pointG+cardI+cardG, pointI);
                } else {
                    permu(r+1, pointG, pointI+cardG+cardI );
                }
                isSelected[i] = false;
            }
        }
    }
}
