package main.java.steps.technical;


import main.java.core.annotations.Injections;

/**
 * TECHNICAL: Parent class of all Step Definition classes.
 */
public class CucumberSteps {

    protected CucumberSteps() {
        Injections.inject(this);
    }

}
