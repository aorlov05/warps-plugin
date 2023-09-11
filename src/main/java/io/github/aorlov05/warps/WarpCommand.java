package io.github.aorlov05.warps;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class WarpCommand implements CommandExecutor {

    private WarpsPlugin plugin;

    public WarpCommand(WarpsPlugin plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player player)) {
            sender.sendMessage(ChatColor.RED + "You can only use this command in-game!");
            return false;
        }

        if (args.length != 1) {
            player.sendMessage(ChatColor.YELLOW + "List of Warps:");
            for (String warpName : plugin.getWarpsData().getWarps().keySet()) {
                player.sendMessage(ChatColor.YELLOW + " - " + warpName);
            }

            return false;
        }

        Location warpLoc = plugin.getWarpsData().getWarp(args[0]);
        if (warpLoc == null) {
            player.sendMessage(ChatColor.RED + "That is not a valid warp!");
            return false;
        }

        player.teleport(warpLoc);
        player.sendMessage(ChatColor.GREEN + "Sent you to warp " + args[0] + "!");
        return true;
    }

}
