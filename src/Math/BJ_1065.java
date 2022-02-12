package Math;

import java.io.*;

public class BJ_1065 {
    public static void main(String[] args) throws IOException {
        int n;
        int count = 0;

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(bf.readLine());

        for(char i = '1'; i-'0'<=n; i++){
            if(i-'0'<100) {
                count++;
                continue;
            } else {
                int a = (i-'0')/100;
                int b = (i-'0')%100/10;
                int c = (i-'0')%10;
                if(a-b == b-c){
                    count++;
                    continue;
                }
            }
        }

        bw.write(String.valueOf(count));
        bw.flush();
        bw.close();
        bf.close();
    }
}
