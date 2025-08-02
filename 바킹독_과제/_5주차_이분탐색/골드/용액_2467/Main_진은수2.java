package 바킹독_과제._5주차_이분탐색.골드.용액_2467;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_진은수2 {

    /**
     * 용액
     * https://www.acmicpc.net/problem/2467
     * 골드5
     */

    // 이분탐색 풀이
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(br.readLine());
        long[] arr = new long[num];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < num; i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }


        long min = Long.MAX_VALUE;
        long lower = 0;
        long upper = 0;


        for (int i = 0; i < num - 1; i++) {
            int low = i + 1;
            int high = num - 1;

            while (low <= high) {

                int mid = (low + high) / 2;
                long diff = arr[mid] + arr[i];

                /**
                 * 여기 위치에 아래 코드가 있어야 하는게 이해가 안 감..
                 * 이분 탐색 끝나고 나서 하면 안 되나..?
                 *
                 * // input
                 * 3
                 * 999999997 999999998 999999999
                 *
                 * // output
                 * 999999997 999999998
                 *
                 * https://www.acmicpc.net/source/97041112
                 */
                if (Math.abs(diff) < min) {
                    min = Math.abs(diff);
                    lower = arr[i];
                    upper = arr[mid];
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


        System.out.println(lower + " " + upper);


    }


}
