package one.digitalInnovation.gof.strategy;

public class BehaviorDefense implements Behavior {
    public BehaviorDefense() {
    }

    @Override
    public void move() {
        System.out.println("Movendo-se Defensivamente");
    }
}
