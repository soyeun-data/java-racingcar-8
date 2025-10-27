package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import racingcar.controller.RacingCarController;
import racingcar.model.*;
import racingcar.validator.InputValidator;
import racingcar.view.Input;
import racingcar.view.Output;

import java.util.*;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        RacingCarController racingCarController = new RacingCarController();
        racingCarController.run();
    }
}
