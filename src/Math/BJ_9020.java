package Math;

import java.io.*;

public class BJ_9020 {
    public static void main(String[] args) throws IOException {
        boolean [] prime;
        int n;
        int m;

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(bf.readLine());

        for(int i=0; i<n; i++){
            m = Integer.parseInt(bf.readLine());
            prime = new boolean[m+1];
            prime[0] =prime[1] = true; // false 값이 prime number
            prime[2] = false;
            for(int j=2; j*j<=m; j++){
                for(int k=2; k*j<=m; k++){
                    prime[j*k] = true;
                }
            }

            for(int j=m/2; j>=2; j--){
                if(!prime[j] && !prime[m-j]){
                    sb.append(j).append(" ").append(m-j).append("\n");
                    break;
                }
            }
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        bf.close();
    }
}
