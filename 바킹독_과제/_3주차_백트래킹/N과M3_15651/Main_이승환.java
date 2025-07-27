package 바킹독_과제._3주차_백트래킹.N과M3_15651;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//초기 코드 (시간초과가 남)
public class Main_이승환 {

    static int N,M;
    static int[] arr;
    static int[] visited;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        visited = new int[N+1];
        arr = new int[M];

        BackTracking(0);
    }

    private static void BackTracking(int depth) {

            if(depth == M) {
                for (int i = 0; i < M; i++) {
                    System.out.print(arr[i] + " ");
                }
                System.out.println();
                return;
            }

            for(int i=1; i<=N; i++){
                if(visited[i] == 0){
                    visited[i] = 1;
                    arr[depth] = i;
                    visited[i] = 0;

                }
                    BackTracking(depth+1);

            }
    }
}
