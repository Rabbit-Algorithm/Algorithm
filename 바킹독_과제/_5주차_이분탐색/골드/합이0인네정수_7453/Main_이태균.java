package 바킹독_과제._5주차_이분탐색.골드.합이0인네정수_7453;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_이태균 {

    private static int N;
    private static int[] A, B, C, D;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        A = new int[N];
        B = new int[N];
        C = new int[N];
        D = new int[N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            A[i] = Integer.parseInt(st.nextToken());
            B[i] = Integer.parseInt(st.nextToken());
            C[i] = Integer.parseInt(st.nextToken());
            D[i] = Integer.parseInt(st.nextToken());
        }

        int size = N * N;
        int[] AB = new int[size];
        int[] CD = new int[size];

        int idx = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                AB[idx] = A[i] + B[j];
                CD[idx] = C[i] + D[j];
                idx++;
            }
        }

        Arrays.sort(AB);
        Arrays.sort(CD);

        long count = 0L;
        int left = 0;
        int right = size - 1;

        while (left < size && right >= 0) {
            int sum = AB[left] + CD[right];

            if (sum == 0) {
                long countLeft = 1;
                long countRight = 1;

                while (left + 1 < size && AB[left] == AB[left + 1]) {
                    countLeft++;
                    left++;
                }
                while (right - 1 >= 0 && CD[right] == CD[right - 1]) {
                    countRight++;
                    right--;
                }

                count += countLeft * countRight;
                left++;
                right--;
            } else if (sum < 0) {
                left++;
            } else {
                right--;
            }
        }

        System.out.println(count);
    }
}
