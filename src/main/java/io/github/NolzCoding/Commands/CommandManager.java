package io.github.NolzCoding.Commands;

import org.bukkit.Server;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import java.util.HashMap;
import java.util.Locale;

public class CommandManager implements CommandExecutor {

    private final HashMap<String, io.github.NolzCoding.Untils.Command> commandMap;

    public CommandManager() {
        commandMap = new HashMap<>();
        commandMap.put("mpm", new MPMCommand("mpm"));
    }

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        String cmd = command.getName().toLowerCase(Locale.ROOT);
        if (commandMap.containsKey(cmd)) {
            return commandMap.get(cmd).onCommand(commandSender, command, s, strings);
        }
        return false;
    }
}
