package 문제풀이.DP.퇴사2_15486;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 홍창모_Main {

    static int N, MAX =  Integer.MIN_VALUE;
    static int[] ARR;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        ARR = new int[N+1];
        ARR[0] = 0;

        StringTokenizer st;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int days = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            ARR[i + 1] = Math.max(ARR[i+1], ARR[i]);

            if( i + days <= N ) {
                ARR[i + days] = Math.max(ARR[i+days], ARR[i] + cost);
            }
        }

        for (int i = 1; i <= N; i++) {
            MAX = Math.max(MAX, ARR[i]);
        }

        System.out.println(MAX);

    }
}
