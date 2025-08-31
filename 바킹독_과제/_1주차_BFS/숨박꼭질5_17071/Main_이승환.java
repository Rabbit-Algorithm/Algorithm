package 바킹독_과제._1주차_BFS.숨박꼭질5_17071;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_이승환 {

    static int SUBIN,SISTER;
    static Node[] SISTER_VISITED = new Node[500_001];




    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        SUBIN = Integer.parseInt(st.nextToken());
        SISTER = Integer.parseInt(st.nextToken());
        int count = 0;

        for(int i=0; i< 500_000; i++){
            SISTER = SISTER + ((count)*(count+1)/2);

            if(SISTER > 500_000){
                break;
            }

            SISTER_VISITED[SISTER] = new Node(count,SISTER);
            count++;

        }


        BFS();
    }

    static void BFS(){
        Queue<Integer> Q = new ArrayDeque<>();
        int count = 0;
        SISTER = SISTER + ((count)*(count+1)/2);
//        visited[SUBIN] = true;
        Q.offer(SUBIN);

        while (!Q.isEmpty()){
            int x = Q.poll();

            int[] dis = {-1,1, 2*x};

            for(int i=0; i<dis.length; i++){

            }




        }

    }

    static class Node{
        int count;
        int dis;

        public Node(int count, int dis) {
            this.count = count;
            this.dis = dis;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "count=" + count +
                    ", dis=" + dis +
                    '}';
        }
    }

}
