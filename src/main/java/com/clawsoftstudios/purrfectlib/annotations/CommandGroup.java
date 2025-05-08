package com.clawsoftstudios.purrfectlib.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Annotation to define a logical group for commands
 * based on their package hierarchy.
 * <p>
 * Applied to a package, not a class.
 */
@Target(ElementType.PACKAGE)
@Retention(RetentionPolicy.RUNTIME)
public @interface CommandGroup {
    /**
     * @return The display name of the command group.
     */
    String value();
}
