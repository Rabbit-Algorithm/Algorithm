package 문제풀이.구현.체스판다시칠하기_1018_실버3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_홍창모 {

    static int N, M, ANSWER = Integer.MAX_VALUE;
    static char[][] BOARD;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); // 행 개수 (세로)
        M = Integer.parseInt(st.nextToken()); // 열 개수 (가로)

        BOARD = new char[N][M];

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                BOARD[i][j] = str.charAt(j);
            }
        }

        // 모든 가능한 8x8 시작점을 순회
        for (int i = 0; i <= N - 8; i++) {
            for (int j = 0; j <= M - 8; j++) {
                int count = countRepaint(i, j);
                ANSWER = Math.min(ANSWER, count);
            }
        }

        System.out.print(ANSWER);
    }

    // 시작점 (startRow, startCol)에서 8x8 영역을 체스판으로 만들기 위해 칠해야 할 최소 칸 수
    private static int countRepaint(int startRow, int startCol) {
        int countW = 0; // (0,0)이 'W'로 시작하는 패턴과 비교
        int countB = 0; // (0,0)이 'B'로 시작하는 패턴과 비교

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                char current = BOARD[startRow + i][startCol + j];

                // (i+j)가 짝수면 시작색, 홀수면 반대색이어야 함
                if ((i + j) % 2 == 0) {
                    if (current != 'W') countW++;
                    if (current != 'B') countB++;
                } else {
                    if (current != 'B') countW++;
                    if (current != 'W') countB++;
                }
            }
        }

        return Math.min(countW, countB);
    }

}
