package io.github.NolzCoding;

import io.github.NolzCoding.Commands.CommandManager;
import io.github.NolzCoding.Untils.Command;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashMap;
import java.util.Objects;
import java.util.logging.Logger;

public class Main extends JavaPlugin {

    private static final Logger log = Logger.getLogger("Minecraft");
    private CommandManager commandManager;

    @Override
    public void onEnable() {
        commandManager = new CommandManager();
        setupCommands();
        super.onEnable();
        log.info(String.format("[%s] - Successfully enabled",
                getDescription().getName()));
    }

    @Override
    public void onDisable() {
        super.onDisable();
    }

    private void setupCommands() {
        HashMap<String, Command> hashMap = commandManager.getCommandMap();
        for (String key : hashMap.keySet()) {
            Objects.requireNonNull(getCommand(key)).setExecutor(commandManager);
            Objects.requireNonNull(getCommand(key)).setTabCompleter(commandManager);
        }
    }

}
