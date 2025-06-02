/*
* 1. 주어지는 명령어에 따라 처리하는 프로그램
*
* switch-case 문을 사용한다
**/
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws IOException {

        // 입력받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 테스트 개수
        int T = Integer.parseInt(br.readLine());

        // 스택 생성
        Stack<Integer> stack = new Stack<>();

        // T번 반복
        for(int i = 0; i < T; i++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            String s = st.nextToken();

            switch (s){
                case "1":
                    stack.push(Integer.valueOf(st.nextToken()));
                    break;

                case "2":
                    if(!stack.empty()){
                        System.out.println(stack.pop());

                    } else {
                        System.out.println(-1);
                    }
                    break;

                case "3":
                    System.out.println(stack.size());
                    break;

                case "4":
                    if(stack.empty()){
                        System.out.println(1);
                    } else {
                        System.out.println(0);
                    }
                    break;

                case "5":
                    if(!stack.empty()){
                        System.out.println(stack.peek());
                    } else {
                        System.out.println(-1);
                    }
                    break;
            }
        }
    }
}