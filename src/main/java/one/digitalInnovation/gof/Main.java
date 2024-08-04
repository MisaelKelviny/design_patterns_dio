package one.digitalInnovation.gof;

import one.digitalInnovation.gof.facade.Facade;
import one.digitalInnovation.gof.singleton.SingletonEager;
import one.digitalInnovation.gof.singleton.SingletonLazy;
import one.digitalInnovation.gof.singleton.SingletonLazyHolder;
import one.digitalInnovation.gof.strategy.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class Main {
    public static void main(String[] args) {

        // TESTES DO SINGLETON
        SingletonLazy lazy = SingletonLazy.getInstance();
        System.out.println(lazy);

        lazy = SingletonLazy.getInstance();
        System.out.println(lazy);

        SingletonEager eager = SingletonEager.getInstance();
        System.out.println(eager);

        eager = SingletonEager.getInstance();
        System.out.println(eager);

        SingletonLazyHolder holder = SingletonLazyHolder.getInstance();
        System.out.println(holder);

        holder = SingletonLazyHolder.getInstance();
        System.out.println(holder);

        // STRATEGY
        Behavior normal = new BehaviorNormal();
        Behavior defense = new BehaviorDefense();
        Behavior agressive = new BehaviorAgressive();

        Robot robot = new Robot();
        robot.setBehavior(normal);
        robot.move();

        robot.setBehavior(defense);
        robot.move();

        robot.setBehavior(agressive);
        robot.move();

        // FACADE
        Facade facade = new Facade();
        facade.migrateClient("Misael", "99999999912");

        //API REST
        SpringApplication.run(Main.class, args);
    }
}