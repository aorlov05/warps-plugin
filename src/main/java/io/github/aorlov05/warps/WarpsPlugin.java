package io.github.aorlov05.warps;

import org.bukkit.plugin.java.JavaPlugin;

public final class WarpsPlugin extends JavaPlugin {

    private WarpsData warpsData;

    @Override
    public void onEnable() {
        warpsData = new WarpsData(this);

        getCommand("warpadmin").setExecutor(new WarpAdminCommand(this));
    }

    @Override
    public void onDisable() {
        warpsData.save();
    }

    public WarpsData getWarpsData() {
        return warpsData;
    }

}
