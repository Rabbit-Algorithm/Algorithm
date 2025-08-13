package _5주차_이분탐색.실버.과자나눠주기_16401;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_홍창모 {

    static int N, M;
    static int[] SNACKS;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        SNACKS = new int[N];

        st = new StringTokenizer(br.readLine());

        for( int i = 0; i < N; i++ ) {
            SNACKS[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(SNACKS);

        binarySearch();
    }

    private static void binarySearch() {
        int lt = 1;
        int rt = SNACKS[N-1];

        while (lt <= rt) {
            int mid = lt + (rt - lt) / 2;
            int slice = 0;

            for( int i = 0; i < N; i++ ) {
                if( SNACKS[i] >= mid ) {
                    slice += SNACKS[i] / mid;
                }
            }

            if( slice >= M ) {
                lt = mid + 1;
            } else {
                rt = mid - 1;
            }

        }

        System.out.println(rt);
    }
}
