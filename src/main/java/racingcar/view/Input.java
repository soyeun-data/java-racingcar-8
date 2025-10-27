package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

public class Input {
    public String readCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        return Console.readLine();
    }

    public int readAttemptCnt() {
        int attemptCnt = 0;
        try {
            System.out.println("시도할 횟수는 몇 회인가요?");
            String inputAttempt = Console.readLine();
            attemptCnt = Integer.parseInt(inputAttempt);
            System.out.println();
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("시도할 횟수가 잘못 입력되었습니다");
        }
        return attemptCnt;
    }
}
