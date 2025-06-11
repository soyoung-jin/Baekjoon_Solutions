/*
* ::::: 문제 :::::
* - 1 ~ N 번까지 사람이 원을 이루며 앉아 있다.
* - 양의 정수 K 가 주어지면, 순서대로 K 번째 사람을 제거한다.
* - 한 사람이 제거되면 남은 사람들로 이루어진 원을 따라 계속 반복
* - N 명의 사람이 모두 제거될 때까지 반복한다.
* - 원에서 사람들이 제거되는 순서를 요세푸스 순열이라고 한다.
*
* - (N, K) 요세푸스 순열을 구하는 프로그램을 작성하시오
*
* ::::: 입력 :::::
* N, K 가 빈칸을 사이에 두고 순서대로 주어진다.
*
* ::::: 구현 :::::
* - ArrayDeque 사용하여 큐 구현
* - poll() 한 것을 다시 뒤로 add() 하는 것을 K -1 번 진행
* - K 번 진행 후 가장 위에 있는 숫자를 poll() 하여 StringBuilder 에 저장
* - queue.isEmpty() == true 일 때 까지 반복
*
* */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws IOException {

        // 입력받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 빈칸을 기준으로 문자열 나누기
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        // 출력을 저장
        StringBuilder sb = new StringBuilder();
        sb.append("<");

        // 요세푸스 순열 (N, K)를 저장
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        // Queue 생성
        ArrayDeque<Integer> arrayDeque = new ArrayDeque<>();

        // N 번까지 큐에 add
        for(int i = 1; i <= N; i++){
            arrayDeque.add(i);
        }


        while(!arrayDeque.isEmpty()){
            // K번째 사람을 제거해야 하므로 poll()한 것을 다시 add -> K -1 번 진행
            for(int i = 0; i < K -1; i++){
                arrayDeque.add(arrayDeque.poll());
            }

            // 마지막 수에는 ", " 가 붙지 않도록 따로 처리
            // 요기서 조금 막혔음..!
            if(arrayDeque.size() == 1){
                sb.append(arrayDeque.poll());
            } else {
                sb.append(arrayDeque.poll()).append(", ");
            }

        }

        sb.append(">");

        System.out.println(sb);


    }
}