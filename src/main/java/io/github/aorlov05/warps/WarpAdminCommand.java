package io.github.aorlov05.warps;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class WarpAdminCommand implements CommandExecutor {

    private WarpsPlugin plugin;

    public WarpAdminCommand(WarpsPlugin plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player player)) {
            sender.sendMessage(ChatColor.RED + "You can only use this command in-game!");
            return false;
        }

        if (args.length == 0) {
            sender.sendMessage(ChatColor.YELLOW + "Admin Warp Commands: /warpadmin set|delete [name]");
            return false;
        } else if (args.length != 2) {
            sender.sendMessage(ChatColor.RED + "Invalid usage! Commands: /warpadmin set|delete [name]");
            return false;
        }

        if (args[0].equalsIgnoreCase("set")) {
            boolean warpAdded = plugin.getWarpsData().addWarp(args[1], player.getLocation());
            if (!warpAdded) {
                player.sendMessage(ChatColor.RED + "That warp name already exists!");
                return false;
            }

            player.sendMessage(ChatColor.GREEN + "Created warp " + args[1] + "!");
        } else if (args[0].equalsIgnoreCase("delete")) {
            boolean warpExists = plugin.getWarpsData().removeWarp(args[1]);
            if (!warpExists) {
                player.sendMessage(ChatColor.RED + "There is no warp with that name!");
                return false;
            }

            player.sendMessage(ChatColor.GREEN + "Successfully removed warp " + args[1] + "!");
        }

        return true;
    }

}
