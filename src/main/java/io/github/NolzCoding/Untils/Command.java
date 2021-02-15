package io.github.NolzCoding.Untils;

import org.bukkit.command.CommandSender;

import java.util.List;

public interface Command {
    String name = null;
    String getName();
    boolean onCommand(CommandSender commandSender, org.bukkit.command.Command command, String s, String[] strings);
    List<String> onTabComplete(CommandSender sender, org.bukkit.command.Command command, String alias, String[] args);
}
