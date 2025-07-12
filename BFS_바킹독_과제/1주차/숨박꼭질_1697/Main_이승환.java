package 숨박꼭질_1697;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_이승환 {

    static int X,K;
    static boolean[] visited = new boolean[100_001];


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        X = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        //이걸놓침
        if (X == K) {
            System.out.println(0);
            return;
        }

        BFS(X);
    }

    static void BFS(int X){
        Queue<Integer> Q = new ArrayDeque<>();
        Q.offer(X);
        visited[X] = true;
        int count = 0;

        while (!Q.isEmpty()){
            int size = Q.size();

            for(int i=0; i<size; i++){
                int x = Q.poll();

                // 세 가지 이동 방식
                int[] next = {x - 1, x + 1, x * 2};

                for (int nx : next) {
                    if (nx < 0 || nx > 100_000) continue;

                    if (nx == K) {
                        System.out.println(count + 1);
                        return;
                    }

                    if (!visited[nx]) {
                        visited[nx] = true;
                        Q.offer(nx);
                    }
                }
            }

            count++; // 여기서 증가
        }
    }

}
