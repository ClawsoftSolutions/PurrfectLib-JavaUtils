package com.github.clawsoftsolutions.purrfectlib.scanner;

import java.util.*;

/**
 * A registry for storing and retrieving discovered {@link CommandInfo} instances.
 * Commands are registered and looked up by their full slash-style path.
 */
public class CommandRegistry {
    private final Map<String, CommandInfo> byPath = new LinkedHashMap<>();

    /**
     * Registers a {@link CommandInfo} instance into the registry,
     * keyed by its full command path.
     *
     * @param info the command information to register
     */
    public void register(CommandInfo info) {
        byPath.put(info.getFullPath(), info);
    }

    /**
     * Looks up a command by its full path (e.g., {@code "taxpayers admin add"}).
     *
     * @param fullPath the full slash-style path of the command
     * @return an {@link Optional} containing the found {@link CommandInfo}, or empty if not found
     */
    public Optional<CommandInfo> get(String fullPath) {
        return Optional.ofNullable(byPath.get(fullPath));
    }

    /**
     * Retrieves all registered commands in their discovery (registration) order.
     *
     * @return an unmodifiable collection of all {@link CommandInfo} entries
     */
    public Collection<CommandInfo> all() {
        return Collections.unmodifiableCollection(byPath.values());
    }
}
