package one.digitalinnovation.gof.src;

import one.digitalinnovation.gof.src.one.digitalinnovation.gof.facade.Facade;
import one.digitalinnovation.gof.src.one.digitalinnovation.gof.singleton.SingletonLazy;
import one.digitalinnovation.gof.src.one.digitalinnovation.gof.singleton.SingletonLazyHolder;
import one.digitalinnovation.gof.src.one.digitalinnovation.gof.singleton.SingletonEager;
import one.digitalinnovation.gof.src.one.digitalinnovation.gof.strategy.Comportamento;
import one.digitalinnovation.gof.src.one.digitalinnovation.gof.strategy.ComportamentoAgressivo;
import one.digitalinnovation.gof.src.one.digitalinnovation.gof.strategy.ComportamentoDefensivo;
import one.digitalinnovation.gof.src.one.digitalinnovation.gof.strategy.ComportamentoNormal;
import one.digitalinnovation.gof.src.one.digitalinnovation.gof.strategy.Robo;

public class Teste {
    public static void main(String[] args) {
        //testes realcionados ao Design Pattern Singleton
        SingletonLazy lazy = SingletonLazy.getInstancia();
        System.out.println(lazy);
        lazy = SingletonLazy.getInstancia();
        System.out.println(lazy);

        SingletonEager eager = SingletonEager.getInstancia();
        System.out.println(eager);
        eager = SingletonEager.getInstancia();
        System.out.println(eager);

        SingletonLazyHolder lazyHolder = SingletonLazyHolder.getInstancia();
        System.out.println(lazyHolder);
        lazyHolder = SingletonLazyHolder.getInstancia();
        System.out.println(lazyHolder);

        //Strategy

        Comportamento normal = new ComportamentoNormal();
        Comportamento defensivo = new ComportamentoDefensivo();
        Comportamento agressivo = new ComportamentoAgressivo();

        Robo robo = new Robo();
        robo.setComportamento(normal);
        robo.mover();
        robo.mover();
        robo.setComportamento(defensivo);
        robo.mover();
        robo.mover();
        robo.setComportamento(agressivo);
        robo.mover();
        robo.mover();
        robo.mover();

        // Facade

        Facade facade = new Facade();
        facade.migrarCliente("Flavio", "31615250");
        
    }
}
