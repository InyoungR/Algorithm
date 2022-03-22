import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class ETC {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(bf.readLine());

        for (int t = 0; t < T; t++) {
            int N = Integer.parseInt(bf.readLine());
            int[] ans = new int[N + 1];
            StringTokenizer st = new StringTokenizer(bf.readLine());
            for (int i = 1; i <= N; i++) {
                ans[i] = Integer.parseInt(st.nextToken());
            }

            int cnt = 0;
            int[] led = new int[N + 1];
            for (int i = 1; i <= N; i++) {
                if ((ans[i] ^ led[i]) == 1) {
                    for (int j = 1; j * i <= N; j++) {
                        led[j * i] ^= 1;
                    }
                    cnt += 1;
                }
            }
            System.out.println(cnt);
        }
    }
}

