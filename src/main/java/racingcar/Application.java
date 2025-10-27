package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import racingcar.model.*;
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

        Cars cars = new Cars(nameSplit);
        MoveStrategy moveStrategy = new RandomMoveStrategey();

        for (int i = 0; i < attemptCnt; i++) {
            cars.race(moveStrategy);
            output.printMoveResult(cars.getCars());
        }

        List<String> winners = FindWinners.findWinners(cars);
        output.printWinner(winners);
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
