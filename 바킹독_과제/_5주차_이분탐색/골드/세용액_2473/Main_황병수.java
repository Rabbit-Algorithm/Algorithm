package 바킹독_과제._5주차_이분탐색.골드.세용액_2473;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_황병수 {

    static int N;
    static int[] NList;
    static int[] result = new int[3];
    static int minValue = Integer.MAX_VALUE;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        NList = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
             NList[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(NList);

        for (int i = 0; i < N - 2; i++) {
            int left = i + 1;
            int right = N - 1;

            while (left < right) {
                int sum = NList[i] + NList[left] + NList[right];
                if (Math.abs(sum) <= Math.abs(minValue)) {
                    minValue = sum;
                    result[0] = NList[i];
                    result[1] = NList[left];
                    result[2] = NList[right];
                }

                if (sum == 0) {
                    System.out.println(result[0] + " " + result[1] + " " + result[2]);
                    break;
                } else if (sum > 0) {
                    right --;
                } else {
                    left ++;
                }
            }
        }

        System.out.println(result[0] + " " + result[1] + " " + result[2]);
    }
}
