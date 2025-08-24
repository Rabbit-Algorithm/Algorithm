package 바킹독_과제._5주차_이분탐색.골드.합이0_3151;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main_홍창모 {
    static int[] STUDENTS;
    static List<Integer> SUM_GRADE;
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        STUDENTS = new int[N];
        SUM_GRADE = new ArrayList<>();

        StringTokenizer st = new StringTokenizer(br.readLine());

        for( int i = 0; i < N; i++ ) {
            STUDENTS[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(STUDENTS);

        // a, b, c 학생이 있는 경우
        // a + b + c = 0 인 경우를 찾아야함 따라서 a + b = -c 로 탐색

        long cnt = 0;

        for( int i = 0; i < N; i++ ) {
            for( int j = i+1; j < N; j++ ) {
                int sum = STUDENTS[i] + STUDENTS[j];
                int target = sum * (-1);

                // 동일한 코딩 실력 찾음
                int upper = upperBound(target, j + 1, N);
                int lower = lowerBound(target, j + 1, N);

                cnt += (upper - lower);
            }
        }

        System.out.println(cnt);
    }

    public static int lowerBound(int target, int lt, int rt) {
        // target이 시작하는 가장 왼쪽 인덱스를 찾는다.
        while (lt < rt) {
            int mid = lt + (rt - lt) / 2;

            if (STUDENTS[mid] >= target) {
                rt = mid;
            } else {
                lt = mid + 1;
            }
        }

        return lt;
    }

    public static int upperBound(int target, int lt, int rt) {

        // target이 끝나는 가장 오른쪽 인덱스를 찾는다.

        while (lt < rt) {
            int mid = lt + (rt - lt) / 2;

            if (STUDENTS[mid] > target) {
                rt = mid;
            } else {
                lt = mid + 1;
            }
        }

        return lt;
    }
}
