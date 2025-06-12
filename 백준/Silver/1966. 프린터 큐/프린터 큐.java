/*
* ::::: 문제 :::::
* - 프린터 기기는 명령을 받은 순서대로, 먼저 요청된 것을 먼저 인쇄한다.
* - 여러개의 문제가 쌓인다면 큐 자료구조처럼 인쇄가 되는 것.
* - 하지만 상근이는 새로운 내부 소프트웨어를 개발함. 이 프린터기는 다음과 같은 조건으로 인쇄됨
*
* - 현재 큐에 가장 앞에 있는 문서의 "중요도" 확인
* - 나머지 문서들 중 현재 문서보다 중요도가 높은 문서가 하나라도 있다면, 이 문서를 인쇄하지 않고 큐의 가장 뒤에 재배치
*   그렇지 않다면 바로 안쇄
*
* - 현재 큐에 있는 문서의 수와 중요도가 주어졌을 때, 어떤 한 문서가 몇 번째로 인쇄되는지 알아내야 함
*
* ::::: 입력 :::::
* - 테스트 케이스는 두 줄씩 이루어짐
* - 가장 첫 줄: 테스트 케이스의 수
* - 테스트 케이스의 첫번째 줄: 문서의 개수 N개, 몇 번째로 인쇄되었는지 궁금한 문서가 현재 몇번째에 놓여 있는 지 나타내는 정수 M
* - 테스트 케이스의 두번째 줄: N개 문서의 중요도(1 ~ 9 이하의 정수, 중요도가 같은 문서가 여러 개 존재 가능)
*
* ::::: 구현 :::::
* - 테스트 케이스 개수 입력 받고 for 문으로 반복
* - StringTokenizer 로 공백 기준으로 나누어, 문서의 개수와 큐의 몇번째의 놓인 문서를 찾아야 하는지 저장
* - 그 다음 br.readLine()으로 중요도 입력받아서, 큐에 add
* */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main{
    static class Document{
        // 문서의 순서, 원래 위치
        int index;

        // 위 index 순서별 중요도
        int priority;

        Document(int index, int priority){
            this.index = index;
            this.priority = priority;
        }
    }

    public static void main(String[] args) throws IOException {

        // 입력받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 테스트 케이스 개수
        int T = Integer.parseInt(br.readLine());

        // 테스크 케이스 수 만큼 반복
        for(int i = 0; i < T; i++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            // 문서의 개수
            int N = Integer.parseInt(st.nextToken()); // 4
            // 궁금한 위치
            int M = Integer.parseInt(st.nextToken()); // 2

            // 중요도 읽기
            st = new StringTokenizer(br.readLine(), " ");
            // queue 생성
            ArrayDeque<Document> arrayDeque = new ArrayDeque<>();
            // 큐에 문서위치, 중요도 저장
            for(int j = 0; j < N; j++){
                arrayDeque.add(new Document(j, Integer.parseInt(st.nextToken())));
            }

            // 출력되는 순서, 몇번째로 출력되는지 구해야함
            int printOrder = 0;

            while(!arrayDeque.isEmpty()){
                // 현재 비교 중인 문서 저장, 맨 앞에 있는 문서 꺼냄
                Document current = arrayDeque.poll();

                // 현재 문서보다 더 높은 우선순위가 있는지 나머지 큐에서 확인
                boolean hasHigherPriority = false;

                for(Document doc : arrayDeque){
                    // 현재 문서보다 더 큰 우선순위가 뒤에 존재한다면
                    if(current.priority < doc.priority){
                        // 더 큰 우선 순위가 있으므로 true 변경
                        hasHigherPriority = true;
                        // 맨 앞에 있던 문서를 뒤로 다시 add
                        arrayDeque.add(current);
                        break;
                    }
                }

                // 큐 전체를 다 비교한 이후에도 여전히 hasHigherPriority 가 false 로 유지되고 있다면,
                // 현재 우선순위보다 더 큰 우선순위는 없다는 의미이므로 출력 해주어야 함.
                if(!hasHigherPriority){
                    // 더 큰 우선 순위가 없다면 프린트 진행
                    printOrder++;

                    // 만약, 현재 출력되는 문서의 index 가 M과 동일하다면, printOrder 출력순서 출력 후 종료
                    if(current.index == M){
                        System.out.println(printOrder);
                        break;
                    }
                }
            }
        }
    }

}