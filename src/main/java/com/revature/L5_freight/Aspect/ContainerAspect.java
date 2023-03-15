package com.revature.L5_freight.Aspect;

import org.aspectj.lang.annotation.Aspect;

/**
 * Spring AOP (aspect-oriented-programming) is a Spring module that addresses the problem of repetitive code in our
 * application.
 *
 * When a similar pattern of code is used across multiple methods in the application, it is a cross-cutting concern:
 * for instance, logging all web requests to a logging file, ensuring that a User is logged in before certain actions
 * can be performed, or starting and committing database transactions are all cross-cutting concerns, because they are
 * all some pattern of code that is applied across multiple parts of the application. AOP allows us to separate
 * these cross-cutting concerns into their own method, which can then be re-applied to the relevant methods by Spring.
 *
 * Because of this, AOP helps with code reuse, the DRY (don't-repeat-yourself) principle, and allows for faster
 * development when cross-cutting-concern need to be modified.
 */
@Aspect
public class ContainerAspect {
    /**
     * TODO: Write Advice that should be applied Before any method in ContainerService executes that prints to the
     * console every time a method is executed, another Advice that should be applied After any method in
     * ContainerService throws an exception. Look into the ShipAspect class to see how the appropriate Pointcut
     * expression and Advice method should be written.
     *
     * This task does not have test cases. You should test it manually by using the Freight API once all other parts
     * of the application are complete.
     */
}
