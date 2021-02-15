package io.github.NolzCoding.Untils;

import org.bukkit.command.CommandSender;

public interface Command {
    String name = null;
    String getName();
    boolean onCommand(CommandSender commandSender, org.bukkit.command.Command command, String s, String[] strings);
}
