package ikweetgeennamen.runecraft;

import ikweetgeennamen.runecraft.commands.SetLevelCommand;
import ikweetgeennamen.runecraft.commands.xpCommand;
import ikweetgeennamen.runecraft.core.PlayerData;
import ikweetgeennamen.runecraft.events.JoinEvent;
import ikweetgeennamen.runecraft.events.MainListener;
import ikweetgeennamen.runecraft.events.MiningSkill;
import ikweetgeennamen.runecraft.files.FileLoader;
import ikweetgeennamen.runecraft.files.FilerSaver;
import ikweetgeennamen.runecraft.utils.Utils;
import org.bukkit.Bukkit;
import org.bukkit.configuration.serialization.ConfigurationSerialization;
import org.bukkit.entity.Player;
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
        MiningSkill mining = new MiningSkill();
        getServer().getPluginManager().registerEvents(mainl, this);
        getServer().getPluginManager().registerEvents(joinl, this);
        getServer().getPluginManager().registerEvents(mining, this);
        getCommand("xp").setExecutor(new xpCommand());
        getCommand("level").setExecutor(new SetLevelCommand());

    }

    @Override
    public void onDisable() {
        getLogger().info(Utils.chat(Utils.GetPrefix() + "&4 has been disabled"));
        FilerSaver.savePlayerData();
        for (Player p : Bukkit.getOnlinePlayers())
            PlayerData.getPlayerData(p).updatePlayer();
    }





}
