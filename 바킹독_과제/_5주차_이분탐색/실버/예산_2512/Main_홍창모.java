package _5주차_이분탐색.실버.예산_2512;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_홍창모 {

    static int N, M;
    static int[] REQUEST;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 지방의 수
        N = Integer.parseInt(br.readLine());
        REQUEST = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        
        for( int i = 0; i < N; i++ ) {
            REQUEST[i] = Integer.parseInt(st.nextToken());
        }

        // 국가예산의 총액
        M = Integer.parseInt(br.readLine());

        Arrays.sort(REQUEST);

        binarySearch();
    }

    private static void binarySearch() {
        int lt = 1;
        int rt = REQUEST[N-1];

        while (lt <= rt) {
            int mid = lt + (rt - lt) / 2;
            long total = 0;

            for( int i = 0; i < N; i++ ) {
                if( REQUEST[i] >= mid ) {
                    total += mid;
                } else {
                    total += REQUEST[i];
                }
            }

            if( total <= M ) {
                lt = mid + 1;
            } else {
                rt = mid - 1;
            }
        }

        System.out.println(rt);
    }
}
