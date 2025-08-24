package 바킹독_과제._5주차_이분탐색.실버.숫자카드2_10816;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_이태균 {

    private static int N, M;
    private static int[] N_CARD_LIST;
    private static int[] M_CARD_LIST;
    private static StringBuilder SB = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        N_CARD_LIST = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            N_CARD_LIST[i] = Integer.parseInt(st.nextToken());
        }

        M = Integer.parseInt(br.readLine());
        M_CARD_LIST = new int[M];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            M_CARD_LIST[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(N_CARD_LIST);

        for (int m : M_CARD_LIST) {
            int count = upperBound(N_CARD_LIST, m) - lowerBound(N_CARD_LIST, m);
            SB.append(count).append(" ");
        }

        System.out.println(SB.toString().trim());
    }

    public static int lowerBound(int[] arr, int target) {
        int left = 0;
        int right = arr.length;

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] >= target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    public static int upperBound(int[] arr, int target) {
        int left = 0;
        int right = arr.length;

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] > target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

}