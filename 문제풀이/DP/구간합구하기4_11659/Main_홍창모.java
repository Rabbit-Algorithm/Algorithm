package 문제풀이.DP.구간합구하기4_11659;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_홍창모 {
    static int N, M;
    static int[] ARR;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        ARR = new int[N+1];
        ARR[0] = 0;

        st = new StringTokenizer(br.readLine());
        for( int i = 0; i < N; i++ ) {
            ARR[i+1] = ARR[i] + Integer.parseInt(st.nextToken());
        }

        for( int i = 0; i < M; i++ ) {
            st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            int result = ARR[end] - ARR[start-1];

            sb.append(result).append("\n");
        }

        System.out.print(sb);

    }
}
