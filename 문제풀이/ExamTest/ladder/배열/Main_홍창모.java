package 문제풀이.ExamTest.ladder.배열;

import java.io.IOException;

public class Main_홍창모 {

    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        int n = 4;
        int[][] ladder = {{1,0,1}, {0,1,0}, {0,0,1}, {0,0,0}, {1,0,0}};

        int[] answer = solution(n, ladder);

        for (int x : answer) {
            System.out.print(x + " ");
        }
    }

    public static int[] solution(int n, int[][] ladder) {
        int[] answer = new int[n];

        for (int start = 0; start < n; start++) {
            int col = start;
            for (int row = 0; row < ladder.length; row++) {

                if (col < n - 1 && ladder[row][col] == 1) {
                    col++;
                } else if (col > 0 && ladder[row][col - 1] == 1) {
                    col--;
                }
                // 아니면 아래로 이동
            }

            // 0 부터 시작하므로 +1 처리
            answer[start] = col + 1;
        }
        return answer;
    }
}
