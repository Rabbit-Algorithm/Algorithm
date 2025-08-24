package 바킹독_과제._5주차_이분탐색.골드.두배열의합_2143;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main_이태균 {

    private static int T, N;
    private static int[] ARR;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        N = Integer.parseInt(br.readLine());
        ARR = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++)
            ARR[i] = Integer.parseInt(st.nextToken());

        int m = Integer.parseInt(br.readLine());
        int[] B = new int[m];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++)
            B[i] = Integer.parseInt(st.nextToken());

        List<Integer> aSum = new ArrayList<>();
        List<Integer> bSum = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            int sum = 0;

            for (int j = i; j < N; j++) {
                sum += ARR[j];
                aSum.add(sum);
            }
        }

        for (int i = 0; i < m; i++) {
            int sum = 0;
            for (int j = i; j < m; j++) {
                sum += B[j];
                bSum.add(sum);
            }
        }

        Collections.sort(bSum);

        long answer = 0;

        for (int x : aSum) {
            int target = T - x;
            int left = lowerBound(bSum, target);
            int right = upperBound(bSum, target);
            answer += (right - left);
        }

        System.out.println(answer);
    }

    private static int lowerBound(List<Integer> list, int target) {
        int left = 0;
        int right = list.size();

        while (left < right) {
            int mid = (left + right) / 2;

            if (list.get(mid) >= target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    private static int upperBound(List<Integer> list, int target) {
        int left = 0;
        int right = list.size();

        while (left < right) {
            int mid = (left + right) / 2;

            if (list.get(mid) > target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}
