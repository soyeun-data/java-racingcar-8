package racingcar.view;

import java.util.List;
import java.util.Map;

public class Output {
    public void printMoveResult(Map<String, String> cars) {
        System.out.println("실행 결과");
        for (String name : cars.keySet()) {
            System.out.println(name + " : " + cars.get(name));
        }
        System.out.println();
    }

    public void printWinner(List<String> winners) {
        System.out.println("최종 우승자 : " + String.join(", ",winners));
    }
}
