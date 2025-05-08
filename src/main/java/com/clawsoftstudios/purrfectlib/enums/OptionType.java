package com.clawsoftstudios.purrfectlib.enums;

/**
 * Represents the different types of command options
 * available when defining slash commands or other user inputs.
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
    ATTACHMENT,

    /**
     * A long integer (64-bit), for large numeric values.
     */
    LONG,

    /**
     * A 64-bit floating point number.
     */
    DOUBLE,

    /**
     * A 32-bit floating point number.
     */
    FLOAT,

    /**
     * A predefined set of valid values.
     */
    ENUM,

    /**
     * A universally unique identifier (UUID).
     */
    UUID,

    /**
     * A calendar date, e.g., 2025-04-29.
     */
    DATE,

    /**
     * A clock time, e.g., 14:30.
     */
    TIME,

    /**
     * A full timestamp including date and time, e.g., 2025-04-29T14:30:00Z.
     */
    DATETIME,

    /**
     * A list of values (e.g., comma-separated or multi-select).
     */
    LIST,

    /**
     * A key-value pair structure (e.g., for config input).
     */
    MAP,

    /**
     * Raw JSON input (as a string or parsed object).
     */
    JSON,

    /**
     * A file system path string.
     */
    FILE_PATH,

    /**
     * A valid web address.
     */
    URL,

    /**
     * An email address string.
     */
    EMAIL,

    /**
     * A password field (should be masked).
     */
    PASSWORD
}
