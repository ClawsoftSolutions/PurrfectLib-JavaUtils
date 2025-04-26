package com.github.clawsoftsolutions.purrfectlib.scanner;

import java.util.LinkedList;
import java.util.List;

/**
 * Represents metadata about a registered command.
 */
public class CommandInfo {
    private final String fullPath;
    private final String name;
    private final LinkedList<String> groups;
    private final Class<?> commandClass;

    /**
     * Constructs a new CommandInfo.
     *
     * @param fullPath The full slash path (e.g., /admin ban).
     * @param name The short name of the command.
     * @param groups All groups the command belongs to.
     * @param commandClass The class implementing the command logic.
     */
    public CommandInfo(String fullPath, String name, List<String> groups, Class<?> commandClass) {
        this.fullPath     = fullPath;
        this.name         = name;
        this.groups       = new LinkedList<>(groups);
        this.commandClass = commandClass;
    }

    /**
     * @return The full slash path of the command.
     */
    public String getFullPath() {
        return fullPath;
    }

    /**
     * @return The short name of the command.
     */
    public String getName() {
        return name;
    }

    /**
     * @return A list of all groups the command belongs to.
     */
    public LinkedList<String> getGroups() {
        return new LinkedList<>(groups);
    }

    /**
     * @return The class that handles the command execution.
     */
    public Class<?> getCommandClass() {
        return commandClass;
    }

    /**
     * Returns all subgroup names following the specified group.
     *
     * @param group The group name to start from.
     * @return A list of subgroup names after the given group.
     */
    public LinkedList<String> getSubGroups(String group) {
        int idx = groups.indexOf(group);
        if (idx >= 0 && idx + 1 < groups.size()) {
            return new LinkedList<>(groups.subList(idx + 1, groups.size()));
        }
        return new LinkedList<>();
    }

    @Override
    public String toString() {
        return "CommandInfo{" +
                "fullPath='" + fullPath + '\'' +
                ", commandClass=" + commandClass.getName() +
                '}';
    }
}
