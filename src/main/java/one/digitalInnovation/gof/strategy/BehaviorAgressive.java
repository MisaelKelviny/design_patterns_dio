package one.digitalInnovation.gof.strategy;

public class BehaviorAgressive implements  Behavior{
    public BehaviorAgressive() {
    }

    @Override
    public void move() {
        System.out.println("Movendo-se agressivamente");
    }
}
