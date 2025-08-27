package 바킹독_과제._5주차_이분탐색.골드.멀티버스2_18869;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//X 이 문제를 어떻게 이분탐색으로 적용해야할지 감이 안왔음
public class Main_이승환 {
    static int M; // 우주의 개수

    static int N; // 행성의 개수
    static int[][] univers; // 원래 좌표
    static int[][] sortedUnivers; // 원래 좌표


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        univers = new int[M][N];
        sortedUnivers = new int[M][N];

        //정렬된 우주와 정렬되지 않은 우주를 해놓음
        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                univers[i][j] = Integer.parseInt(st.nextToken());
            }
        }




        //정렬된 우주를 통해 정렬되지 않은 우주의 index 값을 알아냄
        // 그 인덱스 값을 univers에 그대로 넣어줘서 우주의 상대적인 순위를 알아냄
        // 상대적인 순위가 같다면 우주가 같기 떄문
        for(int i=0; i<M; i++){
            for(int j=0; j<N; j++){
                univers[i][j] = BinarySearch(sortedUnivers[i], univers[i][j]);
            }
        }

        // univers를 다 돌면서 같은 수를 세줌
        int count =0;
        for(int i=0; i<M; i++){
            for(int j = i+1; j<M; j++){
                if(Arrays.equals(univers[i], univers[j])) count++;
            }
        }



    }

    private static int BinarySearch(int[] sortArr, int target){
        int left = 0;
        int right = N-1;

        while(left <= right){
            int mid = (left+right) / 2;
            int midValue = sortArr[mid];

            if(midValue > target){
                right = mid - 1;
            } else if (midValue == target){
                return mid;
            } else {
                left = mid + 1;
            }

        }

        return left;
    }


}
