package 문제풀이.백트래킹.스타트와링크_14889;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_진은수 {

    /**
     * 스타트와 링크
     * https://www.acmicpc.net/problem/14889
     * 실버1
     */

    private static int num;
    private static int min = Integer.MAX_VALUE;

    private static boolean[] visited;
    private static int[][] arr;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        num = Integer.parseInt(br.readLine());
        arr = new int[num][num];
        visited = new boolean[num];

        for (int y = 0; y < num; y++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int x = 0; x < num; x++) {
                arr[y][x] = Integer.parseInt(st.nextToken());
            }
        }


        setTeam(0, -1);

        System.out.println(min);

    }







    private static void setTeam(int depth, int beforeIndex) {
        if (depth == num / 2) {
            calculate();
            return;
        }

        for (int i = beforeIndex + 1; i < num; i++) {
            if (!visited[i]) {
                visited[i] = true;
                setTeam(depth + 1, i);
                visited[i] = false;
            }
        }
    }


    private static void calculate() {

        int[] teamA = new int[num / 2];
        int[] teamB = new int[num / 2];

        int indexA = 0;
        int indexB = 0;

        for (int i = 0; i < num; i++) {
            if (visited[i]) {
                teamA[indexA] = i;
                indexA++;
            } else {
                teamB[indexB] = i;
                indexB++;
            }
        }

        int scoreA = 0;
        int scoreB = 0;

        for (int i = 0; i < num / 2; i++) {
            for (int j = i + 1; j < num / 2; j++) {

                int memberOne = teamA[i];
                int memberTwo = teamA[j];

                scoreA += (arr[memberOne][memberTwo] + arr[memberTwo][memberOne]);

                memberOne = teamB[i];
                memberTwo = teamB[j];
                scoreB += (arr[memberOne][memberTwo] + arr[memberTwo][memberOne]);

            }
        }

        min = Math.min(min, Math.abs(scoreA - scoreB));
    }


}
