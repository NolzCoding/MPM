package io.github.NolzCoding.Commands;

import io.github.NolzCoding.Untils.Command;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

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

        if (!(strings.length == 2)) { invalidargs(commandSender);return true;}

        String arg1 = strings[0].toLowerCase(Locale.ROOT);
        switch (arg1) {
            case "i":
                String arg2 = strings[1];

                return true;
            case "r":
                return true;
        }

        invalidargs(commandSender);
        return true;
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, org.bukkit.command.Command command, String alias, String[] args) {
        ArrayList<String> list = new ArrayList<>();
        if (args.length == 0) {
            list.add("i");
            list.add("r");
        }
        return list;
    }

    private void invalidargs(CommandSender commandSender) {
        commandSender.sendMessage(ChatColor.RED + "Invalid agruments");
    }
}
