package _5주차_이분탐색.골드.공유기설치_2110;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_홍창모 {

    static int N, C, ANSWER;
    static int[] HOUSE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        HOUSE = new int[N];

        for( int i = 0; i < N; i++ ) {
            HOUSE[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(HOUSE);

        binarySearch();

        System.out.println(ANSWER);
    }

    private static void binarySearch() {
        int left = 1;
        int right = HOUSE[N-1] - HOUSE[0];

        while (left <= right) {
            int mid = left + (right - left) / 2;

            // 처음에는 0번째 index에 설치했다고 가정
            int installed =  HOUSE[0];

            // 0번째 index 설치되었기 때문에 1로 초기화
            int cnt = 1;

            for( int i = 1; i < N; i++ ) {
                if( HOUSE[i] - installed >= mid ) {
                    // 설치된 집과의 거리가 최대값의 절반보다 큰 경우
                    cnt++;
                    installed = HOUSE[i];
                }
            }

            if( cnt >= C ) {
                ANSWER = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

    }
}
