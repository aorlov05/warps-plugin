package io.github.aorlov05.warps;

import org.bukkit.Location;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class WarpsData {

    private File file;
    private FileConfiguration config;
    private Map<String, Location> warps;

    public WarpsData(WarpsPlugin plugin) {
        file = new File(plugin.getDataFolder(), "warps.yml");
        if (!file.exists()) {
            file.getParentFile().mkdirs();
            plugin.saveResource("warps.yml", false);
        }

        config = YamlConfiguration.loadConfiguration(file);

        warps = new HashMap<>();
        if (!config.isConfigurationSection("warps")) {
            return;
        }

        for (String warp : config.getConfigurationSection("warps").getKeys(false)) {
            warps.put(warp, config.getLocation("warps." + warp));
        }
    }

    public boolean addWarp(String name, Location location) {
        if (warps.containsKey(name)) {
            return false;
        }

        warps.put(name, location);
        return true;
    }

    public boolean removeWarp(String name) {
        return warps.remove(name) != null;
    }

    public void save() {
        config.set("warps", null);
        for (Map.Entry<String, Location> warp : warps.entrySet()) {
            config.set("warps." + warp.getKey(), warp.getValue());
        }

        try {
            config.save(file);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public Map<String, Location> getWarps() {
        return warps;
    }

}
