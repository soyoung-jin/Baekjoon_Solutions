/*
* ::::: 문제 :::::
* - 강을 가로지르는 차선 다리 1개가 있음.
* - 이 다리를 N개의 트럭이 건너가려 함.
* - 트럭의 순서는 바꿀 수 없음
* - 트럭의 무게는 서로 같지 않을 수 있다.
* - 다리 위에는 단지 W대의 트럭만 동시에 올라갈 수 있다.
* - 다리의 길이는 W 단위길이.
* - 각 트럭들은 하나의 단위 시간에 하나의 단위길이만큼 이동 가능
* - 동시에 다리 위에 올라가 있는 트럭들의 무게의 합 <= 다리의 최대하중인 L
* - 다리 위에 완전히 올라가지 못한 트럭의 무게는 다리 위의 트럭들의 무게의 합을 계산 할 때 포함하지 않음
*
* - 다리의 길이/ 다리의 최대 하중/ 다리를 건너려는 트럭들의 무게가 순서대로 주어지면, 모든 트럭이 다리를 건너는 최단 시간을 구해라
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

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        // 트럭 개수
        int n = Integer.parseInt(st.nextToken());
        // 다리의 길이
        int w = Integer.parseInt(st.nextToken());
        // 다리의 최대 하중
        int L = Integer.parseInt(st.nextToken());

        // 각 트럭의 무게 문자열 자르기
        st = new StringTokenizer(br.readLine(), " ");

        // 큐에 트럭의 무게 add
        ArrayDeque<Integer> truck = new ArrayDeque<>();
        for(int i = 0; i < n; i++){
            truck.add(Integer.parseInt(st.nextToken()));
        }

        // 첫번째 트럭 다리 건너기 전, 다리의 길이 w만큼 0을 add()하여 세팅
        ArrayDeque<Integer> bridge = new ArrayDeque<>();
        for(int i = 0; i < w; i++){
            bridge.add(0);
        }

        // 구해야 하는 단위 시간
        int time = 0;
        // 현재 다리 위에 올라가 있는 트럭의 무게
        int currentWeightOnBridge = 0;

        // 다리 건너기, 다리에 있는 큐가 완전히 비어야 종료
        while(!bridge.isEmpty()){
            // 1초마다 무조건 다리에서 하나씩 빠짐. 다리에서 빠지니까 현재 다리 무게에서 빼주어야 함
            currentWeightOnBridge -= bridge.poll();
            // 단위시간 1초 증가
            time++;

            if(!truck.isEmpty()){
                // 다리위에 올라갈 다음 트럭
                int nextTruck = truck.peek();

                // 다음 트럭이 올라가도 현재 다리의 무게가 최대 하중보다 작다면 -> 다리 위에 다음 트럭 올라갈 수 있음
                if(nextTruck + currentWeightOnBridge <= L){
                    // 다리의 현재 무게 다시 세팅
                    currentWeightOnBridge += nextTruck;
                    // 다음 트럭 다리 위에 올라감
                    bridge.add(truck.poll());
                } else {
                    // 현재 다리 무게가 최대 하중을 넘어선다면 -> 다음 트럭 올라가면 안됨
                    bridge.add(0);
                }
            }
        }

        System.out.println(time);
    }
}