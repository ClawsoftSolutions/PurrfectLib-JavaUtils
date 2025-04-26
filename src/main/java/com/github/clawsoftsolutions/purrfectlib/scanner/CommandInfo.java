package com.github.clawsoftsolutions.purrfectlib.scanner;

import java.util.LinkedList;
import java.util.List;

public class CommandInfo {
    private final String fullPath;
    private final String name;
    private final LinkedList<String> groups;
    private final Class<?> commandClass;

    public CommandInfo(String fullPath, String name, List<String> groups, Class<?> commandClass) {
        this.fullPath     = fullPath;
        this.name         = name;
        this.groups       = new LinkedList<>(groups);
        this.commandClass = commandClass;
    }

    public String getFullPath() {
        return fullPath;
    }

    public String getName() {
        return name;
    }

    /**
     * Returns a LinkedList of all groups; allows getFirst()/getLast().
     */
    public LinkedList<String> getGroups() {
        return new LinkedList<>(groups);
    }

    public Class<?> getCommandClass() {
        return commandClass;
    }

    /**
     * Returns a LinkedList of subgroups that follow the specified group.
     * If the group isn't found or has no following elements, returns empty list.
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
