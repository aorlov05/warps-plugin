package io.github.aorlov05.warps;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

public class WarpsData {

    private File file;
    private FileConfiguration config;

    public WarpsData(WarpsPlugin plugin) {
        file = new File(plugin.getDataFolder(), "warps.yml");
        if (!file.exists()) {
            file.getParentFile().mkdirs();
            plugin.saveResource("warps.yml", false);
        }

        config = YamlConfiguration.loadConfiguration(file);
    }

    public void save() {
        try {
            config.save(file);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
