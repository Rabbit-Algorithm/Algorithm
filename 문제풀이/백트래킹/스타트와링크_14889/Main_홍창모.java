package 문제풀이.백트래킹.스타트와링크_14889;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_홍창모 {

    static int N;
    static int[][] PEOPLE;
    static boolean[] VISITED;
    static int MIN_DIFF = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        PEOPLE = new int[N][N];
        VISITED = new boolean[N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                PEOPLE[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        backtracking(0, 0);
        System.out.println(MIN_DIFF);
    }

    static void backtracking(int curr, int count) {
        if (count == N / 2) {
            calculateDifference();
            return;
        }

        for (int i = curr; i < N; i++) {
            if (!VISITED[i]) {
                VISITED[i] = true;
                backtracking(i + 1, count + 1);
                VISITED[i] = false;
            }
        }
    }

    static void calculateDifference() {
        int teamStart = 0, teamLink = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (VISITED[i] && VISITED[j]) {
                    teamStart += PEOPLE[i][j];
                } else if (!VISITED[i] && !VISITED[j]) {
                    teamLink += PEOPLE[i][j];
                }
            }
        }

        MIN_DIFF = Math.min(MIN_DIFF, Math.abs(teamStart - teamLink));
    }
}