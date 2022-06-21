package ikweetgeennamen.runecraft.events;

import ikweetgeennamen.runecraft.core.PlayerData;
import ikweetgeennamen.runecraft.files.FilerSaver;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;



public class JoinEvent implements Listener {



    @EventHandler
    public void OnJoin(PlayerJoinEvent e) {
        Player p = e.getPlayer();
        PlayerData data = PlayerData.getPlayerData(p);
        data.updatePlayer();
        FilerSaver.savePlayerData();
    }

    @EventHandler
    public void onLeave(PlayerQuitEvent e)
    {
        PlayerData data = PlayerData.getPlayerData(e.getPlayer());
        data.updatePlayer();
        FilerSaver.savePlayerData();
    }
}
