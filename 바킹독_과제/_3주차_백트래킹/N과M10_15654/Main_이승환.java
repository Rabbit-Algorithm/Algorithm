package 바킹독_과제._3주차_백트래킹.N과M10_15654;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 처음에 Set으로 접근했다가 틀림
public class Main_이승환 {

    static int N,M;
    static int[] inputNums;
    static int[] answer;
    static boolean[] visited;

    static StringBuilder sb = new StringBuilder();


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        inputNums = new int[N];
        visited = new boolean[N];
        answer = new int[M];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            inputNums[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(inputNums);

        BackTracking(0);
        System.out.print(sb);
    }

    private static void BackTracking(int depth) {

        if(depth == M) {
            for (int i = 0; i < M; i++) {
                sb.append(answer[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        int lastUsed = 0;
        for (int i = 0; i < N; i++) {
            // 1. 아직 사용하지 않은 숫자이고,
            // 2. 이전에 만들어진 수열의 마지막 숫자와 현재 숫자가 다른 경우에만 탐색
            if (!visited[i] && lastUsed != inputNums[i]) {
                visited[i] = true;
                answer[depth] = inputNums[i];
                lastUsed = inputNums[i]; // 마지막으로 사용된 숫자를 기록
                BackTracking(depth + 1);
                visited[i] = false;
            }
        }


    }
}
