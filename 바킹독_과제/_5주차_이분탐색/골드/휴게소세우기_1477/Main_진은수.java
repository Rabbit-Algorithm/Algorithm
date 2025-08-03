package 바킹독_과제._5주차_이분탐색.골드.휴게소세우기_1477;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_진은수 {

    /**
     * 휴게소 세우기
     * https://www.acmicpc.net/problem/1477
     * 골드4
     */

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int num = Integer.parseInt(st.nextToken());
        int addNum = Integer.parseInt(st.nextToken());
        int distance = Integer.parseInt(st.nextToken());

        if (num == 0) {
            if (distance%(addNum+1) == 0 ) {
                System.out.println(distance/(addNum+1));
            } else {
                System.out.println(distance/(addNum+1)+1);
            }

            return;
        }

        st = new StringTokenizer(br.readLine());
        int[] arr = new int[num];
        int[] absArr = new int[num+1];
        for (int i = 0; i < num; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        absArr[0] = arr[0];
        for (int i = 1; i < num; i++) {
            absArr[i] = arr[i] - arr[i - 1];
        }
        absArr[num] = distance-arr[num-1];

        int low = 1;
        int high = distance - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            int sum = 0;

            for (int i = 0; i < num+1; i++) {
                if (absArr[i] % mid == 0) {
                    sum += (absArr[i] / mid);
                    sum--;
                } else {
                    sum += (absArr[i] / mid);
                }
            }

            if (sum > addNum) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        System.out.println(low);


    }


}
