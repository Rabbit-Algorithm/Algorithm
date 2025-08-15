package _5주차_이분탐색.골드.멀티버스2_18869;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_홍창모 {

    static int N, M;
    static int[][] PLANETS, SORT_PLANETS;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        // 초기화
        PLANETS = new int[M][N];
        SORT_PLANETS = new int[M][N];


        for( int i = 0; i < M; i++ ) {
            st = new StringTokenizer(br.readLine());

            for( int j = 0; j < N; j++ ) {
                int planet = Integer.parseInt(st.nextToken());

                PLANETS[i][j] = planet;
                SORT_PLANETS[i][j] = planet;
            }

            Arrays.sort(SORT_PLANETS[i]);
        }

        for( int i = 0; i < M; i++ ) {
            for( int j = 0; j < N; j++ ) {
                PLANETS[i][j] = binarySearch(SORT_PLANETS[i], PLANETS[i][j]);
            }
        }
        int cnt = 0;
        for (int i = 0; i < M; i++) {
            for (int j = i + 1; j < M; j++) {
                if (Arrays.equals(PLANETS[i], PLANETS[j])) {
                    cnt++;
                }
            }
        }

        System.out.println(cnt);
    }

    private static int binarySearch(int[] sortArr, int target) {
        int lt = 0;
        int rt = N - 1;

        while (lt <= rt) {
            int mid = lt + (rt - lt) / 2;
            int midValue = sortArr[mid];

            if( midValue > target ) {
                rt = mid - 1;
            } else if( midValue == target ) {
                return mid;
            } else {
                lt = mid + 1;
            }

        }

        return lt;
    }

}
