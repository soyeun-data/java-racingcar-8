package racingcar.view;

import racingcar.model.Car;

import java.util.List;
import java.util.Map;

public class Output {
    public void printMoveResult(List<Car> cars) {
        System.out.println("실행 결과");
        for (Car car: cars) {
            System.out.println(car);
        }
        System.out.println();
    }

    public void printWinner(List<String> winners) {
        System.out.println("최종 우승자 : " + String.join(", ",winners));
    }
}
