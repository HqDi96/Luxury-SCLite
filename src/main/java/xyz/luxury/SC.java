package xyz.luxury;

import lombok.Getter;
import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.plugin.Command;
import net.md_5.bungee.api.plugin.Plugin;
import xyz.luxury.commands.SCCommand;
import xyz.luxury.commands.SCToggleCommand;
import xyz.luxury.utils.TextHelper;


@Getter
public enum SC {

    INSTANCE;

    private Plugin plugin;
    public static String Prefix = TextHelper.format("&8[&cSC&7-&aLITE&8]");
    public void start(final Plugin plugin) {
        this.plugin = plugin;
        getPlugin().getProxy().getConsole().sendMessage(ChatColor.GREEN+"StaffChat LITE has been by Luxury team has been enabled successfully.");


        Command[] commands = {
                new SCCommand(this.getPlugin()),
                new SCToggleCommand(this.getPlugin())
        };

        for (Command command : commands) {
            plugin.getProxy().getPluginManager().registerCommand(plugin, command);
        }
    }
}
