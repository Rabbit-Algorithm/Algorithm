package 삼성SW.문제풀이.퇴사_14501;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_홍창모 {

    static int N, MAX = Integer.MIN_VALUE;
    static int[] DP;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        DP = new int[N+1];
        DP[0] = 0;

        StringTokenizer st;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            int day = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            DP[i + 1] = Math.max(DP[i+1], DP[i]);

            if( i + day <= N ) {
                DP[i + day] = Math.max(DP[i+day], DP[i] + cost);
            }
        }

        for (int i = 1; i <= N; i++) {
            MAX = Math.max(DP[i], MAX);
        }

        System.out.println(MAX);
    }
}
