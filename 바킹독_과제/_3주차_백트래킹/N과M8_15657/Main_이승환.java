package 바킹독_과제._3주차_백트래킹.N과M8_15657;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Main_이승환 {

    static int N,M;
    static int[] inputNums;
    static int[] answer;
    static StringBuilder sb = new StringBuilder();


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        inputNums = new int[N];
        answer = new int[M];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            inputNums[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(inputNums);
        BackTracking(0,0);

        System.out.print(sb);
    }

    private static void BackTracking(int depth,int start) {

        if(depth == M) {
            for (int i = 0; i < M; i++) {
                sb.append(answer[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        for(int i=start; i<N; i++){
                answer[depth] = inputNums[i];
                BackTracking(depth + 1, i);

        }


    }
}
