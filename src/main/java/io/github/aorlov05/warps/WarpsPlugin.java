package io.github.aorlov05.warps;

import io.github.aorlov05.warps.command.WarpAdminCommand;
import io.github.aorlov05.warps.command.WarpAdminTabCompleter;
import io.github.aorlov05.warps.command.WarpCommand;
import io.github.aorlov05.warps.command.WarpTabCompleter;
import org.bukkit.plugin.java.JavaPlugin;

public final class WarpsPlugin extends JavaPlugin {

    private WarpsData warpsData;

    @Override
    public void onEnable() {
        warpsData = new WarpsData(this);

        getCommand("warpadmin").setExecutor(new WarpAdminCommand(this));
        getCommand("warp").setExecutor(new WarpCommand(this));

        getCommand("warpadmin").setTabCompleter(new WarpAdminTabCompleter(this));
        getCommand("warp").setTabCompleter(new WarpTabCompleter(this));
    }

    @Override
    public void onDisable() {
        warpsData.save();
    }

    public WarpsData getWarpsData() {
        return warpsData;
    }

}
