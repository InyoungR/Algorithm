package Array;

import java.io.*;

public class BJ_3985 {
    public static void main(String[] args) throws IOException {
        int size;
        int n;
        int [] cake;
        String [] temp;
        int max=0;
        int truemax=0;
        int result = 0;
        int trueresult = 0;
        int count = 0;

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        size = Integer.parseInt(bf.readLine());
        n = Integer.parseInt(bf.readLine());
        cake = new int [size];

        for(int i=1; i<=n; i++){
            temp = bf.readLine().split(" ");
            count = 0;
            int a = Integer.parseInt(temp[0]);
            int b = Integer.parseInt(temp[1]);
            for(int j=a-1; j<b; j++){
                if(cake[j] == 0) {
                    cake[j]=i;
                    count++;
                }
            }
            if(b-a>max) {
                max = b-a;
                result = i;
            }
            if(count>truemax){
                truemax = count;
                trueresult = i;
            }
        }
        bw.write(String.valueOf(result));
        bw.newLine();
        bw.write(String.valueOf(trueresult));

        bw.flush();
        bw.close();
        bf.close();
    }
}
