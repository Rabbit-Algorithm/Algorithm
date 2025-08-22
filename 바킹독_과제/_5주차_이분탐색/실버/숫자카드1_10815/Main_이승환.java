package 바킹독_과제._5주차_이분탐색.실버.숫자카드1_10815;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//입력1 N(배열 A의 크기)
//입력2 배열 A의 숫자들
//입력3 M(찾아야 할 숫자의 갯수)
//입력4 찾아야할 숫자들

public class Main_이승환 {

    static int N,M;

    static long[] sgCards; // 상근이 카드
    static long[] findCards; // 찾아야하는 카드


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        sgCards = new long[N];

        for(int i=0; i<N; i++){
            sgCards[i] = Long.parseLong(st.nextToken());
        }

        Arrays.sort(sgCards);

        M = Integer.parseInt(br.readLine());
        findCards = new long[M];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<M; i++){
            findCards[i] = Long.parseLong(st.nextToken());
        }

        BinarySearch();

    }

    private static void BinarySearch(){

        for(int i=0; i<M; i++){
            long findCard = findCards[i];
            int left = 0;
            int right = N-1;
            boolean sameCard = false;

            while(left <= right){
                int mid = (left+right) / 2;

                if(sgCards[mid] == findCard){
                    sameCard = true;
                    break;
                }else if(sgCards[mid] < findCard){
                    left = mid+1;
                }else{
                    right = mid-1;
                }

            }

            if(sameCard){
                System.out.print(1+" ");
            }else System.out.print(0+" ");


        }


    }


}
