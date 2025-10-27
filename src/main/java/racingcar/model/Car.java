package racingcar.model;


public class Car {
    private final String name;
    private int position;

    public Car(String name) {
        this.name = name.trim();
        this.position = 0;
    }

    public int getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }

    public void move() {
        position++;
    }

    @Override
    public String toString() {
        return name + " : " + "-".repeat(position);
    }
}
