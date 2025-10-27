package racingcar.model;

import java.util.List;

public class FindWinners {
    public static List<String> findWinners(Cars cars) {
        int maxPosition = cars.getMaxPosition();
        return cars.getCars().stream()
                .filter(car -> car.getPosition() == maxPosition)
                .map(Car::getName)
                .toList();
    }
}
