package 바킹독_과제._5주차_이분탐색.골드.공유기설치_2110;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_이태균 {

    private static int N, C;
    private static int[] HOUSE_ARR;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        HOUSE_ARR = new int[N];
        for (int i = 0; i < N; i++) {
            HOUSE_ARR[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(HOUSE_ARR);

        int left = 1;
        int right = HOUSE_ARR[N - 1] - HOUSE_ARR[0];
        int result = 0;

        while (left <= right) {
            int mid = (left + right) / 2;
            int count = 1;
            int lastInstalled = HOUSE_ARR[0];

            for (int i = 1; i < N; i++) {
                if (HOUSE_ARR[i] - lastInstalled >= mid) {
                    count++;
                    lastInstalled = HOUSE_ARR[i];
                }
            }

            if (count >= C) {
                result = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        System.out.println(result);
    }
}
