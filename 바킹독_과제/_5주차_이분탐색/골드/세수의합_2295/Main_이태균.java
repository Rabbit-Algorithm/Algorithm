package 바킹독_과제._5주차_이분탐색.골드.세수의합_2295;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main_이태균 {

    private static int N;
    private static int[] ARR;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        ARR = new int[N];

        for (int i = 0; i < N; i++) {
            ARR[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(ARR);

        List<Integer> sumList = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j <= i; j++) {
                sumList.add(ARR[i] + ARR[j]);
            }
        }

        Collections.sort(sumList);

        for (int k = N - 1; k >= 0; k--) {
            for (int l = 0; l <= k; l++) {
                int diff = ARR[k] - ARR[l];
                if (binarySearch(sumList, diff)) {
                    System.out.println(ARR[k]);
                    return;
                }
            }
        }
    }

    private static boolean binarySearch(List<Integer> list, int target) {
        int left = 0;
        int right = list.size() - 1;

        while (left <= right) {
            int mid = (left + right) / 2;
            int val = list.get(mid);

            if (val == target)
                return true;
            if (val < target)
                left = mid + 1;
            else
                right = mid - 1;
        }

        return false;
    }
}
