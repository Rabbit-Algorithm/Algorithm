package 바킹독_과제._5주차_이분탐색.골드.합이0인네정수_7453;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 이분탐색
 * ================
 * [장점]
 * 약간 느림, 중복처리 자동
 * 각 단계가 명확히 분리
 * 실수할 확률 낮음
 * [단점]
 * 약간 느림, 메모리 지역성 떨어짐
 */
public class Main_황병수2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] A = new int[n];
        int[] B = new int[n];
        int[] C = new int[n];
        int[] D = new int[n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            A[i] = Integer.parseInt(st.nextToken());
            B[i] = Integer.parseInt(st.nextToken());
            C[i] = Integer.parseInt(st.nextToken());
            D[i] = Integer.parseInt(st.nextToken());
        }

        // Meet in the Middle: A+B 그룹과 C+D 그룹으로 나누기
        int[] AB = new int[n * n];
        int[] CD = new int[n * n];

        // A[i] + B[j] 모든 조합 계산
        int idx = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                AB[idx] = A[i] + B[j];
                CD[idx] = C[i] + D[j];
                idx++;
            }
        }

        // CD 배열만 정렬 (이분탐색을 위해)
        Arrays.sort(CD);

        long result = 0;

        // AB의 각 원소에 대해 -(AB[i])가 CD에 몇 개 있는지 찾기
        for (int i = 0; i < n * n; i++) {
            int target = -AB[i];  // AB[i] + target = 0이 되는 target

            // target의 개수를 upper_bound - lower_bound로 구하기
            int lower = lowerBound(CD, target);
            int upper = upperBound(CD, target);

            result += (upper - lower);
        }

        System.out.println(result);
    }

    // target 이상인 첫 번째 위치
    static int lowerBound(int[] arr, int target) {
        int left = 0;
        int right = arr.length;

        while (left < right) {
            int mid = (left + right) / 2;
            if (arr[mid] >= target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    // target 초과인 첫 번째 위치
    static int upperBound(int[] arr, int target) {
        int left = 0;
        int right = arr.length;

        while (left < right) {
            int mid = (left + right) / 2;
            if (arr[mid] > target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}