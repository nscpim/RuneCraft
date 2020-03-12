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
import org.bukkit.inventory.ItemStack;

public class MainListener implements Listener {



    @EventHandler
    public void OnMine(BlockBreakEvent e)
    {
        Player p = e.getPlayer();
        PlayerData data = PlayerData.getPlayerData(p);

        e.setCancelled(true);

        switch(e.getBlock().getBlockData().getMaterial())
        {
            case COAL_ORE:
                if (p.getMainHand().equals(Material.DIAMOND_PICKAXE))
                {
                    data.addXP(15, Skills.Mining);
                    p.sendTitle(Utils.chat("&7Mining"),Utils.chat("&a+15xp"),30, 20,30);
                    p.sendMessage(Utils.chat(Utils.GetPrefix() + "&7You mined some coal ore."));
                }
                else
            {
                p.sendMessage(Utils.chat(Utils.GetPrefix() + "&cYou need a pickaxe to mine here"));
            }
                break;
        }
    }


}
