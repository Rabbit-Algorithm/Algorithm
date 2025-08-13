package _5주차_이분탐색.실버.랜선자르기_1654;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_홍창모 {

    static int K, N;
    static long[] LAN;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        K = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        LAN = new long[K];

        for( int i = 0; i < K; i++ ) {
            LAN[i] = Long.parseLong(br.readLine());
        }

        Arrays.sort(LAN);

        binarySearch();
    }

    private static void binarySearch() {

        long lt = 1;
        // 최대값은 정렬 후 가장 마지막 인덱스
        long rt = LAN[K-1];

        while (lt <= rt) {
            long mid = lt + (rt-lt) / 2;
            long cnt = 0;

            for( int i = 0; i < K; i++ ) {
                cnt += LAN[i] / mid;
            }

            if( cnt >= N ) {
                lt = mid + 1;
            } else {
                rt = mid - 1;
            }
        }

        System.out.println(rt);
    }
}
