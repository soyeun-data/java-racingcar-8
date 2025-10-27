package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomMoveStrategey implements MoveStrategy{
    @Override
    public boolean movable() {
        int randomValue = Randoms.pickNumberInRange(0, 9);
        return randomValue >= 4;
    }
}
