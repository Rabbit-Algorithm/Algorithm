package 바킹독_과제._5주차_이분탐색.골드.휴게소세우기_1477;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_이태균 {

    private static int N, M, L;
    private static int[] REST_ARR;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());

        REST_ARR = new int[N + 2];
        REST_ARR[0] = 0;
        REST_ARR[N + 1] = L;

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            REST_ARR[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(REST_ARR);

        int left = 1;
        int right = L;
        int answer = 0;

        while (left <= right) {
            int mid = (left + right) / 2;
            int count = getCount(mid);

            if (count <= M) {
                answer = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        System.out.println(answer);
    }

    private static int getCount(int distance) {
        int count = 0;
        for (int i = 1; i < REST_ARR.length; i++) {
            int gap = REST_ARR[i] - REST_ARR[i - 1];
            count += (gap - 1) / distance;
        }
        return count;
    }
}
