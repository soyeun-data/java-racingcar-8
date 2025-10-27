package racingcar.validator;

public class InputValidator {
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
