package io.github.NolzCoding.Commands;

import org.bukkit.Server;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import java.util.HashMap;

public class CommandManager implements CommandExecutor {

    private final HashMap<String, io.github.NolzCoding.Untils.Command> commandMap;

    public CommandManager() {
        commandMap = new HashMap<>();
        
    }

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {

        return false;
    }
}
