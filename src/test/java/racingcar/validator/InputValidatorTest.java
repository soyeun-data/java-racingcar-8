package racingcar.validator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

class InputValidatorTest {

    @Test
    void 자동차_이름이_5자를_초과할_경우_예외_처리() {
        String[] names = {"abcdef", "woni"};
        assertThatThrownBy(() -> InputValidator.checkCarNames(names))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("입력된 자동차 이름이 5자를 초과하였습니다.");
    }

    @Test
    void 자동차_이름이_비어있을경우_예외_처리() {
        String name = "  ";
        assertThatThrownBy(() -> InputValidator.checkInputCarNames(name))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름이 입력되지 않았습니다.");
    }
}