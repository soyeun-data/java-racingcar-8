package racingcar.controller;

import racingcar.model.*;
import racingcar.validator.InputValidator;
import racingcar.view.Input;
import racingcar.view.Output;

import java.util.List;

public class RacingCarController {
    Input input = new Input();
    Output output = new Output();
    Parser parser = new Parser();

    public void run() {
        String carNames = input.readCarNames();
        int attemptCnt = input.readAttemptCnt();

        InputValidator.checkInputCarNames(carNames);

        String[] nameSplit = parser.splitCarNamesByComma(carNames);

        InputValidator.checkCarNames(nameSplit);

        Cars cars = new Cars(nameSplit);
        MoveStrategy moveStrategy = new RandomMoveStrategey();

        RacingGame racingGame = new RacingGame(cars, attemptCnt, moveStrategy, output);
        racingGame.play();
    }
}
