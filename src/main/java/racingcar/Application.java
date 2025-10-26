package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String carNames = Console.readLine();

        String[] nameSplit = splitCarNamesByComma(carNames);
        System.out.println(Arrays.toString(nameSplit));
    }

    public static String[] splitCarNamesByComma(String carNames) {
        return carNames.split(",");
    }
}
