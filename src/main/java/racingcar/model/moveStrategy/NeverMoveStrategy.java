package racingcar.model.moveStrategy;

public class NeverMoveStrategy implements MoveStrategy{
    @Override
    public boolean movable() {
        return false;
    }
}
