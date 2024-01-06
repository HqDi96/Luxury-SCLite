package xyz.luxury.commands;

import lombok.Getter;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.plugin.Command;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Plugin;
import xyz.luxury.SC;
import xyz.luxury.utils.TextHelper;

import java.util.HashSet;
import java.util.Set;

@Getter
public class SCToggleCommand extends Command {

    private final Plugin plugin;
    private static final Set<ProxiedPlayer> toggledPlayers = new HashSet<>();

    public SCToggleCommand(Plugin plugin) {
        super("staffchat toggle", "sc.toggle");
        this.plugin = plugin;
    }

    @Override
    public void execute(CommandSender sender, String[] args) {
        if (!(sender instanceof ProxiedPlayer)) {
            sender.sendMessage(SC.Prefix + "This command can only be used by players.");
            return;
        }

        ProxiedPlayer player = (ProxiedPlayer) sender;

        if (toggledPlayers.contains(player)) {
            toggledPlayers.remove(player);
            player.sendMessage(TextHelper.format(SC.Prefix + "&cYou have disabled toggling the staff chat successfully."));
        } else {
            toggledPlayers.add(player);
            player.sendMessage(TextHelper.format(SC.Prefix + "&aYou have toggled the staff chat successfully."));
        }
    }

    public static boolean isToggled(ProxiedPlayer player) {
        return toggledPlayers.contains(player);
    }
}
