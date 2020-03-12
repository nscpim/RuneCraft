package ikweetgeennamen.runecraft;

import ikweetgeennamen.runecraft.commands.xpCommand;
import ikweetgeennamen.runecraft.core.PlayerData;
import ikweetgeennamen.runecraft.events.JoinEvent;
import ikweetgeennamen.runecraft.events.MainListener;
import ikweetgeennamen.runecraft.files.FileLoader;
import ikweetgeennamen.runecraft.files.FilerSaver;
import ikweetgeennamen.runecraft.utils.Utils;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandExecutor;
import org.bukkit.configuration.serialization.ConfigurationSerialization;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

public class RuneCraft extends JavaPlugin {

    public static RuneCraft plugin;

    public static RuneCraft GetPlugin()
    {
        return plugin;
    }

    @Override
    public void onEnable() {
        getLogger().info(Utils.chat(Utils.GetPrefix() + "&a has been enabled"));
        ConfigurationSerialization.registerClass(PlayerData.class);
        new FileLoader();
        MainListener mainl = new MainListener();
        JoinEvent joinl = new JoinEvent();
        getServer().getPluginManager().registerEvents(mainl, this);
        getServer().getPluginManager().registerEvents(joinl, this);
        getCommand("xp").setExecutor(new xpCommand());

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        getLogger().info(Utils.chat(Utils.GetPrefix() + "&4 has been disabled"));
        FilerSaver.savePlayerData();
        for (Player p : Bukkit.getOnlinePlayers())
            PlayerData.getPlayerData(p).updatePlayer();
    }





}
