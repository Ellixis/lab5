package app;

import commands.Command;
import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

public class CommandManager {
    private Map<String, Command> commands = new HashMap<>();

    public void registerCommand(String key, Command command) {
        commands.put(key, command);
    }
    public Command getCommandByKey(String key) {
        return commands.get(key);
    }
    public Map<String, Command> getCommands() {
        return commands;
    }
}
