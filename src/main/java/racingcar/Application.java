package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String carNames = Console.readLine();
        System.out.println("시도할 횟수는 몇 회인가요?");
        String inputAttempt = Console.readLine();
        int attemptCnt = Integer.parseInt(inputAttempt);

        String[] nameSplit = splitCarNamesByComma(carNames);

        List<String> winners = Arrays.asList(nameSplit);
        output(winners);
    }

    public static String[] splitCarNamesByComma(String carNames) {
        return carNames.split(",");
    }

    public static void output(List<String> winners) {
        System.out.println("최종 우승자 : " + String.join(", ",winners));
    }

}
