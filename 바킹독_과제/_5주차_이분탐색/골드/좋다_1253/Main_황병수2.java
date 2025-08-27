package 바킹독_과제._5주차_이분탐색.골드.좋다_1253;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


/**
 * 투포인터
 */
public class Main_황병수2 {
    static int[] list;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        list = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            list[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(list);

        int count = 0;
        for (int i = 0; i < N; i++) {
            if (isGood(i)) {
                count++;
            }
        }

        System.out.println(count);
    }

    // list[targetIndex]가 좋은 수인지 투 포인터로 확인
    static boolean isGood(int targetIndex) {
        int target = list[targetIndex];
        int left = 0, right = N - 1;

        while (left < right) {
            // 자기 자신(targetIndex)은 건너뛰기
            if (left == targetIndex) {
                left++;
                continue;
            }
            if (right == targetIndex) {
                right--;
                continue;
            }

            int sum = list[left] + list[right];

            if (sum == target) {
                return true; // 좋은 수 발견!
            } else if (sum < target) {
                left++; // 합이 작으면 더 큰 값 필요
            } else {
                right--; // 합이 크면 더 작은 값 필요
            }
        }

        return false;
    }
}