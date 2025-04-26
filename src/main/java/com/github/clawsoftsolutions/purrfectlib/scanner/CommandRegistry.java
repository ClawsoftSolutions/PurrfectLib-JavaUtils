package com.github.clawsoftsolutions.purrfectlib.scanner;

import java.util.*;

public class CommandRegistry {
    private final Map<String,CommandInfo> byPath = new LinkedHashMap<>();

    /** Register a command (keyed by its fullPath). */
    public void register(CommandInfo info) {
        byPath.put(info.getFullPath(), info);
    }

    /** Lookup by full slash‐path (e.g. "taxpayers admin add"). */
    public Optional<CommandInfo> get(String fullPath) {
        return Optional.ofNullable(byPath.get(fullPath));
    }

    /** All registered commands, in discovery order. */
    public Collection<CommandInfo> all() {
        return Collections.unmodifiableCollection(byPath.values());
    }
}

