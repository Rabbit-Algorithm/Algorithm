package _5주차_이분탐색.실버.나무자르기_2805;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_홍창모 {

    static int N, M;
    static int[] TREE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        TREE = new int[N];

        st = new StringTokenizer(br.readLine());
        for( int i = 0; i < N; i++ ) {
            TREE[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(TREE);

        binarySearch();
    }

    private static void binarySearch() {
        int lt = 1;
        // 최대값은 배열의 마지막 인덱스
        int rt = TREE[N-1];

        while (lt <= rt) {
            int mid = lt + (rt - lt) / 2;
            long total = 0;

            for( int i = 0; i < N; i++ ) {
                if( TREE[i] > mid ) {
                    total += TREE[i] - mid;
                }
            }

            if( total >= M ) {
                lt = mid + 1;
            } else {
                rt = mid - 1;
            }

        }

        System.out.println(rt);
    }


}
