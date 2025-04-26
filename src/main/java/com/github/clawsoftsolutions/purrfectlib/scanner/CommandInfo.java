package com.github.clawsoftsolutions.purrfectlib.scanner;

import java.util.List;

public class CommandInfo {
    private final String fullPath;
    private final String name;
    private final List<String> groups;
    private final Class<?> commandClass;

    public CommandInfo(String fullPath, String name, List<String> groups, Class<?> commandClass) {
        this.fullPath     = fullPath;
        this.name         = name;
        this.groups       = List.copyOf(groups);
        this.commandClass = commandClass;
    }

    public String getFullPath()       { return fullPath; }
    public String getName()           { return name; }
    public List<String> getGroups()   { return groups; }
    public Class<?> getCommandClass() { return commandClass; }

    @Override
    public String toString() {
        return "CommandInfo{" +
                "fullPath='" + fullPath + '\'' +
                ", commandClass=" + commandClass.getName() +
                '}';
    }
}
