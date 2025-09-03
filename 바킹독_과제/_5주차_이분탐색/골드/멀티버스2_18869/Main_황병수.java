package _5주차_이분탐색.골드.멀티버스2_18869;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_황병수 {

    static int M;
    static int N;
    static int R;

    static int[][] originList;
    static int[][] sortedList;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        originList = new int[M][N];
        sortedList = new int[M][N];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int tempNum = Integer.parseInt(st.nextToken());
                 originList[i][j] = tempNum;
            }

            sortedList[i] = originList[i].clone();    // 내부적으로 arraycopy 호출
            Arrays.sort(sortedList[i]);
        }

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                originList[i][j] = lowerBound(sortedList[i], originList[i][j]);
            }
        }


        for (int i = 0; i < M; i++) {
            for (int j = i+1; j < M; j++) {
                if (Arrays.equals(originList[i], originList[j])) {
                    R++;
                }
            }
        }

        System.out.println(R);
    }

    static int lowerBound(int[]  sortedList, int target) {
        int left = 0;
        int right = sortedList.length;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (sortedList[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return left;
    }
}
