/*
* 문자열이 주어지면, String s 변수에 저장
* int T = 테스트 개수 저장
* for 문으로 T 번 반복
* 커서를 기준으로 오른쪽, 왼쪽 스택이 2개 필요함
* 스택에서 pop 한 뒤, 뒤집어야 함 -> sb.reverser() 사용 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main{
    public static void main(String[] args) throws IOException {

        // 입력값 받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 출력 문자열을 저장
        StringBuilder sb = new StringBuilder();

        // 커서 기준 오른쪽 스택 생성
        Stack<Character> stack_right = new Stack<>();
        // 커서 기준 왼쪽 스택 생성
        Stack<Character> stack_left = new Stack<>();

        // 입력받은 문자열 저장
        String str = br.readLine();

        // 명령어 개수
        int T = Integer.parseInt(br.readLine());

        // 입력받은 문자열 왼쪽 스택에 모두 넣기
        char[] c = str.toCharArray();
        for(int i = 0; i < str.length(); i++){
            stack_left.push(c[i]);
        }

        /*  for(char c : str.toCharArray()){
            stack_left.push(c);
        }*/

        // T 명령어 개수만큼 반복
        for(int i = 0; i < T; i++){
            // 각 명령어 입력받기
            String command = br.readLine();
            // 명렁어 P x 때문에 charAt 으로 인덱스 지정 필요함
            char command_char = command.charAt(0);

            switch (command_char){
                case 'L' :
                    // 왼쪽 스택이 비어있으면 커서가 가장 앞에 있다는 의미이므로 명령어 무시해야하기 때문
                    if(!stack_left.isEmpty()){
                        stack_right.push(stack_left.pop());
                    }
                    // 해당 명령어 처리 후, break 해주는거 잊지 말기! 아니면 case 를 모두 실행해서 Exception 발생
                    break;
                case 'D':
                    if(!stack_right.isEmpty()) {
                        stack_left.push(stack_right.pop());
                    }
                    break;
                case 'B':
                    if(!stack_left.isEmpty()){
                        stack_left.pop();
                    }
                    break;
                case 'P':
                    stack_left.push(command.charAt(2));
                    break;
            }
        }

        // 결과 출력
        // 왼쪽 스택이 빌 때까지 pop
        while(!stack_left.isEmpty()){
            sb.append(stack_left.pop());
        }
        // 순서 뒤집어주기
        sb.reverse();

        // 오른쪽 스택이 빌 때까지 pop
        while(!stack_right.isEmpty()){
            sb.append(stack_right.pop());
        }

        // 오른쪽 스택은 순서 뒤집을 필요 없이 그대로 sb 뒤에 append 해주면 됨
        System.out.println(sb.toString());
    }
}