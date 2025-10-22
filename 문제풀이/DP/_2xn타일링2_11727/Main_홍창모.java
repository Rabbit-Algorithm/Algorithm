package 문제풀이.DP._2xn타일링2_11727;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_홍창모 {
    static int N;
    static long[] DP;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        DP = new long[N+1];

        DP[0] = 1;
        DP[1] = 1;

        for (int i = 2; i <= N; i++) {
            DP[i] = ((DP[i-2] * 2) + DP[i-1]) % 10_007;
        }

        System.out.println(DP[N]);
    }
}
