package io.github.aorlov05.warps;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class WarpAdminCommand implements CommandExecutor {

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
            // TODO Implement adding warp
        } else if (args[0].equalsIgnoreCase("delete")) {
            // TODO Implement deleting warp
        }

        return true;
    }

}
