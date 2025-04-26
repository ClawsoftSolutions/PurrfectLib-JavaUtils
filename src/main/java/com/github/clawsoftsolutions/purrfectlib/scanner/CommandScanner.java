package com.github.clawsoftsolutions.purrfectlib.scanner;

import com.github.clawsoftsolutions.purrfectlib.annotations.Command;
import com.github.clawsoftsolutions.purrfectlib.annotations.CommandGroup;
import io.github.classgraph.*;

import java.util.*;

/**
 * Scans packages for @Command and @CommandGroup annotations,
 * and generates a list of CommandInfo entries.
 */
public class CommandScanner {

    private final String basePackage;

    /**
     * Creates a new CommandScanner.
     *
     * @param basePackage The root package to start scanning from.
     */
    public CommandScanner(String basePackage) {
        this.basePackage = basePackage;
    }

    /**
     * Scans for command classes and command group packages.
     *
     * @return A list of discovered CommandInfo objects.
     */
    public List<CommandInfo> scanCommands() {
        Map<String, String> pkgToGroup = new HashMap<>();

        // First, find all @CommandGroup annotations
        try (ScanResult pkgScan = new ClassGraph()
                .enableAllInfo()
                .acceptPackages(basePackage)
                .scan())
        {
            for (PackageInfo pInfo : pkgScan.getPackageInfo()) {
                for (AnnotationInfo ai : pInfo.getAnnotationInfo()) {
                    if (ai.getName().equals(CommandGroup.class.getName())) {
                        String groupName = ai.getParameterValues()
                                .getValue("value")
                                .toString();
                        pkgToGroup.put(pInfo.getName(), groupName);
                    }
                }
            }
        }

        List<CommandInfo> results = new ArrayList<>();

        // Then, find all @Command classes
        try (ScanResult cmdScan = new ClassGraph()
                .enableAllInfo()
                .acceptPackages(basePackage)
                .scan())
        {
            int baseDepth = basePackage.split("\\.").length;
            for (ClassInfo cInfo : cmdScan.getClassesWithAnnotation(Command.class.getName())) {
                AnnotationInfo cmdAnn = cInfo.getAnnotationInfo(Command.class.getName());
                String cmdName = cmdAnn.getParameterValues()
                        .getValue("name")
                        .toString();

                String pkg = cInfo.getPackageName();
                String[] parts = pkg.split("\\.");
                List<String> groups = new ArrayList<>();

                // Match the package tree to build group names
                for (int i = baseDepth + 1; i <= parts.length; i++) {
                    String sub = String.join(".", Arrays.copyOf(parts, i));
                    if (pkgToGroup.containsKey(sub)) {
                        groups.add(pkgToGroup.get(sub));
                    }
                }

                String fullPath = "/" +
                        (groups.isEmpty() ? "" : String.join(" ", groups) + " ")
                        + cmdName;

                Class<?> clazz;
                try {
                    clazz = Class.forName(cInfo.getName());
                } catch (ClassNotFoundException e) {
                    continue;
                }

                results.add(new CommandInfo(fullPath.trim(), cmdName, groups, clazz));
            }
        }

        return results;
    }
}
