package racingcar.model;

import org.junit.jupiter.api.Test;
import racingcar.model.moveStrategy.AlwaysMoveStrategy;
import racingcar.model.moveStrategy.NeverMoveStrategy;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

class CarsTest {
    @Test
    void 중복된_자동차_이름이_입력된_경우_예외_처리() {
        String[] names = {"pobi", "woni", "pobi"};
        assertThatThrownBy(() -> new Cars(names))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름이 중복되었습니다.");
    }

    @Test
    void 모든_차가_전진() {
        String[] names = {"pobi", "woni"};
        Cars cars = new Cars(names);

        cars.race(new AlwaysMoveStrategy());

        assertThat(cars.getCars().stream().allMatch(car -> car.getPosition() == 1));
    }

    @Test
    void 모든_차가_정지() {
        String[] names = {"pobi", "woni"};
        Cars cars = new Cars(names);

        cars.race(new NeverMoveStrategy());

        assertThat(cars.getCars().stream().allMatch(car -> car.getPosition() == 0));
    }
}