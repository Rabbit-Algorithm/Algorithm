package _7주차_이분탐색.골드.멀티버스2_18869;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_진은수 {

    /**
     * 멀티버스2
     * https://www.acmicpc.net/problem/18869
     * 골드5
     */

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        int[][] arr = new int[m][n];
        int[][] sort = new int[m][n];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                sort[i][j] = arr[i][j];
            }
            Arrays.sort(sort[i]);

        }


        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = lowerBound(sort[i], arr[i][j]);

            }
        }

        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = i+1; j < m; j++) {
                if (Arrays.equals(arr[i], arr[j])){
                    count++;
                }
            }
        }

        System.out.println(count);

    }


    private static int lowerBound(int[] arr, int target) {
        int left = 0;
        int right = arr.length ;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] > target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

}
