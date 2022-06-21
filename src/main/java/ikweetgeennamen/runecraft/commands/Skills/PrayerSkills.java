package ikweetgeennamen.runecraft.commands.Skills;

import ikweetgeennamen.runecraft.core.PlayerData;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.EntityInteractEvent;

public class PrayerSkills {


    @EventHandler
    public void OnInteract(EntityInteractEvent e)
    {
        Player p = (Player) e.getEntity();
        PlayerData data = PlayerData.getPlayerData(p);

        if (e.getBlock().isEmpty())
        {
            return;
        }



    }



}
