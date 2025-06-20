/*
* ::::: 문재 :::::
* - 1부터 연속적으로 번호가 붙어있는 스위치가 있음.
* - 스위치는 켜져 있거나 꺼져있음.
* - 그림에는 스위치 8개의 상태가 표시되어 있다.
* - '1'은 스위치가 켜져있음을, '0'은 스위치가 꺼져있음을 나타냄
* - 학생 몇명을 뽑아서 1이상, 스위치 개수 이하인 자연수를 하나씩 나누어 줌
* - 학생들은 자신의 성별과 받은 수에 따라 스위치를 조작한다.
*
* 남학생일 경우: 스위치 번호가 자기가 받은 수의 배수이면, 그 스위치의 상태를 바꾼다.
*            스위치가 켜져 있으면 끄고, 꺼져있으면 켠다.
* 여학생일 경우: 자신이 받은 수와 같은 번호가 붙은 스위치를 중심으로 좌우가 대칭이면서 가장 많은 스위치를 포함하는 구간을 찾는다.
*             그 구간에 속한 스위치의 상태를 모두 바꾼다. 이때, 구간의 스위치 개수는 항상 홀수
*
* ::::: 입력 :::::
* - 스위치의 개수 ( <= 100)
* - 스위치들의 처음 상태 (켜져있으면 1, 꺼져 있으면 0)
* - 학생 수 (<= 100)
* - 각 학생의 성별, 받은 수 (남학생 1, 여학생 2/ 받은 수 <= 스위치 개수)
*
* ::::: 출략 :::::
* - 입력되는 순서대로 자신의 성별과, 받은 수에 따라 스위치의 상태를 바꾸었을 때 스위치의 마지막 상태를 출력
* - 스위치는 한 줄에 20개씩 출력, 21번째 스위치의 상태는 둘째 줄 맨 앞에 출력하는 것.
* - 켜진 스위치는 1, 꺼진 스위치는 0
* - 스위치 사이에 공백을 하나씩 둔다.
*
* */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws IOException {
        // 입력받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 출력 저장
        StringBuilder sb = new StringBuilder();

        // 스위치 개수
        int switch_num = Integer.parseInt(br.readLine());

        // 초기 스위치 상태 배열에 저장
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        ArrayList<Integer> switches = new ArrayList<>();

        // 정답 출력을 저장할 배열
        ArrayList<Integer> answerList = new ArrayList<>();

        for(int i = 0; i < switch_num; i++){
            switches.add(Integer.parseInt(st.nextToken()));
        }

        // 학생 수
        int student_num = Integer.parseInt(br.readLine());

        for(int i = 0; i < student_num; i++){
            st = new StringTokenizer(br.readLine()," ");

            // 성별 구분
            int gender = Integer.parseInt(st.nextToken());
            // 학생이 받은 번호
            int studentSwitch = Integer.parseInt(st.nextToken());

            // 남학생일 경우
            if(gender == 1){
                answerList = boySwitch(switches, studentSwitch);
            } else {
                // 여학생일 경우
                answerList = girlSwitch(switches, studentSwitch);
            }
        }

        // 스위치 출력, 한 줄에 20개씩 출력한다. 20번째에서 줄바꿈
        for(int i = 0; i < answerList.size(); i++){
            sb.append(answerList.get(i)).append(' ');

            if((i + 1) % 20 == 0){
                sb.append("\n");
            }
        }

        System.out.println(sb);
    }

    // 남학생의 스위치 상태 바꾸기 동작
    public static ArrayList<Integer> boySwitch(ArrayList<Integer> switches, int studentSwitch){
        // 받은 수의 배수인 스위치 번호의 상태를 바꿈
        for(int i = 0; i < switches.size(); i++){
            // 연산자 우선순위 주의하기 i + 1 % studentSwitch == 0 이렇게 쓰면 i + (1 % studentSwitch) 이렇게 됨
            if((i + 1) % studentSwitch == 0){
                if(switches.get(i).equals(1)){
                    switches.set(i, 0);
                } else {
                    switches.set(i, 1);
                }
            }
        }

        return switches;
    }

    // 여학생의 스위치 상태 바꾸기 동작
    public static ArrayList<Integer> girlSwitch(ArrayList<Integer> switches, int studentSwitch){
        // 인덱스 번호로 맞추기
        int start = studentSwitch - 1;
        int end = studentSwitch - 1;
        int number = 1;

        while(true){

            int nextStart = start - number;
            int nextEnd = end + number;

            // 인덱스 범위 체크
            if(nextStart < 0 || nextEnd > switches.size() - 1){
                break;
            }

            // 좌우 대칭이 같은 값이면 범위 확장
            if(switches.get(nextStart).equals(switches.get(nextEnd))){
                number++;
            } else {
                // 다르면 바로 break
                break;
            }
        }

        // 최종범위, number 가 이미 증감연산자에 의해 증가된 상태이므로 이전으로 줄여줌
        start -= number - 1;
        end += number - 1;

        for(int i = start; i <= end; i++){
            if(switches.get(i).equals(1)){
                switches.set(i, 0);
            } else {
                switches.set(i, 1);
            }
        }

        return switches;
    }
}