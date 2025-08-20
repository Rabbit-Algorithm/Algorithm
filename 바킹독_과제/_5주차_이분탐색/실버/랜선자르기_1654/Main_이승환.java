package 바킹독_과제._5주차_이분탐색.실버.랜선자르기_1654;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Main_이승환 {

    static int N,K;

    static int[] LANS;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); //가지고 있는 랜선의 갯수
        K = Integer.parseInt(st.nextToken()); //필요한 랜선의 갯수

        LANS = new int[N];

        for(int i=0; i<N; i++){
            LANS[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(LANS); //이분 탐색을 위한 정렬

        BinarySearch();

    }

    private static void BinarySearch(){
        long left = 1;
        long right = LANS[N-1];
        long result = 0;

        while(left <= right){
            long  mid = (left+right) /2;

            int count = 0;
            for (int lan : LANS) {
                count += lan/mid;
            }

            if(count >= K){
                result = mid;

                //더 긴 길이 비교를 위해 left에 중앙값을 넣자
                left = mid + 1;
            }else {
                //더 짧은 길이를 비교하기 위해 right에 중앙값을 넣자
                right = mid - 1;
            }

        }

        System.out.println(result);

    }


}
