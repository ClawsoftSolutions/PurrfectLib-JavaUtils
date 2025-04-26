package com.github.clawsoftsolutions.purrfectlib.enums;

/**
 * Represents the different types of command options
 * available when defining slash commands.
 */
public enum OptionType {
    /**
     * A simple text string.
     */
    STRING,

    /**
     * A whole number (e.g., 1, 42, -5).
     */
    INTEGER,

    /**
     * A boolean value (true/false).
     */
    BOOLEAN,

    /**
     * A user from the server (selected by mention or dropdown).
     */
    USER,

    /**
     * A text or voice channel from the server.
     */
    CHANNEL,

    /**
     * A role from the server.
     */
    ROLE,

    /**
     * A user, role, or everyone mentionable entity.
     */
    MENTIONABLE,

    /**
     * A decimal number (e.g., 3.14, -0.5).
     */
    NUMBER,

    /**
     * A file or image uploaded by the user.
     */
    ATTACHMENT
}

