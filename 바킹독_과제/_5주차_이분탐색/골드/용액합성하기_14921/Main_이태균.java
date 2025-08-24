package 바킹독_과제._5주차_이분탐색.골드.용액합성하기_14921;

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
        for (int i = 0; i < N; i++) {
            ARR[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(ARR);

        int preSum = ARR[0] + ARR[1];

        for (int i = 0; i < N; i++) {
            int target = -ARR[i];
            int idx = binarySearch(target, i);

            for (int j : new int[]{idx, idx - 1, idx + 1}) {
                if (j >= 0 && j < N && j != i) {
                    int sum = ARR[i] + ARR[j];
                    if (Math.abs(sum) < Math.abs(preSum)) {
                        preSum = sum;
                    }
                }
            }
        }

        System.out.println(preSum);
    }

    private static int binarySearch(int target, int excludeIdx) {
        int left = 0;
        int right = ARR.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (ARR[mid] == target && mid != excludeIdx) {
                return mid;
            }

            if (ARR[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        if (left >= ARR.length) {
            left = ARR.length - 1;
        }
        if (right < 0) {
            right = 0;
        }

        int leftDiff = (left != excludeIdx) ? Math.abs(ARR[left] - target) : Integer.MAX_VALUE;
        int rightDiff = (right != excludeIdx) ? Math.abs(ARR[right] - target) : Integer.MAX_VALUE;

        return (leftDiff < rightDiff) ? left : right;
    }
}
