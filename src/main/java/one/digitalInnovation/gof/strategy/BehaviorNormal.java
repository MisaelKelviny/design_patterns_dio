package one.digitalInnovation.gof.strategy;

public class BehaviorNormal implements Behavior {

    public BehaviorNormal() {
    }

    @Override
    public void move() {
        System.out.println("Movendo-se normalmente");
    }
}
