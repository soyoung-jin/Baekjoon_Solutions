/*
* ::::: 문제 :::::
* - 정수를 저장하는 큐 구현 후, 주어진 입력에 따라 명령을 처리하는 프로그램 작성
* - 명령은 총 6가지
* - push X : 정수 X를 큐에 넣는다. add() 사용
* - pop : 큐에 가장 앞에 있는 정수를 빼고 그 수를 출력, poll() 사용, 만약 들어있는 정수가 없다면 -1 출력
* - size : 큐에 들어있는 정수의 개수 출력, size() 사용
* - empty : 큐가 비어있으면 1, 아니면 0 출력, isEmpty() 사용
* - front : 큐의 가장 앞에 있는 정수 출력, pollFirst() 사용, 데이터가 없다면 -1 출력
* - back : 큐의 가장 뒤에 있는 정수 출력, pollLast() 사용, 데이터가 없다면 -1 출력
*
* ::::: 입력 :::::
* 첫째줄에는 명령의 수 N개 주어짐
* 둘째줄에는 명령이 하나씩 주어짐
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

        // 명령어의 개수
        int N = Integer.parseInt(br.readLine());

        // 큐 생성
        ArrayDeque<Integer> arrayDeque = new ArrayDeque<>();

        // 출력 저장
        StringBuilder sb = new StringBuilder();

        // 명령어 개수만큼 반복
        for(int i = 0; i < N; i++){
            // "push X" 명렁어 때문에 공백을 기준으로 나눠주어야 함
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            // 명령어 저장
            String s = st.nextToken();

            switch (s) {
                case "push" :
                    arrayDeque.add(Integer.parseInt(st.nextToken()));
                    break;

                case "pop" :
                    if(!arrayDeque.isEmpty()){
                        sb.append(arrayDeque.poll()).append("\n");
                    } else {
                        sb.append(-1).append("\n");
                    }
                    break;

                case "size" :
                    sb.append(arrayDeque.size()).append("\n");
                    break;

                case "empty" :
                    if(arrayDeque.isEmpty()){
                        sb.append(1).append("\n");
                    } else {
                        sb.append(0).append("\n");;
                    }
                    break;

                case "front" :
                    if(!arrayDeque.isEmpty()){
                        sb.append(arrayDeque.peekFirst()).append("\n");
                    } else {
                        sb.append(-1).append("\n");
                    }
                    break;

                case "back" :
                    if(!arrayDeque.isEmpty()){
                        sb.append(arrayDeque.peekLast()).append("\n");
                    } else {
                        sb.append(-1).append("\n");
                    }
                    break;
            }
        }

        System.out.println(sb);

    }
}