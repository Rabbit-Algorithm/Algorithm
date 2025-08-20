package 바킹독_과제._5주차_이분탐색.실버.나무자르기_2805;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 고친 코드
public class Main_이승환2 {

    static int N;
    static long M; //long으로 변경

    static int[] Trees;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); //나무의 수
        M = Long.parseLong(st.nextToken()); //나무의 길이

        st = new StringTokenizer(br.readLine());
        Trees = new int[N];

        for(int i=0; i<N; i++){
            Trees[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(Trees); //이분 탐색을 위한 정렬

        BinarySearch();

    }

    private static void BinarySearch(){
        int left = 0; //left 값도 0부터 받는 것으로 변경
        int right = Trees[N-1];
        int result = 0;

        while(left <= right){

            int mid = (left + right) / 2;

            long treeLength = 0;
            for (int tree : Trees) {
                if(tree > mid){
                    treeLength += tree - mid;
                }
            }


            // M보다 나무의 길이가 크면 하나만으로 변경
            if(treeLength >= M){
                result = mid;
                //더 긴 길이를 비교하기 위해 left에 중앙값을 넣어준다.
                left = mid +1;
            } else {
                //더 짧은 길이를 비교하기 위해 right에 중앙값을 넣어준다.
                right = mid -1;
            }

        }

        System.out.println(result);

    }


}
