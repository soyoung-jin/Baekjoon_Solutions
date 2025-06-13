/*
* ::::: 문제 :::::
* - 정수를 구현하는 큐를 구현
* - 입력으로 주어지는 명령을 처리
*
* :::: 구현 :::::
* - 첫번쨰 줄에 테스트케이스 개수가 주여지므로 해당 개수만큼 for 문 진행
* - "push 1"에서 명령어와 push 할 정수를 공백을 기준으로 잘라서 저장 => StringTokenizer
* - 나머지 명령어에 따라 switch case 문으로 분기 처리
*
* */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws IOException {

        // 입력 받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 테스트 케이스 개수
        int T = Integer.parseInt(br.readLine());

        // 큐 생성
        ArrayDeque<Integer> arrayDeque = new ArrayDeque<>();

        // 출력 저장
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < T; i++){
            // 명령어 받기
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            switch (st.nextToken()){
                case "push" :
                    arrayDeque.add(Integer.parseInt(st.nextToken()));
                    break;

                case "pop":
                    if(arrayDeque.isEmpty()) {
                        sb.append(-1).append("\n");
                    } else {
                        sb.append(arrayDeque.poll()).append("\n");
                    }
                    break;

                case "size":
                    sb.append(arrayDeque.size()).append("\n");
                    break;

                case "empty":
                    if(arrayDeque.isEmpty()) {
                        sb.append(1).append("\n");
                    } else {
                        sb.append(0).append("\n");
                    }
                    break;

                case "front":
                    if(arrayDeque.isEmpty()) {
                        sb.append(-1).append("\n");
                    } else {
                        sb.append(arrayDeque.peekFirst()).append("\n");
                    }
                    break;

                case "back":
                    if (arrayDeque.isEmpty()) {
                        sb.append(-1).append("\n");
                    } else {
                        sb.append(arrayDeque.peekLast()).append("\n");
                    }
                    break;
            }

        }

        // 마지막 줄바꿈 제거
        if(sb.length() > 0){
            sb.setLength(sb.length() - 1);
            System.out.println(sb);
        }

    }

}