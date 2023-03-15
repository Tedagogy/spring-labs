package com.revature.L1_calculator.Components;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * For the purpose of this application, the Squarer class is dependent on the functionality of the Multiplier class,
 * making this a dependency of Multiplier.
 *
 * This class is a potential bean that can be wired into another component
 * via dependency injection. A Bean is an object that is instantiated by Spring, rather than by the developer.
 * Dependency injection is the process of Spring inserting the instantiated Bean into another class.
 * "wiring" them together. This allows us to achieve loose coupling - we can switch which implementation of a class
 * we're currently using, or modify the existing classes we're using, while making less changes to the classes that
 * depend on this class.
 *
 * In future examples, rather than using the @Bean annotation, we could simply mark an entire class with @Component
 * annotation and leverage Component Scanning to automatically generate beans of the annotated class without any
 * configuration required.
 */
public class Multiplier {
    /**
     * The @Autowired annotation will inform Spring to automatically find the most appropriate bean to wire into this
     * class (based on the name & type of the Object used.) The @Autowired annotation can be used in 3 different ways:
     * constructor injection (above a constructor), setter injection (over a setter method), and field injection
     * (above the injected field declaration itself, as is done here).
     *
     * Generally, field injection is not recommended, but it works for this example.
     * @param adder
     */
    @Autowired
    Adder adder;

    /**
     * Instead of using the * operator normally, leverage the Adder dependency to multiply numbers the hard way,
     * manually - good thing Adder was autowired in!
     * @param a number 1
     * @param b number 2
     * @return a * b
     */
    public double multiply(double a, double b){
        double result = 0;
        for(int i = 0; i < b; i++){
            result = result + a;
        }
        return result;
    }
}
