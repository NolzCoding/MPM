package io.github.NolzCoding.Commands;

import org.bukkit.Server;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;

import java.util.HashMap;
import java.util.List;
import java.util.Locale;

public class CommandManager implements TabCompleter,CommandExecutor {

    private final HashMap<String, io.github.NolzCoding.Untils.Command> commandMap;

    public HashMap<String, io.github.NolzCoding.Untils.Command> getCommandMap() {
        return commandMap;
    }

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

    @Override
    public List<String> onTabComplete(CommandSender commandSender, Command command, String s, String[] strings) {
        String cmd = command.getName().toLowerCase(Locale.ROOT);
        if (commandMap.containsKey(cmd)) {
            return commandMap.get(cmd).onTabComplete(commandSender, command, s, strings);
        }
        return null;
    }
}
