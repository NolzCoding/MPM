package io.github.NolzCoding.Commands;

import io.github.NolzCoding.Untils.Command;
import org.bukkit.command.CommandSender;

public class MPMCommand implements Command {

    private final String name;

    public MPMCommand(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public boolean onCommand(CommandSender commandSender, org.bukkit.command.Command command, String s, String[] strings) {



        return false;
    }
}
