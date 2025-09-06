package _7주차_이분탐색.골드.용액_2467;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_이태균 {

    static int N;
    static int[] ARR;
    static long MIN = Long.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        ARR = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            ARR[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(ARR);

        int ans1 = 0;
        int ans2 = 0;

        for (int i = 0; i < N - 1; i++) {
            // 고정된 용액과 나머지 범위(i + 1 ~ N - 1)에서 이분 탐색
            int left = i + 1;
            int right = N - 1;

            while (left <= right) {
                int mid = (left + right) / 2;
                long sum = (long) ARR[i] + ARR[mid];

                // 현재 합의 절댓값이 기존 최솟값보다 작으면 갱신
                if (Math.abs(sum) < MIN) {
                    MIN = Math.abs(sum);
                    ans1 = ARR[i];
                    ans2 = ARR[mid];
                }

                if (sum < 0) {
                    left = mid + 1;
                } else if (sum > 0) {
                    right = mid - 1;
                } else {
                    System.out.println(ARR[i] + " " + ARR[mid]);
                    return;
                }
            }
        }

        System.out.println(ans1 + " " + ans2);
    }
}