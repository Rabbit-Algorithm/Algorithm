package 바킹독_과제._5주차_이분탐색.골드.휴게소세우기_1477;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_홍창모 {

    static int N, M, L;

    static int[] REST_AREA_LIST, REST_TEMP_LIST;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 휴게소의 개수
        N = Integer.parseInt(st.nextToken());
        // 더 지으려는 휴게소의 개수
        M = Integer.parseInt(st.nextToken());
        // 고속도로의 길이
        L = Integer.parseInt(st.nextToken());

        if( N == 0 ) {
            // 휴게소가 없으면 고속도로 길이를 M+1로 나눈 값이 최대 거리
            int maxDistance = (L + M) / (M + 1); // 나눗셈 할 때 소수점 올림 고려
            System.out.println(maxDistance);
            return;
        }

        REST_AREA_LIST = new int[N];
        REST_TEMP_LIST = new int[N+1];

        st = new StringTokenizer(br.readLine());

        for( int i = 0; i < N; i++ ) {
            REST_AREA_LIST[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(REST_AREA_LIST);

        // 초기 최소값을 시작점으로
        REST_TEMP_LIST[0] = REST_AREA_LIST[0];

        for( int i = 1; i < N; i++ ) {
            // 두 휴게소의 거리 차이를 저장
            REST_TEMP_LIST[i] = REST_AREA_LIST[i] - REST_AREA_LIST[i-1];
        }

        REST_TEMP_LIST[N] = L - REST_AREA_LIST[N-1];

        System.out.print(binarySearch());
    }

    private static int binarySearch() {
        int left = 1;
        int right = L-1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int count = getRestAreaCount(mid);

            if (count <= M) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }

    public static int getRestAreaCount(int distance) {
        int count = 0;
        for (int i = 0; i <= N; i++) {
            if (REST_TEMP_LIST[i] > distance) {
                count += (REST_TEMP_LIST[i] - 1) / distance;
            }
        }
        return count;
    }
}
