package xyz.luxury.commands;

import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.plugin.Command;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Plugin;
import xyz.luxury.utils.TextHelper;

public class SCCommand extends Command {

    private final Plugin plugin;

    public SCCommand(Plugin plugin) {
        super("staffchat", "sc.permission");
        this.plugin = plugin;
    }

    @Override
    public void execute(CommandSender sender, String[] args) {
        if (!(sender instanceof ProxiedPlayer)) {
            sender.sendMessage("This command can only be used by players.");
            return;
        }

        ProxiedPlayer player = (ProxiedPlayer) sender;

        if (args.length == 0) {
            player.sendMessage(TextHelper.format("&6StaffChat &aLITE &bb0.1\n» &e/sc - /staffchat &8(&7message&8)&f - Sends a message to the staff crews.\n» &e/sc toggle - /staffchat toggle &f- Toggles the staff chat.\n» &e/adminchat &8(&7message&8) &f- Sends a message to the admin crews.\n» &e/adminchat toggle &f - Toggles the admin chat. "));
        } else {
            StringBuilder message = new StringBuilder();
            for (String arg : args) {
                message.append(arg).append(" ");
            }

            String staffChatMessage = TextHelper.format("&8[ &c&lSTAFFCHAT &8] "+"» " + "&f" + player.getName() + " " + "&8➟" + "&f" + message.toString().trim());

            for (ProxiedPlayer staff : plugin.getProxy().getPlayers()) {
                if ((staff.hasPermission("sc.permission") || staff.hasPermission("bungeecord.command.server") || staff.hasPermission("sc.see")) &&
                        SCToggleCommand.isToggled(player)) {
                    staff.sendMessage(staffChatMessage);
                    return;
                }
            }
        }
    }
}
