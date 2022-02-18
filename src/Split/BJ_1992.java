package Split;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_1992 {
    static char [][] video;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());

        video = new char[n][];
        for(int i=0; i<n; i++){
            video[i] = bf.readLine().toCharArray();
        }
        Compression(0,0,n);
        System.out.println(sb);
    }

    public static void Compression(int r, int c, int size){
        int check = Check(r,c,size);
        if(check!=-1) {
            sb.append(check);
            return;
        }
        int half = size/2;
        sb.append("(");
        Compression(r,c, half);
        Compression(r, c+half, half);
        Compression(r+half, c, half);
        Compression(r+half, c+half, half);
        sb.append(")");
    }
    public static int Check(int r, int c, int size){
        int zero=0, one=0;
        for(int i=r; i<r+size; i++){
            for(int j=c; j<c+size; j++){
                if(zero>0 && one>0) return -1;
                if(video[i][j] == '1') one+=1;
                else if(video[i][j] == '0') zero +=1;
            }
        }
        if(zero==0) return 1;
        else if(one ==0) return 0;
        else return -1;
    }
}
