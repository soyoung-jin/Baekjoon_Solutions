/*
* ::::: 문제 :::::
* - N장의 카드가 있다.
* - 각각의 카드는 순서대로 1~ N까지 번호가 붙어 있다.
* - 1번 카드가 제일 위에, N번 카드가 제일 아래인 상태로 순서대로 놓여있다.
* - 제일 위에 있는 카드를 바닥에 버린다. -> 그 다음 제일 위에 있는 카드를 제일 아래에 있는 카드 밑으로 옮긴다.
* - 위 동작을 카드가 한 장 남을 때 까지 반복한다.
*
* - N이 주어졌을 때, 가장 마지막에 남게 되는 카드를 구하는 프로그램 작성
*
*
* :::: 출력 :::::
* - 첫째줄에 남게 되는 카드의 번호 출력
*
* ::::: 구현 :::::
* - Queue 사용
* - 들어온 순서대로 나가는 큐의 특성을 이용하여 구현한다.
* */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws IOException {

        // 입력받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 정수 N
        int N = Integer.parseInt(br.readLine());

        ArrayDeque<Integer> qu = new ArrayDeque<>();

        // 1 ~ N 까지의 수를 queue 에 넣음
        for(int i = 1; i <= N; i++){
            qu.add(i);
        }

        // 남은 카드 수가 1장일 때까지 반복
        while(qu.size() != 1){
            // 제일 위에 있는 카드(가장 먼저 들어간 1번부터) 를 바닥에 버림
            qu.poll();

            // 그 다음 제일 위에 있는 카드를 빼서 다시 제일 밑으로 옮김
            qu.add(qu.poll());

        }

        // 남은 카드 출력
        System.out.println(qu.peek());

    }
}