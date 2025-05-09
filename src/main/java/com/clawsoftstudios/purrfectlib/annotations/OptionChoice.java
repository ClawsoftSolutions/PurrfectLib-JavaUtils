package com.clawsoftstudios.purrfectlib.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Annotation to define possible choices for a command option.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.PARAMETER)
public @interface OptionChoice {
    /**
     * @return Display name for the choice.
     */
    String name();

    /**
     * @return Value to be sent in the payload.
     */
    String value();
}
