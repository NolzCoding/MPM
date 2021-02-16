package io.github.NolzCoding.Commands;

import io.github.NolzCoding.Main;
import io.github.NolzCoding.Untils.Command;
import io.github.NolzCoding.Untils.FileDownload;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class MPMCommand implements Command {

    private final String name;
    private final Main main = Main.getMain();
    private final FileDownload fileDownload = main.getFileDownload();

    public MPMCommand(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public boolean onCommand(CommandSender commandSender, org.bukkit.command.Command command, String s, String[] strings) {

        if (!(strings.length == 2)) { err(commandSender, "Invalid args"); return true;}

        String arg1 = strings[0].toLowerCase(Locale.ROOT);
        switch (arg1) {
            case "i":
                String arg2 = strings[1];
                String string = fileDownload.toBukkitURL(arg2);
                if (!fileDownload.downloadFile(string, arg2)) {
                    commandSender.sendMessage(ChatColor.GREEN + "Successfully downloaded " + arg2);
                } else {
                    err(commandSender, "Could not download " + arg2);
                }
                return true;
            case "r":
                return true;
        }

        err(commandSender, "Invalid args");
        return true;
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, org.bukkit.command.Command command, String alias, String[] args) {
        ArrayList<String> list = new ArrayList<>();
        if (args.length == 1) {
            list.add("i");
            list.add("r");
        }
        return list;
    }

    private void err(CommandSender commandSender, String message) {
        commandSender.sendMessage(ChatColor.RED + message);
    }

}
