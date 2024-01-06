package xyz.luxury.commands;

import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;
import net.md_5.bungee.api.plugin.Plugin;
import xyz.luxury.utils.TextHelper;

import java.util.HashSet;
import java.util.Set;

public class AdminToggleCommand extends Command {

    private final Plugin plugin;
    private static final Set<ProxiedPlayer> toggledPlayers = new HashSet<>();

    public AdminToggleCommand(Plugin plugin) {
        super("adminchat toggle", "sc.admin");
        this.plugin = plugin;
    }

    @Override
    public void execute(CommandSender sender, String[] args) {
        if (!(sender instanceof ProxiedPlayer)) {
            sender.sendMessage( "This command can only be used by players.");
            return;
        }

        ProxiedPlayer player = (ProxiedPlayer) sender;

        if (toggledPlayers.contains(player)) {
            toggledPlayers.remove(player);
            player.sendMessage(TextHelper.format( "&cYou have disabled toggling the admin chat successfully."));
        } else {
            toggledPlayers.add(player);
            player.sendMessage(TextHelper.format( "&aYou have toggled the admin chat successfully."));
        }
    }

    public static boolean isToggled(ProxiedPlayer player) {
        return toggledPlayers.contains(player);
    }
}
