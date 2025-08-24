package _5주차_이분탐색.실버.좌표압축_18870;

import java.io.*;
import java.util.*;

public class Main_홍창모 {
    static int N;
    static int[] ARR1;
    static int[] sortedUnique;
    static StringBuilder SB;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        ARR1 = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            ARR1[i] = Integer.parseInt(st.nextToken());
        }

        // 중복 제거 후 정렬
        sortedUnique = Arrays.stream(ARR1).distinct().sorted().toArray();

        SB = new StringBuilder();
        for (int i = 0; i < N; i++) {
            int idx = binarySearch(ARR1[i]);
            SB.append(idx).append(" ");
        }

        System.out.println(SB);
    }


    private static int binarySearch(int target) {
        int lt = 0;
        int rt = sortedUnique.length - 1;
        while (lt <= rt) {
            int mid = lt + (rt - lt) / 2;
            if (sortedUnique[mid] < target) {
                lt = mid + 1;
            } else if (sortedUnique[mid] > target) {
                rt = mid - 1;
            } else {
                return mid; // index = 작은 값 개수
            }
        }
        return -1; // not found
    }
}
