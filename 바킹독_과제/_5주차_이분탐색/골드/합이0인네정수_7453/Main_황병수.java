package 바킹독_과제._5주차_이분탐색.골드.합이0인네정수_7453;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 투 포인터
 * ================
 * [장점]
 * 빠름
 * 메모리 효율 good
 * [단점]
 * 중복 처리 복잡
 * 구현 실수 위험
 * 디버깅 어려움
 */
public class Main_황병수 {
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

        // 두 배열 모두 정렬 (투 포인터를 위해)
        Arrays.sort(AB);
        Arrays.sort(CD);

        long result = 0;
        int left = 0;                    // AB 포인터 (앞에서부터)
        int right = n * n - 1;           // CD 포인터 (뒤에서부터)

        // 투 포인터로 AB[i] + CD[j] = 0 찾기
        while (left < n * n && right >= 0) {
            int sum = AB[left] + CD[right];

            if (sum == 0) {
                // 같은 값들 개수 세기
                long leftCount = 1, rightCount = 1;
                int leftValue = AB[left], rightValue = CD[right];

                // AB에서 같은 값 개수
                while (left + 1 < n * n && AB[left + 1] == leftValue) {
                    leftCount++;
                    left++;
                }

                // CD에서 같은 값 개수
                while (right - 1 >= 0 && CD[right - 1] == rightValue) {
                    rightCount++;
                    right--;
                }

                result += leftCount * rightCount;
                left++;
                right--;
            } else if (sum < 0) {
                left++;   // 합이 작으면 AB 포인터 오른쪽으로
            } else {
                right--;  // 합이 크면 CD 포인터 왼쪽으로
            }
        }

        System.out.println(result);
    }
}