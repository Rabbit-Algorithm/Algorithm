package 바킹독_과제._4주차_백트래킹.부분수열의합_1182;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_이태균 {

    private static int N, S;
    private static int[] ARR;
    private static boolean[] VISITED;
    private static int COUNT = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());

        ARR = new int[N];
        VISITED = new boolean[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            ARR[i] = Integer.parseInt(st.nextToken());
        }

        backtracking(0, 0);
        System.out.println(COUNT);
    }

    private static void backtracking(int depth, int sum) {
        if (sum == S && depth > 0) {
            COUNT++;
        }

        for (int i = depth; i < N; i++) {
            backtracking(i + 1, sum + ARR[i]);
        }
    }

}