package Floyd;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SW_1263 {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/Floyd/SW_1263.txt"));
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(bf.readLine());
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        for(int t=1; t<=T; t++){
            st = new StringTokenizer(bf.readLine());
            int n = Integer.parseInt(st.nextToken());
            int [][] network = new int [n][n];

            for(int i=0; i<n; i++){
                for(int j=0; j<n; j++){
                    network[i][j] = Integer.parseInt(st.nextToken());
                    if(i != j && network[i][j] == 0) network[i][j] = 987654321;
                }
            }

            for(int k=0; k<n; k++){
                for(int i=0; i<n; i++){
                    if(k==i) continue;
                    for(int j=0; j<n; j++){
                        if(k==j || i==j) continue;
                        if(network[i][j]>network[i][k]+network[k][j])
                            network[i][j] = network[i][k]+network[k][j];
                    }
                }
            }

            int result = Integer.MAX_VALUE;
            for(int i=0; i<n; i++){
                int sum = 0;
                for(int j=0; j<n; j++){
                    sum += network[i][j];
                }
                result = Math.min(result, sum);
            }

            sb.append("#").append(t).append(" ").append(result).append("\n");
        }
        System.out.println(sb);
    }
}
