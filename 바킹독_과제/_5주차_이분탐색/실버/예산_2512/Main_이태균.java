package 바킹독_과제._5주차_이분탐색.실버.예산_2512;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_이태균 {

    private static int N;
    private static int[] arr;
    private static int M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        M = Integer.parseInt(br.readLine());

        Arrays.sort(arr);

        int answer = binarySearch(arr[N - 1]);
        System.out.println(answer);
    }

    private static int binarySearch(int right) {
        int left = 0;
        int answer = 0;

        while (left <= right) {
            int mid = (left + right) / 2;
            long total = getBudgetSum(mid);

            if (total <= M) {
                answer = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return answer;
    }

    private static long getBudgetSum(int length) {
        long sum = 0;

        for (int budget : arr) {
            sum += (budget > length) ? length : budget;
        }
        return sum;
    }

}
