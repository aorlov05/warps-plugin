package io.github.aorlov05.warps.command;

import io.github.aorlov05.warps.WarpsPlugin;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.util.StringUtil;

import java.util.ArrayList;
import java.util.List;

public class WarpAdminTabCompleter implements TabCompleter {

    private WarpsPlugin plugin;

    public WarpAdminTabCompleter(WarpsPlugin plugin) {
        this.plugin = plugin;
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String label, String[] args) {
        if (args.length != 2 || !args[0].equalsIgnoreCase("delete")) {
            return null;
        }

        return StringUtil.copyPartialMatches(
                args[1],
                plugin.getWarpsData().getWarps().keySet(),
                new ArrayList<>());
    }

}
