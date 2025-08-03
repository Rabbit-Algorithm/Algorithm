package 바킹독_과제._5주차_이분탐색.골드.용액합성하기_14921;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_진은수 {

    /**
     * 용액
     * https://www.acmicpc.net/problem/2467
     * 골드5
     */

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(br.readLine());
        long[] arr = new long[num];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < num; i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }


        long min = Long.MAX_VALUE;
        long answer = 0;

        for (int i = 0; i < num - 1; i++) {
            int low = i + 1;
            int high = num - 1;

            while (low <= high) {

                int mid = (low + high) / 2;
                long diff = arr[mid] + arr[i];

                if (Math.abs(diff) < min) {
                    min = Math.abs(diff);
                    answer = diff;
                }

                if (diff == 0) {
                    break;
                } else if (diff > 0) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }


        }


        System.out.println(answer);

    }


}
