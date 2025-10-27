package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
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

        Map<String, String> cars = moveOrStop(nameSplit, attemptCnt, output);

        int maxLength = findMaxLength(cars);

        List<String> winners = findWinners(cars, maxLength);

        output.printWinner(winners);
    }


    public static Map<String, String> moveOrStop(String[] nameSplit, int attemptCnt, Output output) {
        Map<String, String> cars = new LinkedHashMap<>();
        for (String name : nameSplit) {
            if (cars.containsKey(name)) {
                throw new IllegalArgumentException("자동차 이름이 중복되었습니다.");
            } else {
                cars.put(name.trim(), "");
            }
        }

        for (int i = 0; i < attemptCnt; i++) {
            for (String name : cars.keySet()) {
                int rand = Randoms.pickNumberInRange(0, 9);
                if (rand >= 4) {
                    cars.put(name, cars.get(name) + "-");
                }
            }
            output.printMoveResult(cars);
        }
        return cars;
    }

    public static int findMaxLength(Map<String, String> cars) {

        return cars.values().stream()
                .mapToInt(String::length)
                .max()
                .orElse(0);
    }

    public static List<String> findWinners(Map<String, String> cars, int maxLength) {
        List<String> winners = new ArrayList<>();
        for (String name : cars.keySet()) {
            if (cars.get(name).length() == maxLength) {
                winners.add(name);
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
