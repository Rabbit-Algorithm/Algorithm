package 바킹독_과제._5주차_이분탐색.골드.멀티버스2_18869;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main_이태균 {

    private static int M, N;
    private static int[][] ARR;
    private static int[][] COMPRESSED;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        ARR = new int[M][N];
        COMPRESSED = new int[M][N];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                ARR[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < M; i++) {
            compress(i);
        }

        int count = 0;

        for (int i = 0; i < M - 1; i++) {
            for (int j = i + 1; j < M; j++) {
                if (isEqual(COMPRESSED[i], COMPRESSED[j])) {
                    count++;
                }
            }
        }

        System.out.println(count);
    }

    // arr[i] 배열을 정렬 후 좌표 압축해 compressed[i]에 저장
    private static void compress(int idx) {
        int[] tmp = ARR[idx].clone();
        Arrays.sort(tmp);

        List<Integer> unique = new ArrayList<>();
        unique.add(tmp[0]);
        for (int i = 1; i < N; i++) {
            if (tmp[i] != tmp[i - 1]) {
                unique.add(tmp[i]);
            }
        }

        for (int i = 0; i < N; i++) {
            int pos = Collections.binarySearch(unique, ARR[idx][i]);
            COMPRESSED[idx][i] = pos;
        }
    }

    private static boolean isEqual(int[] a, int[] b) {
        for (int i = 0; i < N; i++) {
            if (a[i] != b[i]) return false;
        }
        return true;
    }

}
