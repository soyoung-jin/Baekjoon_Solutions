/*
* ::::: 문제 :::::
* - N장의 카드 있음. 각각의 카드는 1 ~ N번 번호가 붙어 있음
* - 1번 카드가 제일 위에, N번 카드가 제일 아래에 있음
* - 해당 동작 반복
*
* 1. 제일 위에 있는 카드 바닥에 버림
* 2. 제일 위에 있는 카드를 제일 아래 카드 밑으로 옮김
*
* ::::: 출력 :::::
* - N이 주어졌을 때, 버린 카드들을 순서대로 출력 + 마지막에 남게 되는 카드를 출력
*
* ::::: 구현 :::::
* - ArrayDeque 생성
* - while 문 사용해서 카드가 == 1장 남을 때 까지 반복
* -     poll();
* -     add(poll())
* - StringBuilder 로 출력 저장
*
**/
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class Main{
    public static void main(String[] args) throws IOException {

        // 입력 받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        // 출력 저장
        StringBuilder sb = new StringBuilder();

        // 큐 생성 후 1~N add
        ArrayDeque<Integer> arrayDeque = new ArrayDeque<>();

        for(int i = 1; i <= N; i++){
            arrayDeque.add(i);
        }

        // 카드 마지막 1장 남을 때까지 반복
        while(arrayDeque.size() != 1){
            // 맨 위 카드 버리기
            sb.append(arrayDeque.poll()).append(" ");
            // 그 다음 맨 위에 있는 카드를 빼서 다시 add
            arrayDeque.add(arrayDeque.poll());
        }

        // 마지막 남은 카드까지 출력
        sb.append(arrayDeque.poll());

        System.out.println(sb);
        
    }

}