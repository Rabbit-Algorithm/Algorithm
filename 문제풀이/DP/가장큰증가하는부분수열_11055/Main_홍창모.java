package 문제풀이.DP.가장큰증가하는부분수열_11055;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_홍창모 {

    static int N;
    static int[] ARR, DP;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        ARR = new int[N+1];
        DP = new int[N+1];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 1; i <= N; i++) {
            ARR[i] = Integer.parseInt(st.nextToken());
        }

        ARR[0] = 0;

        for (int i = 1; i <= N; i++) {

            DP[i] = ARR[i];

            for (int j = 1; j <= i; j++) {

                if( ARR[j] < ARR[i] ) {
                    DP[i] = Math.max(DP[i], DP[j] + ARR[i]);
                }

            }
        }

        int maxSum = 0;

        for (int i = 1; i <= N; i++) {
            maxSum = Math.max(DP[i], maxSum);
        }

        System.out.println(maxSum);
    }
}
