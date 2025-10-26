package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String carNames = Console.readLine();
        System.out.println("시도할 횟수는 몇 회인가요?");
        String inputAttempt = Console.readLine();
        int attemptCnt = Integer.parseInt(inputAttempt);
        System.out.println();

        String[] nameSplit = splitCarNamesByComma(carNames);

        Map<String, String> cars = moveOrStop(nameSplit, attemptCnt);

        int maxLength = findMaxLength(cars);

        List<String> winners = findWinners(cars, maxLength);

        outputWinner(winners);
    }

    public static String[] splitCarNamesByComma(String carNames) {
        return carNames.split(",");
    }

    public static void outputWinner(List<String> winners) {
        System.out.println("최종 우승자 : " + String.join(", ",winners));
    }

    public static Map<String, String> moveOrStop(String[] nameSplit, int attemptCnt) {
        Map<String, String> cars = new LinkedHashMap<>();
        for (String name : nameSplit) {
            cars.put(name.trim(), "");
        }

        for (int i = 0; i < attemptCnt; i++) {
            for (String name : cars.keySet()) {
                int rand = Randoms.pickNumberInRange(0, 9);
                if (rand >= 4) {
                    cars.put(name, cars.get(name) + "-");
                }
            }
            outputMoveResult(cars);
        }
        return cars;
    }

    public static void outputMoveResult(Map<String, String> cars) {
        System.out.println("실행 결과");
        for (String name : cars.keySet()) {
            System.out.println(name + " : " + cars.get(name));
        }
        System.out.println();
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

}
