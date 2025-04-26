package com.github.clawsoftsolutions.purrfectlib.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Annotation to mark a class as a command handler.
 * <p>
 * Each command must have a name, a description, and can optionally belong to a group
 * and define options for user input.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface Command {
    /**
     * @return The name of the command (shown to users).
     */
    String name();

    /**
     * @return A short description of what the command does.
     */
    String description();

    /**
     * @return The group the command belongs to (optional).
     */
    String group() default "";

    /**
     * @return An array of options (arguments) the command accepts.
     */
    CommandOption[] options() default {};
}
