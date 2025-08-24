package 바킹독_과제._5주차_이분탐색.골드.합이0_3151;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_이태균 {

    static int N;
    static int[] ARR;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        ARR = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            ARR[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(ARR);

        long answer = 0L;

        for (int i = 0; i < N - 2; i++) {
            for (int j = i + 1; j < N - 1; j++) {
                int target = -(ARR[i] + ARR[j]);
                int left = lowerBound(j + 1, N - 1, target);
                int right = upperBound(j + 1, N - 1, target);
                answer += (right - left);
            }
        }

        System.out.println(answer);
    }

    // target 이상의 값이 처음 나오는 위치
    private static int lowerBound(int left, int right, int target) {
        int result = right + 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (ARR[mid] >= target) {
                result = mid;
                right = mid -1;
            } else {
                left = mid + 1;
            }
        }
        return result;
    }

    // target 초과하는 값이 처음 나오는 위치
    private static int upperBound(int left, int right, int target) {
        int result = right + 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (ARR[mid] > target) {
                result = mid;
                right = mid -1;
            } else {
                left = mid + 1;
            }
        }
        return result;
    }
}
