package xyz.luxury.commands;

import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.plugin.Command;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Plugin;
import xyz.luxury.SC;
import xyz.luxury.utils.TextHelper;

public class SCCommand extends Command {

    public SCCommand(Plugin plugin) {
        super("staffchat", "sc.permission");
        this.plugin = plugin;
    }

    private final Plugin plugin;

    @Override
    public void execute(CommandSender sender, String[] args) {
        if (!(sender instanceof ProxiedPlayer)) {
            sender.sendMessage("This command can only be used by players.");
            return;
        }

        ProxiedPlayer player = (ProxiedPlayer) sender;

        if (args.length == 0) {
            player.sendMessage(TextHelper.format(" &8[&cSC&7-&aLITE&8]\n» &e/sc - /staffchat &8[&7message&8]\n» &e/sc toggle - /staffchat toggle"));
        } else {
            StringBuilder message = new StringBuilder();
            for (String arg : args) {
                message.append(arg).append(" ");
            }

            String staffChatMessage = TextHelper.format(SC.Prefix+" "+"» " + "&a" + player.getName() + " " + "&8»" + " " + message.toString().trim());

            for (ProxiedPlayer staff : plugin.getProxy().getPlayers()) {
                if (staff.hasPermission("sc.permission") || staff.hasPermission("bungeecord.command.server") || staff.hasPermission("sc.see")) {
                    staff.sendMessage(staffChatMessage);
                }
            }
        }
    }
}
