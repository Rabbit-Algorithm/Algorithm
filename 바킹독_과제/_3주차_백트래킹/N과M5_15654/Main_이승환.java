package 바킹독_과제._3주차_백트래킹.N과M5_15654;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Main_이승환 {

    static int N,M;
    static int[] arr;
    static int[] answer;
    static int[] visited;




    static StringBuilder sb = new StringBuilder();


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N+1];
        answer = new int[M];
        visited = new int[N+1];

        st = new StringTokenizer(br.readLine());
        for(int i=1; i<=N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);
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

        for(int i=1; i<=N; i++){
            if(visited[i] == 0) {
                visited[i] = 1;
                answer[depth] = arr[i];
                BackTracking(depth + 1);
                visited[i] = 0;
            }
        }


    }
}
