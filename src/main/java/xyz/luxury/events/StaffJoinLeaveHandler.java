package xyz.luxury.events;

import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Listener;
import xyz.luxury.utils.TextHelper;

public class StaffJoinLeaveHandler implements Listener {

    public static void sendJoinMessage(ProxiedPlayer player) {
        if (player.hasPermission("sc.admin") || player.hasPermission("sc.permission") || player.hasPermission("sc.toggle")) {
            player.sendMessage(TextHelper.format("&8[&a + &8] "+" " + ChatColor.RESET + player.getName() +" "+ " &7has joined the server."));
        }
    }

    public static void sendLeaveMessage(ProxiedPlayer player) {
        if (player.hasPermission("sc.admin") || player.hasPermission("sc.permission") || player.hasPermission("sc.toggle")) {
            player.sendMessage(TextHelper.format("&8[&c - &8] "+" "+ ChatColor.RESET + player.getName() +" "+ " &7has left the server."));
        }
    }
}
