package 바킹독_과제._5주차_이분탐색.골드.가장긴증가하는부분순열2_12015;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main_진은수 {

    /**
     * 가장 긴 증가하는 부분 순열2
     * https://www.acmicpc.net/problem/12015
     * 골드2
     */

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        long[] arr = new long[num];
        long[] tmp = new long[num];
        for (int i = 0; i < num; i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }

        int index = 1;
        tmp[0] = arr[0];
        for (int i = 1; i < num; i++) {

            // 삽입
            if (arr[i] > tmp[index-1]) {
                tmp[index] = arr[i];
                index++;
            } else { // 대치
                int point = replace(tmp, arr[i], index);
                tmp[point] = arr[i];
            }

        }

        System.out.println(index);


    }


    private static int replace(long[] arr, long target, int end) {
        int low = 0;
        int high = end;

        while (low < high) {
            int mid = (low + high) / 2;

            if (target > arr[mid]) {
                low = mid +1;
            } else {
                high = mid;
            }
        }

        return low;
    }


}
