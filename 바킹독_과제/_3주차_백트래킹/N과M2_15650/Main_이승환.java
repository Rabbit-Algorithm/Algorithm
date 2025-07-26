package 바킹독_과제._3주차_백트래킹.N과M2_15650;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_이승환 {

    static int N,M;
    static int[] arr;
    static int[] visited;


    //start를 줘서 검증 처리를 하는게 포인트
    //처음에 while문으로 하려다가 잘 안됏음.
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        visited = new int[N+1];
        arr = new int[M];

        BackTracking(0,1);
    }

    private static void BackTracking(int depth,int start) {

            if(depth == M) {
                for (int i = 0; i < M; i++) {
                    System.out.print(arr[i] + " ");
                }
                System.out.println();
                return;
            }

            for(int i=start; i<=N; i++){
                arr[depth] = i;
                BackTracking(depth+1, i+1);

            }
    }
}
