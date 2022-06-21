package ikweetgeennamen.runecraft.commands;


import ikweetgeennamen.runecraft.RuneCraft;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.Plugin;

public class ReloadCommand implements CommandExecutor {


    public RuneCraft plugin;

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender.hasPermission("runecraft.reload"))
        {
          Plugin plugin = Bukkit.getPluginManager().getPlugin("RuneCraft");
          plugin.reloadConfig();
        }
        return false;
    }
}
