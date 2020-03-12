package ikweetgeennamen.runecraft.events;

import ikweetgeennamen.runecraft.core.PlayerData;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

public class PrayerSkill implements Listener {


    @EventHandler
    public void OnBury(PlayerInteractEvent e)
    {
      Player p = e.getPlayer();
      PlayerData data = PlayerData.getPlayerData(p);


      if (e.getItem().getType() == Material.BONE)
      {
          p.getInventory().removeItem(new ItemStack().);
      }
    }
}
