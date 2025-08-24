package 바킹독_과제._5주차_이분탐색.실버.좌표압축_18870;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main_이태균 {

    private static int N;
    private static int[] N_LIST;
    private static StringBuilder SB = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        N_LIST = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            N_LIST[i] = Integer.parseInt(st.nextToken());
        }

        int[] sorted = Arrays.stream(N_LIST).distinct().toArray();
        Arrays.sort(sorted);

        for (int num : N_LIST) {
            int idx = lowerBound(sorted, num);
            SB.append(idx).append(" ");
        }
        System.out.println(SB.toString().trim());
    }

    private static int lowerBound(int[] arr, int target) {
        int left = 0;
        int right = arr.length;

        while (left < right) {
            int mid = (left + right) / 2;
            if (arr[mid] >= target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}
