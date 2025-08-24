package 바킹독_과제._5주차_이분탐색.골드.좋다_1253;

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
        for(int i=0; i<N; i++) {
            ARR[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(ARR);
        int count = 0;

        for (int i = 0; i < N; i++) {
            boolean found = false;
            for (int j = 0; j < N; j++) {
                if (i == j) continue;
                int target = ARR[i] - ARR[j];
                if (binarySearch(target, j, i)) {
                    found = true;
                    break;
                }
            }
            if (found) count++;
        }

        System.out.println(count);
    }

    private static boolean binarySearch(int target, int exclude1, int exclude2) {
        int left = 0;
        int right = ARR.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (ARR[mid] == target && mid != exclude1 && mid != exclude2) {
                return true;
            }
            if (ARR[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return false;
    }
}
