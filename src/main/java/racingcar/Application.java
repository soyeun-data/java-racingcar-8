package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import racingcar.model.Car;
import racingcar.model.Parser;
import racingcar.view.Input;
import racingcar.view.Output;

import java.util.*;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Input input = new Input();
        Output output = new Output();
        Parser parser = new Parser();

        String carNames = input.readCarNames();
        int attemptCnt = input.readAttemptCnt();

        checkInputCarNames(carNames);

        String[] nameSplit = parser.splitCarNamesByComma(carNames);

        checkCarNames(nameSplit);

        List<Car> cars = moveOrStop(nameSplit, attemptCnt, output);

        int maxLength = findMaxLength(cars);

        List<String> winners = findWinners(cars, maxLength);

        output.printWinner(winners);
    }


    public static List<Car> moveOrStop(String[] nameSplit, int attemptCnt, Output output) {
        List<Car> cars = new ArrayList<>();

        for (String rawName : nameSplit) {
            String name = rawName.trim();
            if (cars.stream().anyMatch(car -> car.getName().equals(name))) {
                throw new IllegalArgumentException("자동차 이름이 중복되었습니다.");
            }
            cars.add(new Car(name));
        }

        for (int i = 0; i < attemptCnt; i++) {
            for (Car car : cars) {
                int rand = Randoms.pickNumberInRange(0, 9);
                if (rand >= 4) {
                    car.move();
                }
            }
            output.printMoveResult(cars);
        }
        return cars;
    }

    public static int findMaxLength(List<Car> cars) {

        return cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(0);
    }

    public static List<String> findWinners(List<Car> cars, int maxLength) {
        List<String> winners = new ArrayList<>();
        for (Car car : cars) {
            if (car.getPosition() == maxLength) {
                winners.add(car.getName());
            }
        }
        return winners;
    }

    public static void checkCarNames(String[] nameSplit) {
        for (String name : nameSplit) {
            if (name.length() > 5) {
                throw new IllegalArgumentException("입력된 자동차 이름이 5자를 초과하였습니다.");
            }
        }
    }

    public static void checkInputCarNames(String carNames) {
        if (carNames == null || carNames.isBlank()) {
            throw new IllegalArgumentException("자동차 이름이 입력되지 않았습니다.");
        }
    }
}
