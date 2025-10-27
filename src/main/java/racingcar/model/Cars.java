package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Cars {
    private final List<Car> cars = new ArrayList<>();

    public Cars(String[] nameSplit) {
        for (String rawName : nameSplit) {
            String name = rawName.trim();
            if (isDuplicated(name)) {
                throw new IllegalArgumentException("자동차 이름이 중복되었습니다.");
            }
            cars.add(new Car(name));
        }
    }

    public boolean isDuplicated(String name) {
        return cars.stream().anyMatch(car -> car.getName().equals(name));
    }

    public void race(MoveStrategy moveStrategy) {
        for (Car car : cars) {
            if (moveStrategy.movable()) {
                car.move();
            }
        }
    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(cars);
    }

    public int getMaxPosition() {
        return cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(0);
    }

}
