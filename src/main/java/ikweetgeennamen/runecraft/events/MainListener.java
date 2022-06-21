package ikweetgeennamen.runecraft.events;

import ikweetgeennamen.runecraft.core.PlayerData;
import ikweetgeennamen.runecraft.files.Skills;
import ikweetgeennamen.runecraft.utils.Utils;
import org.bukkit.Material;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.inventory.ItemStack;

public class MainListener implements Listener {


    @EventHandler
    public void OnDamage(EntityDamageByEntityEvent e)
    {
        Player p = (Player) e.getDamager();
        Player hitP = (Player) e.getEntity();

        p.sendMessage(Utils.chat(String.format(Utils.GetPrefix() + "&eYou are now in combat with {0}", hitP)));
    }

    @EventHandler
    public void OnLeave(PlayerQuitEvent e)
    {
      Player p = e.getPlayer();




    }



}
