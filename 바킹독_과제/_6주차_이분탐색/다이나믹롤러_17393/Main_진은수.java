package 바킹독_과제._6주차_이분탐색.다이나믹롤러_17393;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_진은수 {

    /**
     * 다이나믹 롤러
     * 실버3
     * 이분탐색
     */

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(br.readLine());

        long[] ink = new long[num];
        long[] strength = new long[num];

        StringTokenizer st = new StringTokenizer(br.readLine());
        StringTokenizer st1 = new StringTokenizer(br.readLine());

        for (int i = 0; i < num; i++) {
            ink[i] = Long.parseLong(st.nextToken());
            strength[i] = Long.parseLong(st1.nextToken());
        }


        long[] answer = new long[num];
        for (int i = 0; i < num; i++) {

            long inkVal = ink[i];

            int low = i;
            int high = num - 1;

            while (low <= high) {

                int mid = (low + high) / 2;

                if (strength[mid] > inkVal) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }

            }

            answer[i] = high - i;
        }

        StringBuilder sb = new StringBuilder();
        for (long i : answer) {
            sb.append(i).append(" ");
        }

        System.out.println(sb.toString());


    }

}