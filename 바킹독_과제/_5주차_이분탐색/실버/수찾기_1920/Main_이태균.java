package 바킹독_과제._5주차_이분탐색.실버.수찾기_1920;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_이태균 {

    private static int N, M;
    private static int[] N_CARD_LIST;
    private static int[] M_CARD_LIST;

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

        StringBuilder sb = new StringBuilder();
        for (int m : M_CARD_LIST) {
            if (Arrays.binarySearch(N_CARD_LIST, m) < 0) {
                sb.append(0).append("\n");
            } else {
                sb.append(1).append("\n");
            }
        }

        System.out.println(sb.toString().trim());
    }

}