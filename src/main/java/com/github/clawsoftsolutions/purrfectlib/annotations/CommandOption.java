package com.github.clawsoftsolutions.purrfectlib.annotations;

import com.github.clawsoftsolutions.purrfectlib.enums.OptionType;

/**
 * Annotation to describe a single input option
 * for a slash command (such as a string, integer, etc).
 */
public @interface CommandOption {
    /**
     * @return The name of the option (used when users input it).
     */
    String name();

    /**
     * @return A description explaining the option to users.
     */
    String description();

    /**
     * @return The type of input expected for this option.
     */
    OptionType type();

    /**
     * @return Whether this option must be provided by the user.
     */
    boolean required() default false;
}
