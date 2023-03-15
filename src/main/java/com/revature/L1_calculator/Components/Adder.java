package com.revature.L1_calculator.Components;

/**
 * For the purpose of this application, the multiplier class is dependent on the functionality of the Adder class,
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
 *
 * There is no need to change anything within this class.
 */
public class Adder {
    /**
     * Return the sum of two numbers.
     * @param a number 1
     * @param b number 2
     * @return a + b
     */
    public double add(double a, double b){
        return a + b;
    }
}
