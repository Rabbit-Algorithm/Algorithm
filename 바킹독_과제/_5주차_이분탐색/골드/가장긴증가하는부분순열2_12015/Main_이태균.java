package 바킹독_과제._5주차_이분탐색.골드.가장긴증가하는부분순열2_12015;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_이태균 {

    private static int N;
    private static int[] ARR;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        ARR = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            ARR[i] = Integer.parseInt(st.nextToken());
        }

        int[] list = new int[N];
        int length = 0;

        for (int i = 0; i < N; i++) {
            int pos = Arrays.binarySearch(list, 0, length, ARR[i]);
            if (pos < 0) pos = -(pos + 1);

            list[pos] = ARR[i];
            if (pos == length) {
                length++;
            }
        }

        System.out.println(length);
    }
}
