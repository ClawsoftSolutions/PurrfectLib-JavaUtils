package com.clawsoftstudios.purrfectlib.manager;

import com.clawsoftstudios.purrfectlib.enums.OptionType;

/**
 * Abstract base for command managers that maps OptionTypes to whatever representation they need.
 */
public abstract class AbstractCommandManager {

    /**
     * Called to map an OptionType to whatever object/representation you want.
     * If not overridden for a specific OptionType, a warning will be shown.
     *
     * @param type The OptionType to map.
     * @return The mapped object, or null if unmapped.
     */
    public Object mapOption(OptionType type) {
        Object result = map(type);
        if (result == null) {
            handleUnmappedOption(type);
        }
        return result;
    }

    /**
     * Implement this method to define how your manager maps each OptionType.
     *
     * @param type The OptionType.
     * @return The mapped object or null if not handled.
     */
    protected abstract Object map(OptionType type);

    /**
     * Handles the case where an OptionType was not mapped.
     * Default is to print a warning. You can override if needed.
     *
     * @param type The unmapped OptionType.
     */
    protected void handleUnmappedOption(OptionType type) {
        System.out.println("[PurrfectLib] Warning: OptionType '" + type.name() + "' is not mapped.");
    }
}
