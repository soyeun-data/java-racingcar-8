package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import racingcar.model.*;
import racingcar.validator.InputValidator;
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

        InputValidator.checkInputCarNames(carNames);

        String[] nameSplit = parser.splitCarNamesByComma(carNames);

        InputValidator.checkCarNames(nameSplit);

        Cars cars = new Cars(nameSplit);
        MoveStrategy moveStrategy = new RandomMoveStrategey();

        for (int i = 0; i < attemptCnt; i++) {
            cars.race(moveStrategy);
            output.printMoveResult(cars.getCars());
        }

        List<String> winners = FindWinners.findWinners(cars);
        output.printWinner(winners);
    }
}
