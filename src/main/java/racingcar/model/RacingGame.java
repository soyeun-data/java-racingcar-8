package racingcar.model;

import racingcar.model.moveStrategy.MoveStrategy;
import racingcar.view.Output;

import java.util.List;

public class RacingGame {
    private final Cars cars;
    private final int attemptCnt;
    private final MoveStrategy moveStrategy;
    private final Output output;

    public RacingGame(Cars cars, int attemptCnt, MoveStrategy moveStrategy, Output output) {
        this.cars = cars;
        this.attemptCnt = attemptCnt;
        this.moveStrategy = moveStrategy;
        this.output = output;
    }

    public void play() {
        for (int i = 0; i < attemptCnt; i++) {
            cars.race(moveStrategy);
            output.printMoveResult(cars.getCars());
        }

        List<String> winners = FindWinners.findWinners(cars);
        output.printWinner(winners);
    }

}
