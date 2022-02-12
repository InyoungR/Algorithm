package Array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class BJ_2999 {
    public static void main(String[] args) throws IOException {
        //사용되는 변수들
        char [] inputs;
        char [][] result;
        ArrayList<Integer> aliquot = new ArrayList<>();
        int N;
        int R;
        int C;
        int count;

        //입력
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        inputs = bf.readLine().toCharArray();
        N = inputs.length ;
        bf.close();

        //약수 구해서 정렬
        for(int i=1; i<=Math.sqrt(N); i++){
            if(N%i == 0) {
                aliquot.add(i);
                if(N/i != i) aliquot.add(N/i);
            }
        }
        Collections.sort(aliquot);

        //약수를 토대로 R과 C를 구해서 배열 만들기
        if(N==1) {
            R=1;
            C=1;
        } else if (aliquot.size()%2 == 1){
            R= aliquot.get(aliquot.size()/2);
            C= N/R;
        } else {
            R = aliquot.get(aliquot.size() / 2 - 1);
            C = N/R;
        }

        result = new char[R][C];

        //배열에 입력받은 값 넣어주기
        count = 0;
        for(int i=0; i<C; i++){
            for(int j=0; j<R; j++){
                result[j][i] = inputs[count++];
            }
        }

        //배열 읽어서 암호 해독하기
        for(int i=0; i<R; i++){
            for(int j=0; j<C; j++){
                System.out.print(result[i][j]);
            }
        }

    }
}
