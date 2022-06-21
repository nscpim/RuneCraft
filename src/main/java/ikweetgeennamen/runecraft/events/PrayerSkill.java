package ikweetgeennamen.runecraft.events;

import ikweetgeennamen.runecraft.core.PlayerData;
import ikweetgeennamen.runecraft.files.FilerSaver;
import ikweetgeennamen.runecraft.files.Skills;
import ikweetgeennamen.runecraft.utils.Utils;
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

      switch(e.getItem().getType())
      {
          case BONE:
              data.getPlayer();
              if (p.getInventory().contains(Material.BONE))
              {
                  p.getInventory().removeItem(new ItemStack(Material.BONE, 1));
                  data.addXP(5, data.getSkill(Skills.Prayer));
                  FilerSaver.savePlayerData();
              }
              else
                  {
                     p.sendMessage(Utils.chat(Utils.GetPrefix() + "&cYou do not have any bones in your inventory"));
                  }



              break;
          default:
              break;
      }



    }
}
