package io.github.NolzCoding;

import io.github.NolzCoding.Commands.CommandManager;
import io.github.NolzCoding.Untils.Command;
import io.github.NolzCoding.Untils.FileDownload;
import org.bukkit.plugin.java.JavaPlugin;

import java.nio.file.Path;
import java.util.HashMap;
import java.util.Objects;
import java.util.logging.Logger;

public class Main extends JavaPlugin {

    private static final Logger log = Logger.getLogger("Minecraft");
    private CommandManager commandManager;
    private final Path path = getDataFolder().getAbsoluteFile().toPath().getParent();
    private FileDownload fileDownload;
    private static Main main;

    @Override
    public void onEnable() {
        main = this;
        fileDownload = new FileDownload(path);
        super.onEnable();
        commandManager = new CommandManager();
        setupCommands();

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
            Objects.requireNonNull(this.getCommand(key)).setExecutor(commandManager);
            Objects.requireNonNull(this.getCommand(key)).setTabCompleter(commandManager);
        }
    }

    public FileDownload getFileDownload() {
        return fileDownload;
    }

    public static Main getMain() {
        return main;
    }
}
