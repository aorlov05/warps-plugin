package io.github.aorlov05.warps.command;

import io.github.aorlov05.warps.WarpsPlugin;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.util.StringUtil;

import java.util.ArrayList;
import java.util.List;

public class WarpTabCompleter implements TabCompleter {

    private WarpsPlugin plugin;

    public WarpTabCompleter(WarpsPlugin plugin) {
        this.plugin = plugin;
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String label, String[] args) {
        if (args.length != 1) {
            return null;
        }

        return StringUtil.copyPartialMatches(
                args[0],
                plugin.getWarpsData().getWarps().keySet(),
                new ArrayList<>());
    }

}
