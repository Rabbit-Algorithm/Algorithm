package BFS.침투_13565;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;
// 송아지 찾기
/*
* 현수는 송아지를 잃어버렸다. 다행히 송아지에는 위치추적기가 달려 있다. 현수의 위치와 송아
지의 위치가 수직선상의 좌표 점으로 주어지면 현수는 현재 위치에서 송아지의 위치까지 다음
과 같은 방법으로 이동한다. 송아지는 움직이지 않고 제자리에 있다.
현수는 스카이 콩콩을 타고 가는데 한 번의 점프로 앞으로 1, 뒤로 1, 앞으로 5를 이동할 수
있다. 최소 몇 번의 점프로 현수가 송아지의 위치까지 갈 수 있는지 구하는 프로그램을 작성
하세요.

* 입력예제 1
5 14
▣ 출력예제 1
3
▣ 입력예제 2
8 3
▣ 출력예제 2
5
* */
public class Main_이승환2 {

    static int[] dis = {-1, 1, 5}; // 3개의 경우의수
    static boolean[] visited = new boolean[10001]; // 방문했던건 다시 방문하지 않도록 하기 위한 배열
    static int BFS(int start,int end){
        Queue<Integer> Q = new ArrayDeque<>();
        Q.offer(start);
        visited[start] = true;
        int count = 0;

        while (!Q.isEmpty()){
            int size = Q.size();

            for(int i=0; i<size; i++) {
                int x = Q.poll();

                for (int j = 0; j < dis.length; j++) {
                    int nx = x + dis[j];

                    if (nx == end) {
                        return count + 1;
                    }

                    if (nx >= 1 && nx <= 10000 && !visited[nx]) {
                        visited[nx] = true;
                        Q.offer(nx);
                    }

                }
            }
            count++;

        }

        return -1;
    }





    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        System.out.println(BFS(start,end));

    }



}
