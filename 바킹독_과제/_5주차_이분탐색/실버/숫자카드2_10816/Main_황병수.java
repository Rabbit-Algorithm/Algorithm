package 바킹독_과제._5주차_이분탐색.실버.숫자카드2_10816;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_황병수 {
    static int N, M;
    static int[] NList, MList;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        NList = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            NList[i] = Integer.parseInt(st.nextToken());
        }

        M = Integer.parseInt(br.readLine());
        MList = new int[M];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            MList[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(NList);

        for (int i = 0; i < M; i++) {
            int count = upperBound(MList[i]) - lowerBound(MList[i]);
            sb.append(count).append(" ");
        }
        System.out.println(sb);
    }

    private static int lowerBound(int value) {
        int left = 0;
        int right = N;

        while (left < right) {
            int mid = (left + right) / 2;
            if (NList[mid] >= value) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    private static int upperBound(int value) {
        int left = 0;
        int right = N;

        while (left < right) {
            int mid = (left + right) / 2;
            if (NList[mid] > value) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}
