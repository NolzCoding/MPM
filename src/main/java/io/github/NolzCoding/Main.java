package io.github.NolzCoding;

import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Logger;

public class Main extends JavaPlugin {

    private static final Logger log = Logger.getLogger("Minecraft");

    @Override
    public void onEnable() {
        super.onEnable();
        log.info(String.format("[%s] - Successfully enabled",
                getDescription().getName()));
    }

    @Override
    public void onDisable() {
        super.onDisable();
    }
}
